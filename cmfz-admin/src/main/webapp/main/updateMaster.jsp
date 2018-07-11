<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/10
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#masterName").textbox({
           // required:true,

        });
        $("#masterId").textbox({
            // required:true,

        });
        $("#masterSummary").textbox({
            required:true,
            validType:"length[2,20]",
        });


    });
</script>

<!-- form表单 -->
<div id="updateMasterDiv" style="margin-left: 150px;margin-top: 30px">
    <form id="updateMasterForm" method="post">
        上师法名：<input id="masterId" name="master_id" value="master_id" readonly="readonly"><br><br>
        上师法名：<input id="masterName" name="master_name" value="master_name" readonly="readonly"><br><br>
        描述信息：<input id="masterSummary" name="master_summary" value="master_summary"><br><br>

    </form>
</div>
