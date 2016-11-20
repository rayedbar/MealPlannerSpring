<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <h3 class="sub-header">Here is a list of all users in the database:</h3>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>email</th>
                        <th>Password</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user" varStatus="loop">
                        <tr>
                            <td><c:out value="${loop.index}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.password}"/></td>
                            <c:choose>
                                <c:when test="${user.email=='admin@gmail.com'}">
                                    <td></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="/user/delete?id=<c:out  value="${user.id}"/>"/>Delete</td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
