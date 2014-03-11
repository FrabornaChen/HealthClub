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
	String byaddress = request.getAttribute("byaddress").toString();
	String[] addressnum = byaddress.split(",");
	String[] rowname = { "北京市", "天津市", "上海市", "重庆市", "河北省", "山西省",
			"内蒙古", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省",
			"江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "广西", "海南省",
			"四川省", "贵州省", "云南省", "西藏", "陕西省", "甘肃省", "青海省", "宁夏", "新疆",
			"香港", "澳门", "台湾省" };
	int totalnum = 0;
	for (int i = 0; i < addressnum.length; i++) {
		totalnum += Integer.parseInt(addressnum[i]);
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="blank"></div>
	<div align="center">
	
	<table border="1" width="800" cellpadding="0" cellspacing="0">
		<tr align="center">
			<th>省份</th>
			<th>人数</th>
			<th>百分比</th>
		</tr>
		<%
			if (addressnum.length > 0) {
				for (int i = 0; i < addressnum.length; i++) {
		%>
		<tr align="center">
			<td><%=rowname[i]%></td>
			<td><%=addressnum[i]%></td>
			<td><%=Math.round((Double.parseDouble(addressnum[i]) / totalnum) * 100)%>%</td>
		</tr>
		<%
			}
			}
		%>
	</table>
	</div>
</body>
</html>