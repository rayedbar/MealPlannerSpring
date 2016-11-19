<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <h3 class="sub-header">Here is a list of all dishes in the database:</h3>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%int i = 1;%>
                    <c:forEach items="${dishList}" var="dish">
                        <tr>
                            <td><%=i%>
                            </td>
                            <td><c:out value="${dish.name}"/></td>
                            <td><a href="/dish/delete?id=<c:out value="${dish.id}"/>"/>Delete</td>
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
