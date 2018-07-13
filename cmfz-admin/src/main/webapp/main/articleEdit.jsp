<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/8
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑文章</title>
</head>
<body>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->

<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload';

    editor.customConfig.uploadFileName = 'files';//上传图片的名称

    var $text1 = $('#text1')
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    }
    editor.create()
    // 初始化 textarea 的值
    $text1.val(editor.txt.html())

    $(function () {

        $("#articleTable").datagrid({
            title: '编辑文章',
        });

        /*提交表单*/
        $("#ArticleBtn").linkbutton({
             onClick:function () {

                $("#articleForm").form("submit",{
                    url:"${pageContext.request.contextPath}/article/add",
                    onSubmit:function () {
                        return true;
                    },
                    success:function (data) {
                        alert(data)
                    }
                })

            }

        });


        /*大师下拉框*/
        $("#authorText").combobox({
            url:'${pageContext.request.contextPath}/master/all',
            valueField:"master_id",
            textField:"master_name",
            limitToList:true
         });
    });




</script>

<table id ="articleTable"></table>

<form id="articleForm" enctype="multipart/form-data" method="post">
    <div id="articleBox">

        文章标题:<input id="articleTitle" type="text" name="article_name"><br><br>
        作&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp者:<input id="authorText" name="guru_id"/><br><br>
        是否展示: <input class="easyui-switchbutton" data-options="onText:'Yes',offText:'No'" name="article_status"><br>
        <input id="text1" name="article_text" type="hidden"/>

    </div>
    <%--编辑器--%>
    <div id="editor">
        <p>欢迎使用富文本编辑器</p>

    </div>


</form>

    <div id="bb" align="center">
        <br><br>
        <button id="ArticleBtn" >提交</button>
        <button id="btn2" class="easyui-linkbutton" >返回</button>
    </div>
</body>
</html>
