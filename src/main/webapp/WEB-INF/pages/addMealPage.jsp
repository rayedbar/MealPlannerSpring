<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <h3 class="sub-header">Enter meal:</h3>
            <form:form method="post" action="/meal/add" modelAttribute="meal">
                <form:errors path="*" element="div" cssClass="alert alert-danger fade in"/>
                <div class="form-group">
                    <label for="day">Day</label>
                    <form:input type="text" path="day" class="form-control" id="day"
                                placeholder="Sunday, Monday, etc"/>
                </div>
                <div class="form-group">
                    <label for="type">Type</label>
                    <form:input type="text" path="type" cssClass="form-control" id="type"
                                placeholder="Breakfast, Lunch, etc"/>
                </div>
                <div class="form-group">
                    <label>Dishes</label>
                    <c:forEach items="${meal.dishList}" var="dish">
                        <div class="checkbox">
                            <label><form:checkbox path="dishList" value="${dish.id}"/>${dish.name}</label>
                        </div>
                    </c:forEach>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form:form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
