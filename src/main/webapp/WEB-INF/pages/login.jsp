<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/25/16
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/templates/header.jsp"%>
    <div class="container">
        <div class="page-header">
            <h1>Welcome to Meal Planner</h1>
        </div>
        <sf:form class="form-signin" action="/auth/verify" method="POST" commandName="user">
            <h2 class="form-signin-heading">Please log in</h2>
            <sf:errors path="*" element="div" cssClass="alert alert-danger fade in" />
            <label for="inputEmail" class="sr-only">Email address</label>
            <sf:input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" path="email"/>
            <label for="inputPassword" class="sr-only">Password</label>
            <sf:input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" path="password"/>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
            <br>
            <div class="center-block">
                <a href="/auth/signup">Sign up?</a>
            </div>
        </sf:form>
    </div>
<%@include file="/templates/footer.jsp"%>