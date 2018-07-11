<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/8
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" >

    $(function(){
        $("#allMaster").datagrid({
            title:'上师信息管理',
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/master/showAll",
            columns:[[
                {field:'master_id',title:'上师编号',align:"center",width:300},
                {field:'master_name',title:'上师法名',align:"center",width:250},
                {field:'master_photo',title:'上师头像',align:"center",width:250},
                {field:'master_summary',title:'上师简介',align:"center",width:200}

            ]],
            pagination:true,
            pageSize:5,
            pageList:[5,10,15],
            toolbar:"#masterTool",
            fit:true,
            view: detailview,
            detailFormatter: function (rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="http://localhost:8888/cmfz-admin/upload/'+rowData.master_photo+'" style="height:300px;width: 450px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }
        });

        /*新增上师*/
        $("#addMaster").linkbutton({
           onClick:function(){
               $("#dialogAddMaster").dialog({
                   title: '添加上师',
                   width: 550,
                   height: 250,
                   href: "${pageContext.request.contextPath}/main/addMaster.jsp",
                   buttons:[{
                       text:"保存",
                       iconCls:"icon-save",
                       handler:function(){
                           $("#addMasterForm").form("submit",{
                               url:"${pageContext.request.contextPath}/master/add",
                               onSubmit: function(){
//                            return $("#addPicForm").form("validate");
                               },
                               success:function(data){
                                   $.messager.alert("提示",data);
                                   $("#dialogAddMaster").dialog("close");
                                   $("#allMaster").datagrid("reload");
                               }
                           });
                       }
                   },{
                       text:"取消",
                       iconCls:"icon-cancel",
                       handler:function(){
                           $("#dialogAddMaster").dialog("close");
                       }
                   }],
               });
           },
        });


        /*修改上师*/
        $("#modifyMaster").linkbutton({
            onClick:(function () {
                var pic=$("#allMaster").datagrid("getSelected");
                if(pic==null){
                    $.messager.alert("提示","请选择修改项！");
                }else{
                    $("#dialogUpdateMaster").dialog({
                        title: '修改轮播图',
                        width: 600,
                        height: 250,
                        href: "${pageContext.request.contextPath}/main/updateMaster.jsp",
                        onLoad:function(){
                            $("#updateMasterForm").form("load",pic);
                        },
                        buttons:[{
                            text:"提交",
                            iconCls:"icon-ok",
                            handler:function(){
                                $("#updateMasterForm").form("submit",{
                                    url:"${pageContext.request.contextPath}/master/update",
                                    onSubmit: function(){

                                    },
                                    success:function(data){
                                        $.messager.alert("提示",data);
                                        $("#dialogUpdateMaster").dialog("close");
                                        $("#allMaster").datagrid("reload");
                                    }
                                });
                            }
                        },{
                            text:"取消",
                            iconCls:"icon-cancel",
                            handler:function(){
                                $("#dialogUpdateMaster").dialog("close");
                            }
                        }],
                    });
                }
            })

        });


    /*批量插入*/
        $("#guru_btn").linkbutton({
            onClick:function () {
                $("#masterForm").form("submit",{
                    url:"${pageContext.request.contextPath}/master/addBatch",
                    onSubmit:function () {

                        return true;
                    },
                    success:function (data) {
                        alert(data)
                    }
                });
            }
        });


    });


</script>
<%--展示所有--%>
<table id="allMaster" ></table>

<div id="masterTool">
    <a id="addMaster" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >添加上师</a>
    <a id="modifyMaster" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" >修改上师</a>
    <a id="helpMaster" class="easyui-linkbutton" data-options="iconCls:'icon-help'" style="margin-right: 0px">帮助</a>

    <form id="masterForm" method="post" enctype="multipart/form-data">
         <div>
            请选择Excel文件：<input class="easyui-filebox" style="width: 200px" name="masterFile">
        </div>
    </form>
    <a class="easyui-linkbutton" id="guru_btn">提交>></a>

</div>
<%--弹出对话框窗口--%>
<div id="dialogUpdateMaster"></div>
<div id="dialogAddMaster"></div>
</body>
</html>
