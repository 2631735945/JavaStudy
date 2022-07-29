<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/28
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript"></script>
    <script src="static/jquery-2.1.4.js"></script>
    <script src="static/echarts.js"></script>
</head>
<body>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<div id="main1" style="width: 600px;height:400px;"></div>

<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart1 = echarts.init(document.getElementById('main1'));
    var option;
    var option1;

    $.post(
        '<%=request.getContextPath()%>/echarts',
        function (jsonObj){
            console.log(jsonObj)
            var xArray = new Array();
            var yArray = new Array();
            $(jsonObj).each(function () {
                xArray.push(this.name)
                yArray.push(this.value)
            });
            // 指定图表的配置项和数据
            option = {
                title: {
                    text: '班级人数统计'
                },
                tooltip: {},
                legend: {
                    data: ['人数']
                },
                xAxis: {
                    data:xArray
                },
                yAxis: {
                },
                series: [
                    {
                        name: '人数',
                        data:yArray,
                        type: 'bar'
                    }
                ]

            };
            // 使用刚指定的配置项和数据显示图表。
            option && myChart.setOption(option);

            option1 = {
                title: {
                    text: '班级人数统计',
                    subtext: 'Fake Data',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '50%',
                        data: jsonObj,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };

            option1 && myChart1.setOption(option1);


        },
        'json'
    );


</script>

</body>
</html>
