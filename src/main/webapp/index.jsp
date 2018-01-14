<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/login/login!login" method="post" id="login">
	用户名：<input type="text" name="user.username"><br>
	密码：<input type="password" name="user.password"><br>
	<input type="button" value="提交" id="btn">
</form>
<script type="text/javascript" src="/static/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btn').click(function(){
		 $.ajax({
			url:$('#login').attr('action'),
			data:$('#login').serialize(),
			type:'post',
			dataType:'json',
			success:function(data){
				data=eval('('+data+')');
				console.log(data.message);
			}
		}) 
		})
	})
</script>
</body>
</html>