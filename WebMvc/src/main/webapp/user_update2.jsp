<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/8/1
  Time: 20:35
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
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <script src="static/layui/layui.js"></script>
    <script src="static/layer/layer.js"></script>
    <script src="static/mylayer.js"></script>

</head>
<body>
<form id="formId" class="layui-form layui-form-pane" action="">
    <input type="hidden" id="id1" name="id" />
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="name" id="nameId"  autocomplete="off" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" id="passwordId" autocomplete="off" placeholder="请输入密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="age" id="ageId" autocomplete="off" placeholder="请输入年龄" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <input type="text" name="address" id="addressId"  autocomplete="off" placeholder="请输入地址" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
                <input type="radio" name="gender" id="manId" value="男" title="男" >
                <input type="radio" name="gender" id="womanId" value="女" title="女">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" onclick="updateForm()" class="layui-btn" lay-submit="" lay-filter="demo1">保存更改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    $(function () {
        $.post(
            '${pageContext.request.contextPath}/layUser?method=selectById',
            {"id":'${param.id}'},
            function (jsonResult) {
                console.log(jsonResult)
                var user=jsonResult.data
                $('#id1').val(user.id)
                $('#nameId').val(user.name)
                $('#passwordId').val(user.password)
                $('#ageId').val(user.age)
                $('#addressId').val(user.address)
                console.log(user.gender=="男")
                // if(user.gender=="男"){
                //     $("input[name=gender][value="+user.gender+"]").prop("checked",true)
                    $('#manId').attr("checked","checked")
                // }else{
                //     $('input[name="gender"]').prop("checked",true)
                //     // $('input[name="gender"]').val(['女'])
                //     // $('#woman').attr("checked",true)
                // }
            },
            'json'
        );
        
    });
    
    layui.use(['form', 'laydate'], function() {
        var form = layui.form;
        var laydate = layui.laydate;
    });

    function updateForm(){

            $.post(
                '${pageContext.request.contextPath}/layUser?method=updateUser',
                $('#formId').serialize(),
                function (jsonResult) {
                    console.log(jsonResult)
                    if (jsonResult.code == 0) {
                        // mylayer.okMsg(jsonResult.msg);
                        // 获得当前弹出框的index
                        var index = parent.layer.getFrameIndex(window.name);
                        layer.msg(
                            jsonResult.msg,
                            {icon:1, time:1000},
                            function() { // msg弹出1秒后消失触发这个函数
                                // 关闭弹出层
                                parent.layer.close(index);
                                // 刷新父页面
                                window.parent.location.reload();
                            }
                        );
                    } else {
                        mylayer.errorMsg(jsonResult.msg);
                    }
                },
                'json'
            );
    }
</script>
</body>
</html>
