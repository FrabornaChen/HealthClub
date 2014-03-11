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
#submit{
	font-size:18px;
	height:30px;
	width:180px;
}
#plain{
	font-size:18px;
	height:30px;
	width:200px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
<div id="blank"></div>
<div align="center">
<input type="text" id="plain">
<br><br>
<form action=<%=path + "userinfo.action"%> method="post">
	<input type="hidden" name="hidden" id="hidden">
	<input type="submit" onclick="setvalue(this)" value="查询会员注册信息" id="submit">
</form>
<br>
<form action=<%=path + "useractinfo.action"%> method="post">
	<input type="hidden" name="hidden" id="hidden">
	<input type="submit" onclick="setvalue(this)" value="查询会员活动记录" id="submit">
</form>
<br>
<form action=<%=path + "userpayinfo.action"%> method="post">
	<input type="hidden" name="hidden" id="hidden">
	<input type="submit" onclick="setvalue(this)" value="查询会员缴费记录" id="submit">
</form>
</div>
<script type="text/javascript">
	function setvalue(obj) {
		var v = document.getElementsByName("hidden");
		var va = document.getElementById("plain").value;
		for(var i=0 ; i<v.length ; i++) {
			v[i].value = va;
		}
	}
</script>
</body>
</html>