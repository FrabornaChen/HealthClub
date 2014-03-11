<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#text{
	font-size:18px;
	height:25px;
	width:200px;
	margin-bottom:10px;
	padding-left:5px;
}
select{
	font-size:18px;
	height:25px;
	width:200px;
	margin-bottom:10px;
	padding-left:5px;
}
#submit{
	font-size:18px;
	height:30px;
	width:80px;
}
</style>
<%
	String aids = (String)request.getAttribute("aids");	
	String[] aid = aids.split(",");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="blank"></div>
<div align="center">
<form action=<%=path + "recordmid.action"%> method="post">
	<label>活动：</label> 
	<select name="select">
		<%
			for(int i=0;i<aid.length;i++) {
		%>
			<option><%=aid[i] %></option>
		<%
			}
		%>
	</select>
	<br> 
	<label>卡号：</label> 
	<input type="text" name="mid" id="text">
	<br><br>
	<input type="submit" value="记录" width="60px" height="30px" id="submit">
</form>
</div>
</body>
</html>