<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 11/1/16
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/templates/header.jsp"%>

<form action="login/addMeal.do" method="post">
    <div class="form-group">
        <label for="enterDay">Enter Day</label>
        <input type="text" class="form-control" id="enterday" name="enterDay" placeholder="Sunday, Monday, ..">
    </div>
    <div class="form-group">
        <label for="enterType">Enter Type</label>
        <input type="text" class="form-control" id="enterType" name="enterType" placeholder="Breakfast, Lunch, ..">
    </div>
    <div class="form-group">
        <label for="enterdish">Enter Type</label>
        <input type="text" class="form-control" id="enterdish" name="enterDish" placeholder="Enter comma separated dish names">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>

<%@include file="/templates/footer.jsp"%>