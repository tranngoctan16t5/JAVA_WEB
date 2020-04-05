<%--
  Created by IntelliJ IDEA.
  User: NGOCTAN
  Date: 4/2/2020
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p><a href="/customers?action=create">Create new customer</a></p>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td><a href="/customers?action=view&id=${customer.getId()}"></a>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">Edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getId()}">Delete</a></td>
            <td><a href="/customers?action=view&id=${customer.getId()}">view detail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
