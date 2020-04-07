<%--
  Created by IntelliJ IDEA.
  User: NGOCTAN
  Date: 4/6/2020
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="get">
    <input type="text" name="number_one" >
    <input type="text" name="number_two"><br>
    <input type="submit"  value="+" name="operator">
    <input type="submit" value="-" name="operator">
    <input type="submit" value="x" name="operator">
    <input type="submit" value="/" name="operator"><br>
    <h1>Kết quả : ${result}</h1>
    <h1 style="color: red">${error}</h1>

</form>
</body>
</html>
