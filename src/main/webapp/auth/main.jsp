<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 2022/10/15
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

</head>
<body>
<h1 style="text-align: center">权限管理</h1>
<a href="javascript:void(0)" onclick="jump('userController/findAll')">用户管理</a>
<a href="javascript:void(0)" onclick="jump('roleController/findAll')">角色管理</a>
<a href="javascript:void(0)" onclick="jump('authController/findAll')">权限管理</a>
<hr>
<iframe id="fid" scrolling="no"  frameborder="0" width="100%" height="100%" name="mainframe" style="background: cyan"></iframe>
</body>
</html>
<script>
    function jump(path){
        var frameobj = document.getElementById("fid");
        frameobj.src = path;
    }
</script>
