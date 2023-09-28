<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h2>Hello World!</h2>
<h3>Category List</h3>
<table border="1">
    <thead>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Description</td>
            <td>Actions</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.description}</td>
                <td><a href="<c:url value="/ProductServlet?id=${category.id}"/>">Show Products</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
