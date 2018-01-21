<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/26
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
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
    <input type="hidden" name="organization.id" value="${organization.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">组织机构<span style="color: red;">*</span> </label>
            <div class="layui-input-block">
                <input type="text" name="organization.orgname" id="orgname" value="${organization.orgname}" lay-verify="required"  autocomplete="off" placeholder="请输入" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">组织机构码<span style="color: red;">*</span> </label>
            <div class="layui-input-block">
                <input type="text" name="organization.orgno"  lay-verify="required" value="${organization.orgno}"  autocomplete="off" placeholder="请输入" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父机构</label>
            <div class="layui-input-block">
                <input type="text" name="organization.parentName"  autocomplete="off" placeholder="请选择" class="layui-input" id="orgName" value="${organization.parentName}">
                <input type="hidden" name="organization.pid" id="orgid" value="${organization.pid}"> 
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="organization.description" class="layui-textarea">${organization.description}</textarea>
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

        $('#orgName').focus(function(){
        	 layer.open({
     	        type: 2,
     	        title: '选择部门用户',
     	        shadeClose: true,
     	        shade: false,
     	        maxmin: true,
     	        area: ['60%', '80%'],
     	        content: '${ctxPath}/jsp/org/orgSelect.jsp', //iframe的url
     	  });
			this.blur();
        });
        
        //监听提交
        form.on('submit(login)', function(form){
                $.ajax({
                	url: basePath+"/organization/organization!update",
                    data: form.field,
                    dataType:'json',
                    type:'post',
                    success:function(data){
    					data=eval('('+data+')');
    						$.layerMsg("修改成功！", "success");
    						$.layerClose();
    						refresh();
    					
                    },
                    error:function(error){
                    	$.layerMsg("修改失败", "error");
    					$.layerClose();
                    }
                });
            return false;
        });
        
       

    });

</script>
</body>
</html>
