<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/30/16
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/templates/header.jsp"%>
<%@include file="/templates/navbar.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <%--<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>--%>
                <li><a href="#" id="viewDishList">View Dish<span class="sr-only">(current)</span></a></li>
                <li><a href="#" id="viewMealList">View Meal</a></li>
                <li><a href="#" id="viewUserList">View User</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <%--<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>--%>
                <li><a href="#" id="addDish" class="item">Add Dish<span class="sr-only">(current)</span></a></li>
                <li><a href="#" id="addMeal" class="item">Add Meal</a></li>
                <li><a href="#" id="addUser" class="item">Add User</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>
            <h3 class="sub-header" id="sectionHeader">Welcome, Admin</h3>
            <div class="table-responsive" id="tableDiv">
                <table class="table table-striped" id="displayTable"></table>
            </div>
        </div>
    </div>
</div>
<%@include file="/templates/footer.jsp"%>