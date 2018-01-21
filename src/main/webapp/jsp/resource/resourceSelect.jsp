<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
 <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title>选择父级资源</title>
<%@include file="/common/global.jsp" %>
<link rel="stylesheet" href="${path}/static/aceadmin/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
<link rel="stylesheet" href="${path}/static/aceadmin/assets/css/ace-part2.css" class="ace-main-stylesheet" />
<![endif]-->

<!--[if lte IE 9]>
<link rel="stylesheet" href="${path}/static/aceadmin/assets/css/ace-ie.css" />
<![endif]-->
<link rel="stylesheet" href="${staticPath}/static/css/aceadmin-style.css">
<!-- inline styles related to this page -->
 <link href="${staticPath }/static/plugin/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${staticPath}/static/plugin/jstree/dist/themes/default/style.css">
     <link rel="stylesheet" href="${staticPath}/static/aceadmin/assets/js/layui/css/layui.css">
</head>
<body style="background: #fff;">
<div id="deptTree" style="overflow-x:hidden;overflow-y:auto;height:calc(100% - 60px)"></div>

<div style="position: fixed;bottom:0px;width:100%;">
<hr>
<div style="float: right;margin:0px 10px 10px 10px;">
	<button class="layui-btn layui-btn-primary" id="close">关闭</button>
	<button class="layui-btn" id="ok">确定</button>
</div> 
</div>
<input type="hidden" id="id"/>
<input type="hidden" id="name"/>
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
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='${path}/static/aceadmin/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
</script>
<script src="${ctx}/static/plugin/jstree/dist/jstree.min.js"></script>
<script src="${ctxPath}/static/aceadmin/assets/js/layui/layui.all.js"></script>
<script src="${path}/static/js/util.js"></script>
<script type="text/javascript">
layui.use(['form'], function() {
    var form = layui.form;
	var setting = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        $('#deptTree').jstree({
            'core' : {
                'data' : {
                    "url" : basePath+"/resource/resource!jstree",
                    "dataType" : "json" // needed only if you do not supply JSON headers
                }
            }
        }).bind('select_node.jstree', function(event,selected,node) {
            var id=selected.node.id;
            var name=selected.node.text;
            $('#id').val(id);
            $('#name').val(name);
        });

        $('#close').click(function(){
        	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        	parent.layer.close(index); //再执行关闭 
        })
        $('#ok').click(function(){
            var name=$('#name').val();
            var id=$('#id').val();
            if(id!=""){
            	$.ajax({
            		//async:false,
                	url:basePath+'/resource/resource!get',
                	data:{"id":id},
                	type:'post',
                	dataType:'json',
                	success:function(data){
                		data=eval('('+data+')');
                		console.log(data.level);
                		parent.$('#level').val(data.level+1);
                	}
                 })
            }
        	parent.$('#parentName').val(name); 
        	parent.$('#pid').val($('#id').val());
        	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        	parent.layer.close(index); //再执行关闭 
        })
})
</script>
</body>
</html>