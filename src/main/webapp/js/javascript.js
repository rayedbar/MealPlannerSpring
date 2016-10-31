/**
 * Created by rayed on 10/27/16.
 */

    function viewDishList(userEmail) {

        //var userEmail = getCurrentUser();

        $('#sectionHeader').text('Dish List');

        $(".active").removeClass("active");

        $("#viewDishList").addClass("active");

        var $table = $("#displayTable");
        $table.empty();
        $table.append($('<tbody>'));

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
//        if (userEmail == "admin@gmail.com"){
//            addDishForm(userEmail);
//        }
    });

 }

    function viewMealList(){
        $('#sectionHeader').text('Meal List');

        $(".active").removeClass("active");

        $("#viewMealList").addClass("active");

        var $table = $("#displayTable");
        $table.empty();
        $table.append($('<tbody>'));

        $.get("login/getMeal.do", function (responseJson) {
            $.each(responseJson, function (i, meal) {
                var row = $("<tr>").appendTo($table);
                row.append($("<td>").text(i + 1))
                    .append($("<td>").text(meal.day))
                    .append($("<td>").text(meal.type));
                var data = ($("<td>")).appendTo(row);
                $.each(meal.dishList, function (i, dish) {
                    if (i == 0){
                        data.text(dish.name);
                    } else {
                        data.text(data.text() + ", " + dish.name)
                    }
                });
            });
        });

    }

    function viewUserList(){
        $('#sectionHeader').text('User List');

        $(".active").removeClass("active");

        $("#viewUserList").addClass("active");

        var $table = $("#displayTable");
        $table.empty();
        $table.append($('<tbody>'));

        $.get("login/getUser.do", function (responseJson) {
            $.each(responseJson, function (i, user) {
                var row = $("<tr>").appendTo($table);
                row.append($("<td>").text(i + 1))
                    .append($("<td>").text(user.email))
                    .append($("<td>").text(user.password));
            });
        });
    }

    function deleteDish(dishName){
        $.get("login/deleteDish.do", {dish_name: dishName}, function(){
            viewDishList();
        });
    }

    function editDish(dishName){
        $("#tableDiv").empty();
        $("#tableDiv").load("editDishForm.jsp?param=" + dishName);
    }

    $('#viewDishList').click(function(){
        viewDishList();
    });

    $('#viewMealList').click(function(){
        viewMealList();
    });

    $('#viewUserList').click(function(){
        viewUserList();
    });

    $("#displayTable").on("click", '#deleteDishLabel', function () {
        var dishName = $(this).parent().prev().text();
        deleteDish(dishName);
    });

    $("#tableDiv").on("click", '#editDishLabel', function () {
        var dishName = $(this).parent().prev().prev().text();
        editDish(dishName);
    });