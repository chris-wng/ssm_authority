<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2022/10/15
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

</head>
<body>
<table cellpadding="0" cellspacing="0">
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.uid}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>${user.sex}</td>
            <td><a href="userController/configuredRole?uid=${user.uid}">角色分配</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
