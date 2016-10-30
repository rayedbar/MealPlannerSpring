<%--
  Created by IntelliJ IDEA.
  User: rayed
  Date: 10/30/16
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>

<form>
    <div class="checkbox">
        <label>
            <input type="checkbox" value="">
            <%
                String name = request.getParameter("name");
                response.getWriter().println(name);
            %>
            </input>
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" value="">Option 1</input>
        </label>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" value="">Option 1</input>
        </label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>

<%@include file="templates/footer.jsp"%>
