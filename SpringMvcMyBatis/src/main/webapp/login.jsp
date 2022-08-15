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
    <script src="static/jquery-2.1.4.js"></script>
    <script src="static/bootstrap-3.4.1/dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.4.1/dist/css/bootstrap.css">
    <script src="static/layer/layer.js"></script>
    <script src="static/mylayer.js"></script>
    <style type="text/css">
        /*body{*/
        /*    width: 600px;*/
        /*}*/
    </style>
</head>
<body >

<%--<form id="formId" method="post">--%>

<%--    用户名：<input type="text" name="name"><br>--%>
<%--    密码：  <input type="password" name="password"><br>--%>
<%--    验证码：<input type="text" name="code">--%>
<%--&lt;%&ndash;    <img id="verigyCodeId" src="${pageContext.request.contextPath}/verifyCode" onclick="refresh()"><br/>&ndash;%&gt;--%>
<%--    <input type="button" onclick="submitForm()" value="登录">--%>
<%--    <button id="registerId" onclick="register()">注册</button>--%>
<%--</form>--%>

<form class="form-horizontal" id="formId" method="post">
<%--    class="col-md-4 col-md-offset-8"--%>
    <div class="form-group" >
        <label for="nameLogin" class="col-sm-2 control-label">用户名：</label>
        <div class="col-sm-10">
            <input type="text" class=".col-xs-6 .col-md-4 form-control" id="nameLogin" name="name" placeholder="name">
        </div>
    </div>

    <div class="form-group">
        <label for="passwordLogin" class="col-sm-2 control-label">密码:</label>
        <div class="col-sm-10">
            <input type="password" class=".col-xs-6 .col-md-4 form-control" name="password" id="passwordLogin" placeholder="Password">
        </div>
    </div>

    <div class="form-group">
        <label for="code1" class="col-sm-2 control-label">验证码:</label>
        <div class="col-sm-10">
            <input type="text" name="code" class=".col-xs-6 .col-md-4 form-control" id="code1" placeholder="验证码"><br>
            <img id="verigyCodeId"  onclick="refresh()" src="${pageContext.request.contextPath}/verifyCode/verifyCode1.action" onclick="refresh()" ><br/>
<%--            onclick="refresh()"--%>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> 记住密码
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-default" onclick="submitForm()">登录</button>
<%--            <input type="button" class="btn btn-default" id="registerId" value="注册"  data-toggle="modal" data-target="#registerModal">--%>
            <input type="button" class="btn btn-default" id="registerId" onclick="register()" value="注册" >
        </div>
    </div>
</form>


<script type="text/javascript">

    // $('#registerId').click(function () {
    //     //弹出模态框
    //     $("#registerModal").modal({
    //         backdrop:"static"
    //     });
    // });

    function register(){
        layer.open({
            type : 1,
            area : ['500px', '300px'],
            content : $('#registerDiv'),
            btn : ['注册', '关闭'],
            yes : function(index) {
                console.log('注册');
                $.post(
                    '${pageContext.request.contextPath}/user/register.action',
                    $('#registerForm').serialize(),
                    function (JSONResult) {
                        console.log(JSONResult)
                        if(JSONResult.code==0){
                            mylayer.confirm(JSONResult.msg,'${pageContext.request.contextPath}/login.jsp')
                        }else {
                            mylayer.errorMsg(JSONResult.msg)
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
    }



    function refresh(){
        $('#verigyCodeId').attr('src','${pageContext.request.contextPath}/verifyCode'+Math.random());
    }

    function submitForm() {
    $.post(
        '${pageContext.request.contextPath}/user/login.action',
        $('#formId').serialize(),
        function (JSONRequest) {
            console.log(JSONRequest)
            if(JSONRequest.code == 0){
                mylayer.okUrl(JSONRequest.msg,'${pageContext.request.contextPath}')
            }else {
                mylayer.errorMsg(JSONRequest.msg)
            }
        },
        'json'
    )
}


</script>
</body>
<div id="registerDiv" style="display: none;">

    <form class="form-horizontal" id="registerForm" method="post">
        <%--    class="col-md-4 col-md-offset-8"--%>
        <div class="form-group" >
            <label for="nameLogin" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-10">
                <input type="text" class=".col-xs-6 .col-md-4 form-control" id="nameRegister" name="name" placeholder="name">
            </div>
        </div>

        <div class="form-group">
            <label for="passwordLogin" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-10">
                <input type="password" class=".col-xs-6 .col-md-4 form-control" name="password" id="passwordRegister" placeholder="Password">
            </div>
        </div>
            <div class="form-group">
                <label for="passwordLogin" class="col-sm-2 control-label">年龄:</label>
                <div class="col-sm-10">
                    <input type="text" class=".col-xs-6 .col-md-4 form-control" name="age" id="ageRegister" placeholder="年龄">
                </div>
            </div>
            <div class="form-group">
                <label for="passwordLogin" class="col-sm-2 control-label">地址:</label>
                <div class="col-sm-10">
                    <input type="text" class=".col-xs-6 .col-md-4 form-control" name="address" id="addressRegister" placeholder="地址">
                </div>
            </div>
            <div class="form-group">
                <label for="passwordLogin" class="col-sm-2 control-label">性别:</label>
                <div class="col-sm-10">
                    <input type="text" class=".col-xs-6 .col-md-4 form-control" name="gender" id="genderRegister" placeholder="性别">
                </div>
            </div>


    </form>

</div>
</html>
