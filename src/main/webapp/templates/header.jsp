<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/27/16
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>Meal Planner</title>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/css/bootstrap-theme.min.css" var="bootstrapThemeCss"/>
    <spring:url value="/resources/css/signin.css" var="signIn"/>

    <link href="${bootstrapCss}"  rel="stylesheet" />
    <link href="${bootstrapThemeCss}" rel="stylesheet">
    <link href="${signIn}" rel="stylesheet" />

</head>
<body>
