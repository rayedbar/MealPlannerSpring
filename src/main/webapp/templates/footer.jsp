<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/27/16
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/js/javascript.js" var="customJs"/>
    <spring:url value="/resources/js/jquery-3.1.1.js" var="jquery"/>

    <script src="${jquery}" rel="script"></script>
    <script src="${bootstrapJs}" rel="script"></script>
    <script src="${customJs}" rel="script"></script>
</body>
</html>
