<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
form {
	margin: 0px;
	display: inline;
}
#card{
	font-size:18px;
	height:20px;
	width:180px;
}
#blank{
	padding-top:5%;
}
#money{
	font-size:24px;
	font-weight:500;
}
#loginin_button{
	width:80px;
	height:30px;
	font-size:18px;
}
</style>
<%
	String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
		<img src="../snow.jpg" height="100%" width="100%"/>    
	</div>   
	<div id="blank"></div>
	<div align="center">
	<form action=<%=path + "/member/activation.action" %> method="post">
		您的识别码为：
		<h1>
		<%
			String id = (String) request.getAttribute("memberId");
			out.println(id);
			int pay = 0;
			if(id.charAt(0) == 's')
				pay = 75;
			else
				pay = 100;
		%>	
		</h1>
		<br>
		<label>请先付费激活会员资格，费用为：</label>
		<label id="money"><b><%=pay %>美元</b></label>
		<br><br><br>
		<label>请输入银行卡号：</label>
		<input type="text" name="cardID" id="card">
		<br><br><br>
		<input type="submit" id="loginin_button" value="支付">
	</form>
	</div>
</body>
</html>