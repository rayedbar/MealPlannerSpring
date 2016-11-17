/**
 * Created by rayed on 10/27/16.
 */

// Dish js begins

$('#viewDishList').click(function () {
    viewDishList();
});

function viewDishList() {
    $('#sectionHeader').text('Dish List');

    $(".active").removeClass("active");

    $("#viewDishList").addClass("active");

    var $tableDiv = $("#tableDiv");
    $tableDiv.empty();

    var $table = $("<table>");
    $table.addClass("table table-striped");
    $table.attr('id', "displayTable");
    $table.append($('<tbody>'));

    $tableDiv.append($table);

//   $.get("/usr/get", function (user_email) {
        var userEmail = "admin@gmail.com";
        $.get("/dish/view", function (responseJson) {
//            alert(responseJson);
            $.each(responseJson, function (index, dish) {
                var dishId = dish.id;
                var row = $("<tr>").appendTo($table);
                row.append($("<td>").text(index + 1))
                    .append($("<td>").text(dish.name));
                if (userEmail == "admin@gmail.com") {
                    row.append($("<td>").append($("<label id='deleteDishLabel'>").text("Delete").data("dish-id", dishId)));
                    row.append($("<td>").append($("<label id='editDishLabel'>").text("Edit").data("dish-info", {first: dishId, second: dish.name})));
                }
            });
        });
//   });
}

function editDish(dishId, dishName) {
    $("#tableDiv").empty();

    $.get("/dish/editDishForm", {dishId: dishId}, function(response) {
        $("#tableDiv").append(response);
    });

    $("#sectionHeader").text("Enter new dish name for " + dishName);
}

$("#tableDiv").on("click", '#deleteDishLabel', function () {
    var dishId = $(this).data("dish-id");
    deleteDish(dishId);
})

function deleteDish(dishId) {
    $.get("/dish/delete", {dishId: dishId}, function(){
        viewDishList();
    });
}

$("#tableDiv").on("click", '#editDishLabel', function () {
    var dishId = $(this).data("dish-info").first;
    var dishName = $(this).data("dish-info").second;
    editDish(dishId, dishName);
});

function addDish() {
    $("#tableDiv").empty();
    $("#tableDiv").load("/dish/addDishForm");
}

$("#addDish").click(function(){
      addDish();
});

// Dish js ends

// Meal js begins

function viewMealList() {
    $('#sectionHeader').text('Meal List');

    $(".active").removeClass("active");

    $("#viewMealList").addClass("active");

    var $tableDiv = $("#tableDiv");
    $tableDiv.empty();

    var $table = $("<table>");
    $table.addClass("table table-striped");
    $table.attr('id', "displayTable");
    $table.append($('<tbody>'));

    $tableDiv.append($table);

    $.get("/meal/view", function (responseJson) {
        $.each(responseJson, function (i, meal) {
            var row = $("<tr>").appendTo($table);
            row.append($("<td>").text(i + 1))
                .append($("<td>").text(meal.day))
                .append($("<td>").text(meal.type));
            var data = ($("<td>")).appendTo(row);
            $.each(meal.dishList, function (i, dish) {
                if (i == 0) {
                    data.text(dish.name);
                } else {
                    data.text(data.text() + ", " + dish.name)
                }
            });
            row.append($("<td>").append($("<label id='deleteMealLabel'>").text("Delete").data("meal-id", meal.id)));
            row.append($("<td>").append($("<label id='editMealLabel'>").text("Edit").data("meal-id", meal.id)));
        });
    });
}

function deleteMeal(mealId){
    $.get("/meal/delete", {mealId: mealId}, function () {
        viewMealList();
    });
}

function addMeal() {
    $("#tableDiv").empty();
    $("#tableDiv").load("/meal/addMealForm", function(response){
//        document.forms[0].action = "/admin/HomePage";
//        document.forms[0].method = "get";
//        document.forms[0].submit();
    });
}

function handleError(response){

}

function editMeal(mealId){
    $("#tableDiv").empty();
    $.get("/meal/editMealForm", {mealId: mealId}, function(response) {
        $("#tableDiv").append(response);
    });
    $("#sectionHeader").text("Enter new day, type and comma separated dish");
}

$('#tableDiv').on("click", '#editMealLabel', function () {
    var mealId = $(this).data("meal-id");
    editMeal(mealId);
});

$('#viewMealList').click(function () {
    viewMealList();
});


$("#tableDiv").on("click", '#deleteMealLabel', function () {
    var mealId = $(this).data("meal-id");
    deleteMeal(mealId);
})

$("#addMeal").on("click", function(){
    addMeal();
});

// Meal js ends

// User js begins


$('#viewUserList').click(function () {
    viewUserList();
});

function viewUserList() {
    $('#sectionHeader').text('User List');

    $(".active").removeClass("active");

    $("#viewUserList").addClass("active");

    var $tableDiv = $("#tableDiv");
    $tableDiv.empty();

    var $table = $("<table>");
    $table.addClass("table table-striped");
    $table.attr('id', "displayTable");
    $table.append($('<tbody>'));

    $tableDiv.append($table);
    $.get("/usr/view", function (responseJson) {
        $.each(responseJson, function (i, user) {
            var row = $("<tr>").appendTo($table);
            row.append($("<td>").text(i + 1))
                .append($("<td>").text(user.email))
                .append($("<td>").text(user.password))
                .append($("<td>").append($("<label id='deleteUserLabel'>").text("Delete").data("user-id", user.id)));
        });
    });
}

function deleteUser(userId){
    $.get("/usr/delete", {userId: userId}, function(){
        viewUserList();
    })
}

$("#tableDiv").on("click", '#deleteUserLabel', function () {
    var userId = $(this).data("user-id");
    deleteUser(userId);
})