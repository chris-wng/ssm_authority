<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2022/10/15
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

    <title>首页</title>
</head>
<body>
<a href="auth/main.jsp">权限管理</a>
<a href="book/login.jsp">图书后台管理</a>
</body>
</html>
