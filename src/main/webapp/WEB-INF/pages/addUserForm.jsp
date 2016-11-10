<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 11/1/16
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="/templates/header.jsp"%>--%>

<form class="form-inline" method="post" action="login/addUser.do">
    <div class="form-group">
        <label for="dishname">Dish Name</label>
        <input type="text" class="form-control" id="dishname" name="addDish" placeholder="New Dish">
    </div>
    <button type="submit" class="btn btn-default">Add</button>
</form>

<%--<%@include file="/templates/footer.jsp"%>--%>