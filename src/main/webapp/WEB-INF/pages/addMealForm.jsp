<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 11/1/16
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="/templates/header.jsp"%>--%>

<form:form action="/meal/add" method="post" modelAttribute="meal">
    <div class="form-group">
        <label for="enterDay">Enter Day</label>
        <form:input type="text" class="form-control" id="enterday" name="mealDay" placeholder="Sunday, Monday, .." path="day"/>
    </div>
    <div class="form-group">
        <label for="enterType">Enter Type</label>
        <form:input type="text" class="form-control" id="enterType" name="mealType" placeholder="Breakfast, Lunch, .." path="type"/>
    </div>
    <div class="form-group">
        <label>Select Dish</label>
        <c:forEach items="${meal.dishList}" var="dish" varStatus="loop">
            <div class="checkbox">
                <label><input type="checkbox" value="${dish.name}" name="${dish.id}">${dish.name}</label>
            </div>
        </c:forEach>
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
</form:form>

<%--<%@include file="/templates/footer.jsp"%>--%>