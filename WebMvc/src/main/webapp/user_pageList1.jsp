<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/30
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <thead>
    <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>密码</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>

<nav aria-label="Page navigation" id="navId">
    <ul class="pagination" id="ulId">
<%--        <li>--%>
<%--            <c:if test="${pageInfo.pageNo==1}">--%>
<%--                <a href="#" aria-label="Previous">--%>
<%--                    <span aria-hidden="true">&laquo;</span>--%>
<%--                </a>--%>
<%--            </c:if>--%>

<%--            <c:if test="${pageInfo.pageNo>1}">--%>
<%--                <a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${pageInfo.pageNo-1}"--%>
<%--                   aria-label="Previous">--%>
<%--                    <span aria-hidden="true">&laquo;</span>--%>
<%--                </a>--%>
<%--            </c:if>--%>

<%--        </li>--%>
<%--        <c:forEach begin="1" end="${pageInfo.totalPages}" var="i">--%>
<%--            <li><a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${i}">${i}</a></li>--%>
<%--        </c:forEach>--%>


<%--        &lt;%&ndash;        javaScript:nextPage(<%=pageInfo.getPageNo()>,<%=pageInfo.getTotalPages()%>)&ndash;%&gt;--%>
<%--        <li>--%>

<%--            <c:if test="${pageInfo.pageNo<pageInfo.totalPages}">--%>
<%--                <a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${pageInfo.pageNo+1}"--%>
<%--                   aria-label="Next">--%>
<%--                        &lt;%&ndash;    <%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=<%=pageInfo.getPageNo()+1%>&ndash;%&gt;--%>
<%--                    <span aria-hidden="true">&raquo;</span>--%>
<%--                </a>--%>
<%--            </c:if>--%>
<%--            <c:if test="${pageInfo.pageNo==pageInfo.totalPages}">--%>
<%--                <a href="#" aria-label="Next">--%>
<%--                        &lt;%&ndash; <%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=<%=pageInfo.getPageNo()+1%> &ndash;%&gt;--%>
<%--                    <span aria-hidden="true">&raquo;</span>--%>
<%--                </a>--%>
<%--            </c:if>--%>

<%--        </li>--%>
    </ul>
</nav>
<script type="text/javascript">
    $.post(
        '${pageContext.request.contextPath}/user?method=selectByPage',
        function (JSONResult){
            console.log(JSONResult)
            var list=JSONResult.data.list
            console.log(list)
            $(list).each(function(){

                var id=$("<td></td>").append(this.id)
                var name=$("<td></td>").append(this.name)
                var password=$("<td></td>").append(this.password)
                //编辑按钮                                 edit_btn 和 detele_btn 做标记
                var editBtn1=$("<button></button>").attr('id','editId').addClass("btn btn-primary btn-sm edit_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
                //删除按钮
                var delBtn1=$("<button></button>").attr('id','deleteId').addClass("btn btn-danger b").addClass("btn btn-danger btn-sm delete_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
                var editBtn=$("<td></td>").append(editBtn1)
                var delBtn=$("<td></td>").append(delBtn1);

                $("<tr></tr>")
                    .append(id)
                    .append(name)
                    .append(password)
                    .append(editBtn)
                    .append(delBtn)
                .appendTo("#tableid tbody")

<%--                <c:if test="${pageInfo.pageNo==1}">--%>
<%--                <a href="#" aria-label="Previous">--%>
<%--                    <span aria-hidden="true">&laquo;</span>--%>
<%--            </a>--%>
<%--                </c:if>--%>
                var data=JSONResult.data;
                console.log(data.pageNo-1)
                if(data.pageNo==1){
                   $("<li></li>").append($("<a></a>").attr("href","#").attr("aria-label","Previous"))
                        .append($("<span></span>").attr("aria-hidden","true")).append("&laquo;")
                        .appendTo("#ulId")
                }else {
                    <%--//<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${pageInfo.pageNo+1}--%>
                    $("<li></li>").append($("<a></a>").attr("href","${pageContext.request.contextPath}/user?method=selectByPage&pageNo=${data.pageNo-1}").attr("aria-label","Previous"))
                        .append($("<span></span>").attr("aria-hidden","true")).append("&laquo;")
                        .appendTo("#ulId")
                }
<%--                 <c:forEach begin="1" end="${pageInfo.totalPages}" var="i">--%>
<%--            <li><a href="<%=request.getContextPath()%>/teacher?method=selectByPage&pageNo=${i}">${i}</a></li>--%>
<%--        </c:forEach>--%>
                for(var i=1;i<=data.totalPages;i++){
                    $("<li></li>").append($("<a></a>").attr("href", "<%=request.getContextPath()%>/user?method=selectByPage&pageNo="+i)).append(i)
                    .appendTo("#ulId")
                }
            });

        },
        'json'
    )
</script>
</body>
</html>
