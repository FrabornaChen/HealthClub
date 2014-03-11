<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
form {
	margin: 0px;
	display: inline;
}
</style>
<%
	String path = request.getContextPath();
	path+="/member/login.jsp";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
		<img src="../snow.jpg" height="100%" width="100%"/>    
	</div>  
	<div align="center">
	<label>您的会员资格已激活</label>
	<br>
	<a href=<%=path %>>点击登录</a>
	</div>
</body>
</html>