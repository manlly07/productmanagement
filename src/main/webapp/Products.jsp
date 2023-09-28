<%--
  Created by IntelliJ IDEA.
  User: ADMIIN
  Date: 9/28/2023
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
    <h3>Product List</h3>
    <table>
        <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Price</td>
                <td>Description</td>
                <td>Actions</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td><a href="<c:url value="/ProductServlet?action=assign&id=${product.id}"/>">Assign This product to the other category</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
