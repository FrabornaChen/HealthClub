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
	String bystatus = request.getAttribute("bystatus").toString();
	String[] statusnum = bystatus.split(",");
	String[] rowname = { "未激活", "正常", "暂停", "停止", "取消" };
	int totalNum = Integer.parseInt(statusnum[0])
			+ Integer.parseInt(statusnum[1])
			+ Integer.parseInt(statusnum[2])
			+ Integer.parseInt(statusnum[3])
			+ Integer.parseInt(statusnum[4]);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="blank"></div>
	<div align="center">
	<h3>状态统计情况</h3>
	<br><br>
	<table border="1" width="800" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th>状态</th>
			<th>人数</th>
			<th>百分比</th>
		</tr>
		<%
			if (statusnum.length > 0) {
				for (int i = 0; i < statusnum.length; i++) {
		%>
		<tr align="center">
			<td><%=rowname[i]%></td>
			<td><%=statusnum[i]%></td>
			<td><%=Math.round((Double.parseDouble(statusnum[i]) / totalNum) * 100)%>%</td>
		</tr>
		<%
			}
			}
		%>
	</table>
	</div>
</body>
</html>