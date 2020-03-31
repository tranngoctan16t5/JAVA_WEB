<%--
  Created by IntelliJ IDEA.
  User: NGOCTAN
  Date: 3/31/2020
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>

</style>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Máy tính casio</h1>
<form method="post" action="/calculator">
    <fieldset>
        <legend>máy tính casio</legend>
        <table>
            <tr>
                <td>First number:</td>
                <td><input name="first_number" type="text"></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td>
                    <select name="operator" id="">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second number:</td>
                <td><input name="second_number" type="text"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="calculator"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
