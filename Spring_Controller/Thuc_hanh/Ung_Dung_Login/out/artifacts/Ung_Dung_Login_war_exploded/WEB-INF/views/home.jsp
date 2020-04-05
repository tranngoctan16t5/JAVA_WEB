<%--
  Created by IntelliJ IDEA.
  User: NGOCTAN
  Date: 4/4/2020
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Home</h3>
<form:form action="login" method="post" modelAttribute="tan">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><from:label path="account">Account</from:label></td>
                <td><form:input path="account"/></td>
            </tr>

            <tr>
                <td><from:label path="password">Password</from:label></td>
                <td><form:input path="password"/></td>
            </tr>

            <tr>
                <td></td>
                <td><form:button>Login</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
