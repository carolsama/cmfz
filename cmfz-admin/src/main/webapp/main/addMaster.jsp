<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/10
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加上师</title>
</head>
<body>
<script type="text/javascript">
    $(function(){
        $("#masterName").textbox({
            required:true,
            validType:"length[2,20]",
        });
        $("#masterPhoto").filebox({
            buttonText: '选择照片',
            buttonAlign: 'left'
        });

        $("#masterSummary").textbox({
            required:true,
            validType:"length[2,20]",
        });

    });
</script>

<!-- form表单 -->
<div id="dia" style="margin-left: 150px;margin-top: 30px">

    <form id="addMasterForm" method="post" enctype="multipart/form-data">

        上师法名：<input id="masterName" name="master_name" style="width: 200px"><br><br>
        上师头像：<input id="masterPhoto" name="master_photo" style="width: 200px"><br><br>
        上师简介：<input id="masterSummary" name="master_summary" style="width: 200px"><br><br>

    </form>
</div>
</body>
</html>
