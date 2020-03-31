<%--
  Created by IntelliJ IDEA.
  User: NGOCTAN
  Date: 3/31/2020
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="/discount " method="post">
    <div>
        <input type="text" name="product"  placeholder="Product Description"><br>
        <input type="text" name="price" placeholder="List Price"><br>
        <input type="text" name="discount" placeholder="Discount Price"><br>
        <input type="submit" value="Calculator Display">

    </div>
</form>
</body>
</html>
