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


    $.get("login/getCurrentUser.do", function (user_email) {
        var userEmail = user_email;
        $.get("login/getDish.do", function (responseJson) {
            $.each(responseJson, function (index, dish) {
                var row = $("<tr>").appendTo($table);
                row.append($("<td>").text(index + 1))
                    .append($("<td>").text(dish.name));
                if (userEmail == "admin@gmail.com") {
                    row.append($("<td>").append($("<label id='deleteDishLabel'>").text("Delete")));
                    row.append($("<td>").append($("<label id='editDishLabel'>").text("Edit")));
                }
            });
        });
    });

}


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

function deleteDish(dishName) {
    $.get("login/deleteDish.do", {dish_name: dishName}, function () {
        viewDishList();
    });
}

function editDish(dishName) {
    $("#tableDiv").empty();
    $("#tableDiv").load("editDishForm.jsp?param=" + dishName);
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


$("#tableDiv").on("click", '#deleteDishLabel', function () {
    var dishName = $(this).parent().prev().text();
    deleteDish(dishName);
});

$("#tableDiv").on("click", '#editDishLabel', function () {
    var dishName = $(this).parent().prev().prev().text();
    editDish(dishName);
});

