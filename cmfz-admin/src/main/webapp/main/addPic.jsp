<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加轮播图</title>
</head>
<body>
<script type="text/javascript">
    $(function(){
        $("#file").filebox({
            buttonText: '选择文件',
            buttonAlign: 'left'
        });
        $("#ii1").textbox({
            required:true,
            validType:"length[2,20]",
        });
        $("#ii2").textbox({
            required:true,
            validType:"length[2,20]",
        });
//        $('#ii3').combo({
//            required:true,
//            multiple:false,
//        });

        $('#ii3').textbox({
            required:true,
            multiple:false,
        });
    });
</script>

    <!-- form表单 -->
    <div id="dia" style="margin-left: 150px;margin-top: 30px">

        <form id="addPicForm" method="post" enctype="multipart/form-data">
            选择图片：<input id="file" name="picFile" style="width: 200px"><br><br>
            图片名称：<input id="ii1" name="picture_path" style="width: 200px"><br><br>
            图片描述：<input id="ii2" name="picture_description" style="width: 200px"><br><br>
            图片状态：<input id="ii3" name="picture_status" style="width: 200px"><br><br>

        </form>
    </div>
</body>
</html>
