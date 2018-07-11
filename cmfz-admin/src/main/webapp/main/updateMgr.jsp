<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改管理员密码</title>
</head>
<body>
    <script type="text/javascript">
        $(function () {
//           $("#mgrname").textbox({
//
//           }) ;
           $("#mgrpwd").textbox({
               required:true,
               validType:"length[3,10]",
           });
        });
    </script>
<%--修改密码表单--%>
<div id="dd" style="width: 400px ;length:300px">
    <form id="updateMgr" method="post">
        管理员姓名:<input id="mgrname" name="mgr_name" value="${sessionScope.mgr.mgr_name}" readonly="readonly"/><br><br>
        请输入密码:<input id="mgrpwd" name="mgr_pwd" value="${sessionScope.mgr.mgr_pwd}"/>
    </form>
</div>
</body>
</html>
