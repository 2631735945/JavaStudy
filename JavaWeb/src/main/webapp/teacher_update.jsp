<%@ page import="java.util.List" %>
<%@ page import="com.situ.web.pojo.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/21
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Teacher teacher= (Teacher) request.getAttribute("teacher");
%>
<form action="<%=request.getContextPath()%>/teacher?method=updateTeacher" method="post">
    <input type="hidden" value="<%=teacher.getId()%>" name="id">
    用户名:<input type="text" value="<%=teacher.getName()%> " name="name">
    年龄:<input type="text" value="<%=teacher.getAge()%> " name="age">
    地址:<input type="text" value="<%=teacher.getAddress()%> " name="address">
    <input type="submit" value="修改">
</form>
</body>
</html>
