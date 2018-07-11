<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/11
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<head>
    <title>日志管理</title>
</head>
<script type="text/javascript">
    $(function(){
        $("#allLogs").datagrid({
            title:'日志管理',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/log/all",
            columns:[[
                {field:'logId',title:'日志编号',align:"center",width:200},
                {field:'logUser',title:'用户',align:"center",width:200},
                {field:'logTime',title:'时间',align:"center",width:200},
                {field:'logResource',title:'操作对象',align:"center",width:200},
                {field:'logAction',title:'操作',align:"center",width:200},
                {field:'logMessage',title:'详细信息',align:"center",width:200},
                {field:'logResult',title:'结果',align:"center",width:200}
            ]],
            pagination:true,
            pageSize:5,
            pageList:[5,10,15],
//            toolbar:"#tools",
            fit:true,

        });
    });
</script>


<%--展示所有--%>
<table id="allLogs"></table>

