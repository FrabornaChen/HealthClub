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
		充值成功，账户余额为：<h2><%=pay %>美元</h2>
	</div>
</body>
</html>