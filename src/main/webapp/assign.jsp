<%--
  Created by IntelliJ IDEA.
  User: ADMIIN
  Date: 9/28/2023
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Assign</title>
</head>
<body>
<h2>Do you really want to assign product: ${product.name} to the other category</h2>
<form action="/ProductServlet?action=update&idPr=${product.id}" method="post" >
    <select name="cateId">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit">
</form>
</body>
</html>
