<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/25
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/user?method=login">
    用户名：<input type="text" name="name">
    密码：<input type="password" name="password">
    <input type="submit" value="登录">

</form>
</body>
</html>
