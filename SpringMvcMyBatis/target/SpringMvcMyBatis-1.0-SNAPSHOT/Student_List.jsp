<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/8/12
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<table class="layui-hide" id="test" lay-filter="layFilter"></table>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="deleteAll">批量删除</button>
    </div>
</script>


<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'${pageContext.request.contextPath}/student/selectByPage.action'
            ,toolbar: '#toolbarDemo'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {type:'checkbox', fixed: 'left'}
                ,{field:'id', title: 'ID', sort: true}
                ,{field:'name',  title: '用户名'}
                ,{field:'age', title: '年龄'}
                ,{field:'gender', title: '性别'}
                ,{title:'操作', toolbar: '#barDemo'}
            ]]
            ,page: true
            ,id: 'tableId'
        });

        //触发单元格工具事件
        table.on('tool(layFilter)', function(obj){ // 双击 toolDouble
            console.log(obj)
            var data = obj.data;
            // {"id":2,"name":"root1","password":"E10ADC3949BA59ABBE56E057F20F883E","age":12,"address":"ee","gender":"男"}
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的要删除该数据吗？', function(index){
                    $.post(
                        '${pageContext.request.contextPath}/student/deleteById.action',
                        {"id":data.id},
                        function (JSONResult){
                            console.log(JSONResult)
                            if(JSONResult.code==0){
                                mylayer.okMsg(JSONResult.msg)
                                //删除之后重新刷新table表格
                                table.reload('tableId');
                            }else {
                                mylayer.errorMsg(JSONResult.msg)
                            }

                        },
                        'json'
                    );
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type : 2,
                    area : ['500px', '400px'],
                    <%--content: '${pageContext.request.contextPath}/layUser?method=getUserUpdatePage&id='+data.id--%>
                    content: '${pageContext.request.contextPath}/student_update.jsp?id='+data.id ,
                    end:function(){
                        table.reload("tableId")
                    },
                    success:function(layero,index){
                    //    数据回显
                        var body=layer.getChildFrame('body',index);
                        body.find("#id1").val(obj.data.id)
                        body.find("#nameId").val(obj.data.name)
                        body.find("#ageId").val(obj.data.age)
                        body.find("input[name='gender'][value='男']").attr('checked',obj.data.gender=='男'?true:false);
                        body.find("input[name='gender'][value='女']").attr('checked',obj.data.gender=='女'?true:false);

                    }
                });
            }
        });

        //头工具栏事件
        table.on('toolbar(layFilter)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    layer.open({
                        type : 2,
                        area : ['500px', '400px'],
                        content: '${pageContext.request.contextPath}/student_add.jsp'
                    });
                    break;
                case 'deleteAll':
                    var data = checkStatus.data; //获取选中的数据
                    // layer.alert(JSON.stringify(data));
                    // [{"id":5,"name":"23","password":"sd","age":0,"address":null},{"id":6,"name":"s","password":"sd","age":0,"address":null}]
                    var ids = [];
                    $(data).each(function() {
                        ids.push(this.id);
                    });
                    // [5,6]
                    // ids = ids.join(','); // "5,6"
                    layer.confirm('真的删除行么', function(index){
                        $.post(
                            '${pageContext.request.contextPath}/student/deleteAll.action',
                             // JSON.stringify(ids),
                             // {ids : JSON.stringify(ids)},
                            {'ids' : ids},
                            function(jsonObj) {
                                console.log(jsonObj);
                                if (jsonObj.code == 0) {
                                    mylayer.okMsg(jsonObj.msg);
                                    // 删除之后重新刷新table表格
                                    table.reload('tableId');
                                } else {
                                    mylayer.errorMsg(jsonObj.msg);
                                }
                            },
                            'json'
                        );

                    });
                    break;
                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };
        });


    });
</script>
</body>
</html>
