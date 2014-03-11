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
#t{
	width:inherit;
	height:inherit;
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
<h3>修改信息：</h3><br>
<form action=<%=path+"modifymemberinfo.action" %> method="post">
<table border="1" width="800" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th>识别码</th>
			<th>姓    名</th>
			<th>年    龄</th>
			<th>性    别</th>
			<th>住    址</th>
		</tr>
	<%
		for(int i=0; i<infos.length; i++) {
			String[] activityAttr = infos[i].split(",");
	%>
		<tr align="center">
			<td><%=activityAttr[0] %></td>
			<td><input type="text" value=<%=activityAttr[1] %> name="name" id="t"></td>
			<td><input type="text" value=<%=activityAttr[2] %> name="age" id="t"></td>
			<td><input type="text" value=<%=activityAttr[3] %> name="sex" id="t"></td>
			<td><input type="text" value=<%=activityAttr[4] %> name="address" id="t"></td>
		</tr>
	<%
		}	
	%>
	</table>
	<br>
	<input type="submit" value="确定">
</form>
</div>
</body>
</html>