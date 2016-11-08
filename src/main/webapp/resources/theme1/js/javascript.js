/**
 * Created by rayed on 10/27/16.
 */

function viewDishList(userEmail) {

//    console.log(document.URL);
//
//    var param = document.URL.split('#')[1];
//
//    console.log(param)

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

    //console.log("1. " + userEmail);


   $.get("/usr/get", function (user_email) {
        var userEmail = user_email;
        $.get("/usr/homepage/viewDish", function (responseJson) {

            //console.log("sent ajax request");
            $.each(responseJson, function (index, dish) {
                var dishId = dish.id;
//                console.log(dishId);
                var row = $("<tr>").appendTo($table);
                row.append($("<td>").text(index + 1))
                    .append($("<td>").text(dish.name));
                if (userEmail == "admin@gmail.com") {
                    row.append($("<td>").append($("<label id='deleteDishLabel'>").text("Delete").data("dish-id", dishId)));
                    row.append($("<td>").append($("<label id='editDishLabel'>").text("Edit").data("dish-id", dishId)));
                }
            });
        });
   });
}

function deleteDish(dishId) {
    $.get("/usr/homepage/deleteDish", {dishId: dishId});
}

$("#tableDiv").on("click", '#deleteDishLabel', function () {
    var dishId = $(this).data("dish-id");
    deleteDish(dishId);
});


function editDish(dishId) {
    $("#tableDiv").empty();
    $("#tableDiv").load("/usr/homepage/editDishForm", {dishId: dishId}, function(){
//        alert("load was performed");
    });
}


$("#tableDiv").on("click", '#editDishLabel', function () {
    var dishId = $(this).data("dish-id");
    editDish(dishId);
});

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

    $.get("login/getMeal.do", function (responseJson) {
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
            row.append($("<td>").append($("<label id='deleteMealLabel'>").text("Delete")));
            row.append($("<td>").append($("<label id='editMealLabel'>").text("Edit")));
        });
    });

}


function deleteMeal(day, type, dishes){
    $.get("login/deleteMeal.do", {day: day, type: type, dishes: dishes}, function () {
        viewMealList();
    });
}

$("#tableDiv").on("click", '#deleteMealLabel', function () {
    var dishes = $(this).parent().prev().text();
    var type = $(this).parent().prev().prev().text();
    var day = $(this).parent().prev().prev().prev().text();
    //console.log(type + " " + day + " " + dishes);

    deleteMeal(day, type, dishes);
    //deleteDish(dishName);
})


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
    $.get("login/getUser.do", function (responseJson) {
        $.each(responseJson, function (i, user) {
            var row = $("<tr>").appendTo($table);
            row.append($("<td>").text(i + 1))
                .append($("<td>").text(user.email))
                .append($("<td>").text(user.password));
        });
    });
}




$('#viewDishList').click(function () {
    //$("#addForm").show();
    viewDishList();
});

$('#viewMealList').click(function () {
    //$("#addForm").show();
    viewMealList();
});

$('#viewUserList').click(function () {
   // $("#addForm").show();
    viewUserList();
});


function addDish() {
    $("#tableDiv").empty();
    $("#tableDiv").load("forms/addDishForm.jsp");
}

$("#addDish").on("click", function(){
    addDish();
});


function addMeal() {
    $("#tableDiv").empty();
    $("#tableDiv").load("forms/addMealForm.jsp");
}

$("#addMeal").on("click", function(){
    addMeal();
});





