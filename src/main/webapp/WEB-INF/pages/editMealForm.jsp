<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 11/9/16
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form class="form-inline" action="/meal/edit" method="POST" commandName="meal">
    <div class="form-group">
        <%--<label class="sr-only" for="exampleInputEmail3">Email address</label>--%>
        <input class="form-control" id="newDishName" path="day" name="mealDay" placeholder="Enter New Day">
        <input class="form-control" id="newDishName" path="type" name="mealType" placeholder="Enter New Type">
        <%--<input class="form-control" id="newDishName" name="mealDishes" placeholder="Enter Comma Serparatede dish names">--%>
        <input  type="hidden" name="mealId" value="${mealId}">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form:form>
