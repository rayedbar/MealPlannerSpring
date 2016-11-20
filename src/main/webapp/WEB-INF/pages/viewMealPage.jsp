<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <h3 class="sub-header">Here is a list of all meals in the database:</h3>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Day</th>
                        <th>Type</th>
                        <th>Dishes</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%int i = 1;%>
                    <c:forEach items="${mealList}" var="meal">
                        <tr>
                            <td><%=i%>
                            </td>
                            <td><c:out value="${meal.day}"/></td>
                            <td><c:out value="${meal.type}"/></td>
                            <td><c:out value="${meal.dishList}"/></td>
                            <td><a href="/meal/delete?id=<c:out value="${meal.id}"/>"/>Delete</td>
                            <td><a href="/meal/updateMealPage?id=<c:out value="${meal.id}"/>"/>Update</td>
                        </tr>
                        <%i = i + 1;%>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
