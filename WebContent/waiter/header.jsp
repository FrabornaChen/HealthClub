<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
*{
	 margin:0px;
	 padding:0px;
}
form {
	margin: 0px;
	display: inline
}
input{
	font-size:18px;
	height:30px;
	width:140px;
	margin-bottom:10px;
}
#text{
	font-size:18px;
	height:30px;
	width:200px;
	margin-bottom:10px;
	padding-left:5px;
}
#submit{
	font-size:18px;
	height:30px;
	width:80px;
}
#main{
	padding-top:2%;
}
#blank{
	padding-top:4%;
}
#message{
	padding-top:5%;
}
</style>
<%
	String path = request.getContextPath();
	path += "/waiter/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
	<img src="../snow.jpg" height="100%" width="100%"/>    
</div> 
	<div align="center" id="main">
	<form action=<%= path + "getcids.action" %> method="post">
		<input type="submit" value="制定活动">
	</form>
	<form action=<%= path + "getaids.action" %> method="post">
		<input type="submit" value="记录卡号">
	</form>
	<form action=<%= path + "search.jsp" %>>
		<input type="submit" value="查询">
	</form>
	<form action="../member/index.jsp" method="post">
		<input type="submit" value="退出登录">
	</form>
	<br>
	</div>
</body>
</html>