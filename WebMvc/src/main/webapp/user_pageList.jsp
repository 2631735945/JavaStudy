<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/30
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>

    <script src="static/jquery-2.1.4.js"></script>

    <script src="static/bootstrap-3.4.1/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.4.1/dist/css/bootstrap.css">
    <script src="static/layer/layer.js"></script>
    <script src="static/mylayer.js"></script>
</head>


<body>

<table id="tableid" class="table table-striped table-bordered table-hover table-condensed">

    <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>密码</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><a href="javaScript:deleteById(${user.id})">删除</a></td>
            <td><a href="javaScript:updateById(${user.id})">编辑</a></td>
<%--            <%=request.getContextPath()%>/user?method=updateTeacherPage&id=${user.id}--%>
        </tr>
    </c:forEach>
</table>

<nav aria-label="Page navigation" id="navId">
    <ul class="pagination" id="ulId">
                <li>
                    <c:if test="${pageInfo.pageNo==1}">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo>1}">
                        <a href="<%=request.getContextPath()%>/user?method=selectByPage&pageNo=${pageInfo.pageNo-1}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>

                </li>
                <c:forEach begin="1" end="${pageInfo.totalPages}" var="i">
                    <li><a href="<%=request.getContextPath()%>/user?method=selectByPage&pageNo=${i}">${i}</a></li>
                </c:forEach>

                <%--        javaScript:nextPage(<%=pageInfo.getPageNo()>,<%=pageInfo.getTotalPages()%>)--%>
                <li>

                    <c:if test="${pageInfo.pageNo<pageInfo.totalPages}">
                        <a href="<%=request.getContextPath()%>/user?method=selectByPage&pageNo=${pageInfo.pageNo+1}"
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


<div id="updateDiv" style=" display: none;">

    <input type="hidden" id="id111"   name="id"/>

        <div class="form-group" >
            <label for="nameUpdate" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-10">
                <input type="text" class="col-xs-6 .col-md-4 form-control" id="nameUpdate" name="name1">
<%--                placeholder="name"--%>
            </div>
        </div>

        <div class="form-group">
            <label for="passwordUpdate" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-10">
                <input type="password" class="col-xs-6 .col-md-4 form-control" name="password1" id="passwordUpdate" >
<%--                placeholder="Password"--%>
            </div>
        </div>

</div>


<script type="text/javascript">
    function deleteById(id){
        layer.confirm("确定要删除吗？",function () {
            $.post(
                '${pageContext.request.contextPath}/user?method=deleteById',
                {"id":id},
                function (JSONResult){
                    console.log(JSONResult)
                    if(JSONResult.code==0){
                        mylayer.confirm(JSONResult.msg,'${pageContext.request.contextPath}/user?method=selectByPage')
                    }else {
                        mylayer.errorMsg(JSONResult.msg)
                    }
                },
                'json'
            )
        })
    }
    function updateById(id){

            $.post(
                '${pageContext.request.contextPath}/user?method=updateUserPage',
                {"id":id},
                function (JSONResult){
                    console.log(JSONResult);
                        $("#nameUpdate").val(JSONResult.data.name);
                        $("#passwordUpdate").val(JSONResult.data.password);
                        $("#id111").val(JSONResult.data.id);

                    layer.open({
                        type : 1,
                        area : ['600px', '300px'],

                        content : $('#updateDiv'),
                        btn : ['修改', '关闭'],
                        yes : function(index) {
                            console.log('修改');
                            var id= $("#id111").val();
                            var name=  $("#nameUpdate").val();
                            var password=  $("#passwordUpdate").val();
                            $.post(
                                '${pageContext.request.contextPath}/user?method=updateUser',
                                {"id":id,"name":name,"password":password},
                                function (JSONResult) {
                                    console.log(JSONResult)
                                    if(JSONResult.code==0){
                                        mylayer.confirm(JSONResult.msg,'${pageContext.request.contextPath}/user?method=selectByPage');
                                    }else {
                                        mylayer.errorMsg("编辑失败")
                                    }
                                },
                                'json'
                            )
                            layer.close(index);
                        },
                        btn2 : function() {
                            console.log('关闭');
                        },
                    });
                },
                'json'
            )

    }
</script>

</body>

</html>
