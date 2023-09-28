<%--
  Created by IntelliJ IDEA.
  User: ADMIIN
  Date: 9/28/2023
  Time: 3:23 PM
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
<form method="post" action="/InformationServlet">
    <table>
        <c:if test="${errMsg != null}">
            <tr>
                <td colspan="2"><span style="color: red">${errMsg}</span></td>
            </tr>
        </c:if>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstname" required></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastname" required></td>
        </tr>
        <tr>
            <td>Enter password</td>
            <td><input type="text" name="password" required></td>
        </tr>
        <tr>
            <td>re-Enter password</td>
            <td><input type="text" name="repassword" required></td>
        </tr>
        <tr>
            <td><input type="submit" value="Display"></td>
            <td><input type="reset" value="Clear"></td>
        </tr>
    </table>
</form>

</body>
</html>
