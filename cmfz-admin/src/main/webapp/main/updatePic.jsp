<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改轮播图</title>
</head>
<body>
<script type="text/javascript">
    $(function(){
        $("#ii1").textbox({
            required:true,
            validType:"length[2,20]",
        });
        $("#ii2").textbox({
            required:true,
            validType:"length[2,20]",
        });
        $("#ii3").textbox({
            required:true,
            editable:false,
        });

    });
</script>

<!-- form表单 -->
<div id="dia" style="margin-left: 150px;margin-top: 30px">
    <form id="updatePicForm" method="post">
        图片编号:<input id="ii" name="picture_id" readonly="readonly"><br><br>
        图片名称：<input id="ii1" name="picture_path" readonly="readonly"><br><br>
        描述信息：<input id="ii2" name="picture_description"><br><br>
        图片状态：<input id="ii3" name="picture_status"><br><br>
    </form>
</div>
</body>
</html>
