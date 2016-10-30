/**
 * Created by rayed on 10/27/16.
 */

//$(document).ready(function(){

    $('#viewDishList').click(function(){
//        $.ajax({
//            type: "post",
//            url: "/login/viewDish.do",
//            success: function(msg){
//                $('#displayResult').append(msg);
//            }
//        });
//        $('#viewDishList').css("border", "1px solid");
        $('#sectionHeader').text('Dish List');

        $(".active").removeClass("active");

        $('#viewDishList').addClass("active");

        var $table = $("#displayTable");
        $table.empty();
        $table.append($('<tbody>'));

        $.get("login/viewDish.do", function(responseJson) {

            //var i = 0;

            $.each(responseJson, function(index, dish) {
                $("<tr>").appendTo($table)
                    .append($("<td>").text(index + 1))
                    .append($("<td>").text(dish.name));
             //   i = i + 1;
            });
        });
    });
//});

    $('#viewMealList').click(function() {
        $('#sectionHeader').text('Meal List');

        $(".active").removeClass("active");

        $("#viewMealList").addClass("active");

        var $table = $("#displayTable");
        $table.empty();
        $table.append($('<tbody>'));

        $.get("login/getMeal.do", function(responseJson) {

            //var i = 0;

            $.each(responseJson, function(i, meal) {
                var row = $("<tr>").appendTo($table);
                row.append($("<td>").text(i + 1))
                    .append($("<td>").text(meal.day))
                    .append($("<td>").text(meal.type));
                $.each(meal.dishList, function(i , dish){
                    row.append($("<td>").text(dish.name));
                });
              //  i = i + 1;
            });
        });


    });


//    $('#viewUserList').click(function(){
//
//        $$('#sectionHeader').text('Meal List');
//
//        $(".active").removeClass("active");
//
//        $("#viewMealList").addClass("active");
//
//        var $table = $("#displayTable");
//        $table.empty();
//        $table.append($('<tbody>'));
//
//        $.get("login/getMeal.do", function(responseJson) {
//
//            //var i = 0;
//
//            $.each(responseJson, function(i, meal) {
//                var row = $("<tr>").appendTo($table);
//                row.append($("<td>").text(i + 1))
//                    .append($("<td>").text(meal.day))
//                    .append($("<td>").text(meal.type));
//                $.each(meal.dishList, function(i , dish){
//                    row.append($("<td>").text(dish.name));
//                });
//                //  i = i + 1;
//            });
//        });
//
//    });