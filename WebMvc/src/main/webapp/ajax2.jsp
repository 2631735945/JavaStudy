<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/27
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/jquery-2.1.4.js"></script>
</head>
<body>
<input type="text" name="name"  id="nameId" ><span id="spanNameId"></span><br>
<input type="password" name="password"  id="passwordId" ><span id="spanPasswordId"></span><br>
<input type="submit" value="登录">

</body>
<script>
    $(function (){
        $('#nameId').blur(function () {
            //this
            var name=$(this).val();
            $.post(
                '<%=request.getContextPath()%>/ajax2',
                {"name":name},
                function (jsonObj) {
                    console.log(jsonObj)
                   if(jsonObj.exist){
                       $('#spanNameId').html(jsonObj.msg)
                       $('#spanNameId').css('color','red')
                   }else {
                       $('#spanNameId').html(jsonObj.msg)
                       $('#spanNameId').css('color','green')
                   }
                },
                'json'
            );
        });
    })
</script>
</html>
