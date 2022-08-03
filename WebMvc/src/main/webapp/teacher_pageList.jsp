<%@ page import="com.situ.web.util.PageInfo" %>
<%@ page import="com.situ.web.pojo.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/22
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->--%>
    <%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
    <%--    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
    <%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
    <script src="static/jquery-2.1.4.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.4.1/dist/css/bootstrap.css">
    <script src="static/bootstrap-3.4.1/dist/js/bootstrap.js"></script>

    <script src="static/layer/layer.js"></script>
    <script src="static/mylayer.js"></script>
</head>
<body>

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
    <c:forEach items="${pageInfo.list}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.age}</td>
            <td>${teacher.address}</td>

            <td><a href="javaScript:deleteById(${teacher.id})">删除</a></td>
            <td><a href="<%=request.getContextPath()%>/teacher?method=updateTeacherPage&id=${teacher.id}">编辑</a></td>
        </tr>
    </c:forEach>

</table>

<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <c:if test="${pageInfo.pageNo==1}">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </c:if>

            <c:if test="${pageInfo.pageNo>1}">
                <a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${pageInfo.pageNo-1}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </c:if>

        </li>
        <c:forEach begin="1" end="${pageInfo.totalPages}" var="i">
            <li><a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${i}">${i}</a></li>
        </c:forEach>


        <%--        javaScript:nextPage(<%=pageInfo.getPageNo()>,<%=pageInfo.getTotalPages()%>)--%>
        <li>

            <c:if test="${pageInfo.pageNo<pageInfo.totalPages}">
                <a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${pageInfo.pageNo+1}"
                   aria-label="Next">
                        <%--    <%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=<%=pageInfo.getPageNo()+1%>--%>
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </c:if>
            <c:if test="${pageInfo.pageNo==pageInfo.totalPages}">
                <a href="#" aria-label="Next">
                        <%-- <%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=<%=pageInfo.getPageNo()+1%> --%>
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </c:if>

        </li>
    </ul>
</nav>
<script>
    function deleteById(id) {
        <%--var result=confirm("确定要删除吗?")--%>
        <%--if(result){--%>
        <%--    location.href='<%=request.getContextPath()%>/teacher?method=deleteById&id='+id--%>
        <%--}--%>
       layer.confirm('您确定要删除吗?',function(){
           $.post(
               '${pageContext.request.contextPath}/teacher?method=deleteById',
               {"id": id},
               function (JSONResult) {
                   console.log(JSONResult)
                   // {code: 0, msg: '删除成功', data: null}
                   if(JSONResult.code==0){
                       mylayer.okUrl(JSONResult.msg,'${pageContext.request.contextPath}/teacher?method=selectByPage')
                   }else{
                       mylayer.errorMsg(JSONResult.msg)
                   }
               },
               'json'
           );
       })

    }

    function nextPage(pageNo, TotalPages) {
        if (pageNo < TotalPages) {
            location.href = '<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=' + (pageNo + 1)
        }
    }
</script>
</body>
</html>
