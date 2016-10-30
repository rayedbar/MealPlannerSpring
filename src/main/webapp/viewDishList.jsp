<%@ page import="net.therap.mealplannerhibernate.entity.Dish" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/27/16
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>

<table border="1px">
    <tr>
        <th>Dishes</th>
    </tr>

    <%
        List<Dish> dishList = (List<Dish>) request.getAttribute("dishList");
        for (Dish dish : dishList){%>
            <tr><td><%=dish%></td></tr>
        <%}
    %>
</table>
</body>
</html>
