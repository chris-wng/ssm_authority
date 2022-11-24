<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2022/10/15
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色分配</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

</head>
<body>
<form action="userController/saveUserRoleMapping" method="post">
    <c:forEach items="${roleList}" var="role">
        <input type="checkbox" name="rid" value="${role.rid}">${role.rolename} <br>
    </c:forEach>
    <input type="hidden" name="uid" value="${uid}">
    <input type="submit" value="提交">
</form>

</body>
</html>
<script src="script/jquery-1.7.2.js"></script>
<script>
    $(function(){
        $("input[name=rid]".val(${rids}));
    })
</script>