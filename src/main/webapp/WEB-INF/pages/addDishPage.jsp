<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <h3 class="sub-header">Enter name of dish to add to database:</h3>
            <form:form method="post" action="/dish/add" modelAttribute="dish">
                <div class="form-group">
                    <label for="dishName">Dish Name</label>
                    <form:input type="text" path="name" class="form-control" id="dishName" placeholder="Name of dish"/>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form:form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
