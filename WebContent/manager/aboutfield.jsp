<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
form {
	margin: 0px;
	display: inline
}
</style>
<%
	String fieldInfo = request.getAttribute("fieldInfo").toString();
System.out.println(fieldInfo);
	String[] fields = fieldInfo.split("\\$");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="blank"></div>
	<div align="center">
	<h3>场地统计情况</h3>
	<br><br>
	<table border="1" width="800" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th>场地</th>
			<th>时间</th>
			<th>教练</th>
		</tr>
		<%
			if (fields.length > 0) {
				for (int i = 0; i < fields.length; i++) {
					String[] fieldAct = fields[i].split("\\?");
					String[] activities = fieldAct[1].split("\\&");
		%>
		<tr align="center">
			<td><%=fieldAct[0]%></td>
			<td><%=activities[0].split("\\*")[2]%></td>
			<td><%=activities[0].split("\\*")[3]%></td>
		</tr>
		<%
					for (int j = 1; j < activities.length; j++) {
		%>
		<tr align="center">
			<td></td>
			<td><%=activities[j].split("\\*")[2]%></td>
			<td><%=activities[j].split("\\*")[3]%></td>
		</tr>
		<%
					}
				}
			}
		%>
	</table>
	</div>
</body>
</html>