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
	String byage = request.getAttribute("bysex").toString();
	String[] sexnum = byage.split(",");
	String[] rowname = { "男", "女" };
	int totalNum = Integer.parseInt(sexnum[0])
			+ Integer.parseInt(sexnum[1]);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="blank"></div>
	<div align="center">
	<h3>性别统计情况</h3>
	<br><br>
	<table border="1" width="800" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th>性别</th>
			<th>人数</th>
			<th>百分比</th>
		</tr>
		<%
			if (sexnum.length > 0) {
				for (int i = 0; i < sexnum.length; i++) {
		%>
		<tr align="center">
			<td><%=rowname[i]%></td>
			<td><%=sexnum[i]%></td>
			<td><%=Math.round((Double.parseDouble(sexnum[i]) / totalNum) * 100)%>%</td>
		</tr>
		<%
			}
			}
		%>
	</table>
	</div>
</body>
</html>