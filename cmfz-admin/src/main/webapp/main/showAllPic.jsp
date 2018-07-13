<%@ page  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<title>datagride-view</title>

<script type="text/javascript" >
    $(function(){
        $("#all").datagrid({
            title:'轮播图管理',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/picture/all",
            columns:[[
                {field:'picture_id',title:'标识编号',align:"center",width:300},
                {field:'picture_path',title:'图片名称',align:"center",width:250},
                {field:'picture_description',title:'图片描述',align:"center",width:250},
                {field:'picture_status',title:'展示状态',align:"center",width:200},
                {field:'picture_date',title:'上传时间',align:"center",width:300}
            ]],
            pagination:true,
            pageSize:5,
            pageList:[5,10,15],
            toolbar:"#tools",
            fit:true,
            view: detailview,
            detailFormatter: function (rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="http://localhost:8888/cmfz-admin/upload/'+rowData.picture_path+'" style="height:300px;width: 450px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });
    /*新增轮播图窗口*/
    
    function add(){
        $("#dialogAdd").dialog({
            title: '新增轮播图',
            width: 550,
            height: 250,
            href: "${pageContext.request.contextPath}/main/addPic.jsp",
            buttons:[{
                text:"保存",
                iconCls:"icon-save",
                handler:function(){
                    $("#addPicForm").form("submit",{
                        url:"${pageContext.request.contextPath}/picture/add",
                        onSubmit: function(){
//                            return $("#addPicForm").form("validate");
                        },
                        success:function(data){
                            $.messager.alert("提示",data);
                            $("#dialogAdd").dialog("close");
                            $("#all").datagrid("reload");
                        }
                    });
                }
            },{
                text:"取消",
                iconCls:"icon-cancel",
                handler:function(){
                    $("#dialogAdd").dialog("close");
                }
            }],
        });
    }
    /*修改轮播图窗口*/
    function edit(){
        var pic=$("#all").datagrid("getSelected");
        if(pic==null){
            $.messager.alert("提示","请选择修改项！");
        }else{
            $("#dialog").dialog({
                title: '修改轮播图',
                width: 600,
                height: 250,
                href: "${pageContext.request.contextPath}/main/updatePic.jsp",
                onLoad:function(){
                    $("#updatePicForm").form("load",pic);
                },
                buttons:[{
                    text:"提交",
                    iconCls:"icon-ok",
                    handler:function(){
                        $("#updatePicForm").form("submit",{
                            url:"${pageContext.request.contextPath}/picture/update",
                            onSubmit: function(){
//                                return $("#updatePicForm").form("validate");
                            },
                            success:function(data){
                                $.messager.alert("提示",data);
                                $("#dialog").dialog("close");
                                $("#all").datagrid("reload");
                            }
                        });
                    }
                },{
                    text:"取消",
                    iconCls:"icon-cancel",
                    handler:function(){
                        $("#dialog").dialog("close");
                    }
                }],
            });

        }
    }

</script>
    <%--展示所有--%>
    <table id="all" ></table>

    <div id="tools">
        <shiro:hasPermission name="picture:add">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">新增轮播图</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="picture:update">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit()">修改</a>
        </shiro:hasPermission>
    </div>
    <%--弹出对话框窗口--%>
<div id="dialog"></div>
<div id="dialogAdd"></div>

