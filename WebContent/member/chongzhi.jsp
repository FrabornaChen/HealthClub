<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="homepage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#blank{
	padding-top:5%;
}
#paypay{
	font-size:18px;
	height:30px;
	width:80px;
}
</style>
<%
	double pay = 0;
	if(request.getAttribute("icnum")!=null)
	   pay = Double.valueOf(request.getAttribute("icnum").toString());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
	<div id="blank"></div>
	<div align="center">
	<%
		if(pay<0){
	%>
	您的余额已不足，请充值！
	<%
		} else {
	%>
	您的会费余额为：<b><%=pay %>美元</b>
	<%
		}
	%>
	<br><br>
	请输入充值金额：
	<form action=<%=path + "pay.action"%> method="post">
		<input type="text" name="chongzhi">
		<br><br>
		<input type="submit" id="paypay" value="充值">
	</form>
	</div>
</body>
</html>