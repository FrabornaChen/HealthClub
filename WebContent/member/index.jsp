<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
a:link{
	text-decoration:none;
}
*{
	 margin:0px;
	 padding:0px;
}
#title{
	height:60px;
	width:300px;
	font-size:48px;
	font-family:Verdana, Arial, Helvetica, sans-serif;
	text-align:center;
	padding-left:40%;
	padding-top:10%
}
#lr{
	height:60px;
	width:100%;
	font-size:48px;
	text-align:center;
	margin-right:5%;
	padding-top:10%;
}
#register{
	padding-left:10%;
}
</style>
<%
	String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
		<img src="../back.jpg" height="100%" width="100%"/>    
	</div>   
	<div id="title" align="center">
	Health Club
	</div>
	<div id="lr">
	<a href=<%=path+"/member/login.jsp" %>>登录</a>
	<a id="register" href=<%=path+"/member/register.jsp" %>>注册</a>
	</div>
</body>
</html>