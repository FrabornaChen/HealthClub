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
#main{
	padding-top:2%;
}
#blank{
	padding-top:2%;
}
#message{
	padding-top:5%;
}
</style>
<%
	String path = request.getContextPath();
	path += "/manager/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
	<img src="../snow.jpg" height="100%" width="100%"/>    
</div> 
	<div align="center" id="main">
	会员统计：
	<form action=<%=path + "byage.action"%> method="post">
		<input type="submit" value="年龄">
	</form>
	<form action=<%=path + "bysex.action"%> method="post">
		<input type="submit" value="性别">
	</form>
	<form action=<%=path + "bystatus.action"%> method="post">
		<input type="submit" value="会员状态">
	</form>
	<form action=<%=path + "byaddress.action"%> method="post">
		<input type="submit" value="居住地址">
	</form>
	<br> 使用情况：
	<form action=<%=path + "aboutfield.action"%> method="post">
		<input type="submit" value="场地">
	</form>
	<form action=<%=path + "aboutcoach.action"%> method="post">
		<input type="submit" value="教练">
	</form>
	<form action=<%=path + "dayloginnum.action"%> method="post">
		<input type="submit" value="日总人数">
	</form>
	<form action=<%=path + "monthloginnum.action"%> method="post">
		<input type="submit" value="月总人数">
	</form>
	<br><br>
	<div id="message"><h2>
	<%
		String message = null;
		if ((message = (String) request.getAttribute("login_num")) != null)
			out.println(message);
	%>
	</h2>
	</div>
	</div>
</body>
</html>