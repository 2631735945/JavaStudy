<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/28
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市县三级联动</title>
    <script src="static/jquery-2.1.4.js"></script>
</head>
<body>
省份:<select id="provinceId">
    <option>---请选择省份---</option>
    </select>
城市:<select id="cityId">
    <option>---请选择城市---</option>
    </select>
区县:<select id="areaId">
    <option>---请选择县区---</option>
    </select>
<script type="text/javascript">
    $(function (){
        $.post(
            '<%=request.getContextPath()%>/ajax3?method=selectProvince',
            function (jsonObj) {
                console.log(jsonObj)
                $(jsonObj).each(function (){
                    // $('#provinceId').append('<option value="'+this.id+'">'+this.province+'</option>');
                       $("<option></option>")
                                .val(this.id)
                              .append(this.province)
                          .appendTo('#provinceId')
                });
            },
            'json'
        );
        $('#provinceId').change(function (){
            $('#cityId option:gt(0)').remove();
            $('#areaId option:gt(0)').remove();
            var provinceId=$('#provinceId').val();
            console.log(provinceId)

            $.post(
                '<%=request.getContextPath()%>/ajax3?method=selectCity',
                {"provinceId":provinceId},
                function (jsonObj) {
                    console.log(jsonObj)
                    $(jsonObj).each(function (){
                        // $('#cityId').append('<option value="'+this.id+'">'+this.city+'</option>');
                        $("<option></option>")
                            .val(this.id)
                            .append(this.city)
                            .appendTo('#cityId')
                    });
                },
                'json'
            );
        });
        $('#cityId').change(function () {
            var cityId= $('#cityId').val();
            $('#areaId option:gt(0)').remove();
            $.post(
                '<%=request.getContextPath()%>/ajax3?method=selectArea',
                {"cityId":cityId},
                function (jsonObj) {
                    console.log(jsonObj)
                    $(jsonObj).each(function (){
                        $('<option></option>')
                            .val(this.id)
                            .append(this.area)
                        .appendTo('#areaId')
                    });
                },
                'json'
            );



        });

    });


</script>
</body>
</html>
