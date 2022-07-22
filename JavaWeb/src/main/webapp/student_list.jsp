<%@ page import="com.situ.web.pojo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/20
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<%--${list}--%>
<%
    //jsp脚本  可以任意写java代码
//    request内置对象
   List<Student> list= (List<Student>) request.getAttribute("list");
%>
<a href="<%=request.getContextPath()%>/student_add.jsp">添加</a>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <%
        for (Student student : list) {
            %>
                 <tr>
                     <td><%=student.getId()%></td>

                     <td><%=student.getName()%></td>

                     <td><%=student.getAge()%></td>

                     <td><%=student.getGender()%></td>

                     <td><a  href="javascript:deleteById(<%=student.getId()%>)">删除</a></td>
<%--                     ${pageContext.request.contextPath}   --%>
<%--                     <%=request.getContextPath()%>/student?method=deleteById&id=<%=student.getId()%>--%>

<%--                    <td><a href="<%=request.getContextPath()%>/student_update.jsp">编辑</a></td>--%>
                     <td><a href="<%=request.getContextPath()%>/student?method=getStudentUpdatePage&id=<%=student.getId()%>">编辑</a></td>
                 </tr>

            <%
        }
    %>
</table>
<script type="text/javascript">
    function deleteById(id){
        var isDelete=confirm('您确认删除吗？')
        if(isDelete){
            location.href='<%=request.getContextPath()%>/student?method=deleteById&id='+id
        }
    }
</script>
</body>
</html>
