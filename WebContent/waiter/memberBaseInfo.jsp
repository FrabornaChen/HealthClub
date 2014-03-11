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
	String info = (String)request.getAttribute("memberBaseInfo");
	String[] infos = info.split("&");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="blank"></div>
<div align="center">
<h3>基本信息：</h3><br>
<table border="1" width="800" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th>识别码</th>
			<th>姓    名</th>
			<th>年    龄</th>
			<th>性    别</th>
			<th>住    址</th>
			<th>状态</th>
		</tr>
	<%
		for(int i=0; i<infos.length; i++) {
			String[] activityAttr = infos[i].split(",");
	%>
		<tr align="center">
			<td><%=activityAttr[0] %></td>
			<td><%=activityAttr[1] %></td>
			<td><%=activityAttr[2] %></td>
			<td><%=activityAttr[3] %></td>
			<td><%=activityAttr[4] %></td>
			<td><%=activityAttr[5] %></td>
		</tr>
	<%
		}	
	%>
	</table>
</div>
</body>
</html>