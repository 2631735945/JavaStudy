<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/21
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form action="<%=request.getContextPath()%>/student" method="get">--%>
<%--   用户名:<input type="text" name="name" /><br>--%>
<%--    年龄:<input type="text" name="age" /><br>--%>
<%--    性别:<input type="text" name="gender" /><br>--%>
<%--    <input type="text" value="add" name="method" />--%>
<%--    <input type="submit" value="添加">--%>
<%--</form>--%>

<form action="<%=request.getContextPath()%>/student?method=add" method="post">
    用户名:<input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    性别：<input type="text" name="gender"/><br/>
    <input type="submit" value="添加"/>
</form>

</body>
</html>
