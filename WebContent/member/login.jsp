<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
select{
	width:149px;
}
*{
	 margin:0px;
	 padding:0px;
}
#loginin_button{
	margin-top:30px;
	height:30px;
	width:60px;
}
#title{
	height:60px;
	width:300px;
	font-size:48px;
	font-family:Verdana, Arial, Helvetica, sans-serif;
	letter-spacing:30px;
	text-align:center;
	padding-left:40%;
	padding-top:10%
}
label{
	height:30px;
	width:60px;
	font-size:24px;
	line-height:30px;
	padding-right:30px;
}
#main{
	padding-top:5%;
	padding-left:38%;
}
#identity{
	font-size:24px;
	height:30px;
	width:200px;
}
#input{
	padding-left:5px;
	font-size:16px;
	height:20px;
	width:200px;
}
#loginin_button{
	margin-left:15%;
	margin-top:5%;
	width:80px;
	height:30px;
	font-size:24px;
}
#message{
	padding-left:9%;
}
</style>
<%
	String path = request.getContextPath();
	path+="/member/login.action";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
		<img src="../back.jpg" height="100%" width="100%"/>    
	</div>   
	<div id="title" align="center">
	登录
	</div>
	<div id="main">
	<form action=<%=path %> method="post">
		<label>身份:</label>
		<select name="identity" id="identity" size="1"> 
			<option id="member" selected="selected">会员 </option>
			<option id="waiter">服务员</option>
			<option id="manager">经理</option>
 		</select>
		<br>
		<label>卡号:</label><input type="text" name="id" id="input">
		<br>
		<label>密码:</label><input type="password" name="password" id="input">
		<br>
		<input type="submit" id="loginin_button" value="登录" border="">
		<br><br>
		<div id="message">
		<%
			String message=null;
			if((message=(String)request.getAttribute("message"))!=null)
				out.println(message);
		%>
		</div>
	</form>
	</div>
</body>
</html>