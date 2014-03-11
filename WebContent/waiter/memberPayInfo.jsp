<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#blank{
	padding-top:5%;
}
</style>
<%
	String payRecords = (String)request.getAttribute("payRecord");
	String[] payRecord = payRecords.split("\\$");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
	<div id="blank"></div>
	<div align="center">
	<h3>缴费记录：</h3><br>
	<table border="1" width="800" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th>日期</th>
			<th>金额（$）</th>
		</tr>
	<%
		if((!payRecords.equals("")) && payRecord.length>0){
			for(int i=0; i<payRecord.length; i++) {
				String[] payAttr = payRecord[i].split("\\*");
	%>
		<tr align="center">
			<td><%=payAttr[0] %></td>
			<td><%=payAttr[1] %></td>
		</tr>
	<%
			}
		}	
	%>
	</table>
	</div>
</body>
</html>