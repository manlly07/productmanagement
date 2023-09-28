<%--
  Created by IntelliJ IDEA.
  User: ADMIIN
  Date: 9/28/2023
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>First Name</td>
        <td>${cookie['firstname'].value}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${cookie['lastname'].value}</td>
    </tr>
<%--    <tr>--%>
<%--        <td>Enter password</td>--%>
<%--        <td>${cookie['firstname']}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>re-Enter password</td>--%>
<%--        <td>${cookie['firstname']}</td>--%>
<%--    </tr>--%>
</table>
</body>
</html>
