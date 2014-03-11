<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	path+="/member/";
%>
<style type="text/css">
*{
	 margin:0px;
	 padding:0px;
}
form {
	margin: 0px;
	display: inline;
}
input{
	font-size:18px;
	height:30px;
	width:140px;
}
#main{
	padding-top:2%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
	<img src="../snow.jpg" height="100%" width="100%"/>    
</div>   
<div align="center" id="main">
<form action=<%=path+"geticnum.action" %> method="post">
	<input type="submit" value="会员充值">
</form>
<form action=<%=path+"getactivities.action" %> method="post">
	<input type="submit" value="预订活动">
</form>
<form action=<%=path+"getmemberinfo.action" %> method="post">
	<input type="submit" value="查询注册信息">
</form>
<form action=<%=path+"altermemberinfo.action" %> method="post">
	<input type="submit" value="修改注册信息">
</form>
</div>
<br>
<br>
<div align="center">
<form action=<%=path+"getactivityrecord.action" %> method="post">
	<input type="submit" value="查询活动记录">
</form>
<form action=<%=path+"getpayrecord.action" %> method="post">
	<input type="submit" value="查询缴费记录">
</form>
<form action=<%=path+"disqualification.jsp" %> method="post">
	<input type="submit" value="注销会员资格">
</form>
<form action="index.jsp" method="post">
	<input type="submit" value="退出登录">
</form>
</div>
</body>
</html>