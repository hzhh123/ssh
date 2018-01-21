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


    </style>
</head>
<body >
<div class="layui-container-fluid">
 <div class="layui-row" style="overflow:auto;">
    <form class="layui-form"  id="addForm" style="margin:10px;">
    	<input type="hidden" name="user.id" value="${user.id}">
        <div class="layui-form-item" >
            <label class="layui-form-label">用户名 </label>
            <div class="layui-input-block">
                <input type="text" name="user.username" id="username" value="${user.username }"   autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="user.name" value="${user.name }" autocomplete="off"  class="layui-input" id="name" >
            </div>
        </div>
        
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
             <c:if test="${user.sex==1}">
             	<input type="radio" name="user.sex" value="1" title="男" checked="">
                <input type="radio" name="user.sex" value="0" title="女">
             </c:if>
             <c:if test="${user.sex==0}">
             	<input type="radio" name="user.sex" value="1" title="男">
                <input type="radio" name="user.sex" value="0" title="女" checked="">
             </c:if>
                
            </div>
        </div>
        <div class="layui-form-item">
                <label class="layui-form-label">职务/工种</label>
                <div class="layui-input-block">
                    <input type="text" name="user.workType" id="workType"  value="${user.workType}"   autocomplete="off" class="layui-input">
                </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
          		<c:if test="${user.status==1}">
                  <input type="checkbox" name="user.status" value="1" lay-skin="switch" lay-text="有效|无效" checked>
          		</c:if>
          		<c:if test="${user.status!=1}">
                  <input type="checkbox" name="user.status" value="1" lay-skin="switch" lay-text="有效|无效">
          		</c:if>
            </div>
        </div>
        <div class="layui-form-item">
                <label class="layui-form-label">直接上级</label>
                <div class="layui-input-block">
                    <input type="text" name="leaderName" id="leaderName" value="${user.leaderName}"    autocomplete="off" class="layui-input">
                    <input type="hidden" name="user.leader" id="leader" value="${user.leader}">
                </div>
        </div>
        <div class="layui-form-item">
                <label class="layui-form-label">所属项目</label>
                <div class="layui-input-block">
                    <input type="text" name="projectName" id="projectName" value="${project.name}"    autocomplete="off" class="layui-input">
                    <input type="hidden" name="user.pjId" id="pjId" value="${project.id}">
                </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">年龄</label>
                <div class="layui-input-inline">
                    <input type="number" name="user.age" lay-verify="age"  autocomplete="off" class="layui-input" value="${user.age}">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机</label>
            <div class="layui-input-block">
                <input type="tel" name="user.phone" lay-verify="required"  autocomplete="off"  class="layui-input" value="${user.phone}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">民族</label>
            <div class="layui-input-block">
                <input type="text" name="user.national"   autocomplete="off"  class="layui-input"  value="${user.national}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">文化程度</label>
            <div class="layui-input-block">
                <input type="text" name="user.education"   autocomplete="off"  class="layui-input"  value="${user.education}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">进场日期</label>
            <div class="layui-input-block">
                <input type="text" name="user.enterDay" id="enterDay"  autocomplete="off"  class="layui-input"  value="${user.birthday}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-block">
                <input type="text" name="user.birthday" id="birthday"  autocomplete="off"  class="layui-input"  value="${user.enterDay}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号码</label>
            <div class="layui-input-block">
                <input type="text" name="user.idNum"  autocomplete="off"  class="layui-input"  value="${user.idNum}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户类型</label>
            <div class="layui-input-block">
                  <select name="user.userType">
                        <option value="0" <c:if test="${user.userType==0}">selected</c:if>>管理员</option>
                        <option value="1" <c:if test="${user.userType==1}">selected</c:if>>用户</option>
                    </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门</label>
            <div class="layui-input-block">
                  <input type="text" name="orgName" value="${org.orgname}"  id="org"   autocomplete="off"  class="layui-input">
                  <input type="hidden" name="user.organizationId" id="orgid" value="${org.id}"> 
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-block">
                <c:forEach var="role" items="${roles}">
                   <c:if test="${roles.size()>0}">
                        <input type="checkbox" name="roleId"  title="${role.description}" value="${role.id}" checked >
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </form>
   </div>
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

<script src="${path}/static/aceadmin/assets/js/layui/layui.js"></script>
<script src="${path}/static/js/util.js"></script>
<script type="text/javascript">
    layui.use(['form','laydate'], function() {
        var form = layui.form;
        var $=layui.jquery
        ,laydate = layui.laydate;
      
        laydate.render({
            elem: '#birthday'
          });
        laydate.render({
            elem: '#enterDay'
          });
       
       
		
    });

</script>
</body>
</html>
