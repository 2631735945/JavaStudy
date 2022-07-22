<%@ page import="com.situ.web.util.PageInfo" %>
<%@ page import="com.situ.web.pojo.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/22
  Time: 9:50
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
<%
    PageInfo pageInfo= (PageInfo) request.getAttribute("pageInfo");
%>
<a href="<%=request.getContextPath()%>/teacher_add.jsp">添加</a>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <%
        for (Teacher teacher : pageInfo.getList()) {
    %>
    <tr>
        <td><%=teacher.getId()%></td>
        <td><%=teacher.getName()%></td>
        <td><%=teacher.getAge()%></td>
        <td><%=teacher.getAddress()%></td>
        <td><a href="javaScript:deleteById(<%=teacher.getId()%>)">删除</a></td>
        <td><a href="<%=request.getContextPath()%>/teacher?method=updateTeacherPage&id=<%=teacher.getId()%>">编辑</a></td>
    </tr>
    <%
        }

    %>

</table>

<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=<%=pageInfo.getPageNo()-1%>" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <%
            for(int i=1;i<=pageInfo.getTotalPages();i++){
        %>
        <li><a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=<%=i%>"><%=i%></a></li>
        <%
            }
        %>


        <li>
            <a href="javaScript:nextPage(<%=pageInfo.getPageNo()>)"  aria-label="Next">
<%--                    <%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=<%=pageInfo.getPageNo()+1%>--%>
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<script>
    function deleteById(id){
        var result=confirm("确定要删除吗?")
        if(result){
            location.href='<%=request.getContextPath()%>/teacher?method=deleteById&id='+id
        }
    }
    function nextPage(pageNo){
        if(page<getTotalPages()){
            location.href=
        }
    }
</script>
</body>
</html>
