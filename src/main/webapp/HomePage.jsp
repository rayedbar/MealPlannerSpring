<%@ page import="java.util.List" %>
<%@ page import="net.therap.mealplannerhibernate.entity.Dish" %>
<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/26/16
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>

<%@include file="templates/navbar.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <li><a href="#" id="viewDishList" onclick="viewDishList">View Dish</a></li>
                <li><a href="#" id="viewMealList">View Meal</a></li>
                <%--<li><a href="#">Export</a></li>--%>
            </ul>
            <ul class="nav nav-sidebar">
                <%--<li><a href="#" id="createMeal">Create Meal</a></li>--%>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="dashboard">

            <h1 class="page-header">Dashboard</h1>

            <h2 class="sub-header" id="sectionHeader">Section title</h2>
            <div class="table-responsive" id="tableDiv">
                <table class="table table-striped" id="displayTable">

                </table>
            </div>

        </div>
    </div>
</div>


<%@include file="templates/footer.jsp"%>