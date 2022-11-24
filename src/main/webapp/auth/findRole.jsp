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
    <title>角色管理</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

</head>
<body>
<table cellpadding="0" cellspacing="0">
    <c:forEach items="${roleList}" var="role">
        <tr>
            <td>${role.rid}</td>
            <td>${role.rolename}</td>
            <td><a href="roleController/configuredAuth?rid=${role.rid}">配置权限</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
