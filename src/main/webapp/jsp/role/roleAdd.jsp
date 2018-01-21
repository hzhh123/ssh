<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/global.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title></title>
    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="${path}/static/aceadmin/assets/css/font-awesome.css" />
    <link rel="stylesheet" href="${staticPath}/static/aceadmin/assets/js/layui/css/layui.css">
    <link rel="stylesheet" href="${staticPath}/static/plugin/select2/css/select2.min.css">
    <link rel="stylesheet" href="${staticPath}/static/css/default.css">
    <style type="text/css">
        .layui-layer.layui-layer-iframe{
            overflow: hidden;
            width: 100%;
        }
    </style>
</head>
<body >
<div class="layui-container">
    <form class="layui-form layui-form-pane" style="margin-top: 15px;" id="addForm">
        <div class="layui-form-item">
            <label class="layui-form-label">角色名称<span style="color: red;">*</span> </label>
            <div class="layui-input-block">
                <input type="text" name="role.name" id="name" lay-verify="required"  autocomplete="off" placeholder="请输入" class="layui-input" >
            </div>
        </div>
         <div class="layui-form-item" pane="">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="checkbox" name="role.status" value="1" lay-skin="switch" lay-text="有效|无效" checked>
            </div>
        </div>
         <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">顺序</label>
                <div class="layui-input-inline">
                    <input type="number" name="role.seq"   autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
               <textarea placeholder="请输入内容" name="role.description" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="login">立即提交</button>
            </div>
        </div>
    </form>
</div>
<!-- basic scripts -->
<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${path}/static/aceadmin/assets/js/jquery.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${path}/static/aceadmin/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->

<%--<script src="${path}/static/aceadmin/assets/js/layer/layer.js"></script>--%>
<script src="${path}/static/aceadmin/assets/js/layui/layui.js"></script>
<script src="${path}/static/plugin/select2/js/select2.min.js"></script>
<script src="${path}/static/js/util.js"></script>
<script type="text/javascript">
    layui.use(['form'], function() {
        var form = layui.form;
        var $=layui.jquery;
        function refresh() {
            parent.$('.btn-refresh').click();
        }
        
        //监听提交
        form.on('submit(login)', function(form){
                $.ajax({
                	url: basePath+"/role/role!add",
                    data: form.field,
                    dataType:'json',
                    type:'post',
                    success:function(data){
    					data=eval('('+data+')');
    					if(data.success){
    						$.layerMsg(data.msg, "success");
    						$.layerClose();
    						refresh();
    					}
                    },
                    error:function(error){
                    	$.layerMsg("添加出错", "error");
    					$.layerClose();
                    }
                });
            return false;
        });
        
       

    });

</script>
</body>
</html>
