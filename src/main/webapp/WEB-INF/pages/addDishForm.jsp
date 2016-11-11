<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/31/16
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="/templates/header.jsp"%>--%>

<form class="form-inline" method="post" action="/dish/add">
    <div class="form-group">
        <label for="dishname">Dish Name</label>
        <input type="text" class="form-control" id="dishname" name="dishName" placeholder="New Dish">
    </div>
    <button type="submit" class="btn btn-default">Add</button>
</form>

<%--<%@include file="/templates/footer.jsp"%>--%>