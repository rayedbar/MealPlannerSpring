<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/31/16
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/templates/header.jsp"%>

<form class="form-inline" action="/usr/homepage/editDish" method="POST">
    <div class="form-group">
        <%--<label class="sr-only" for="exampleInputEmail3">Email address</label>--%>
        <input class="form-control" id="newDishName" name="newDishName" placeholder="Enter New Dish">
        <input  type="hidden" name="oldDishName" value="<%=request.getParameter("param")%>">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>

<%@include file="/templates/footer.jsp"%>

