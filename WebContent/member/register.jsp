<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
*{
	 margin:0px;
	 padding:0px;
}
#title{
	height:60px;
	width:300px;
	font-size:48px;
	font-family:Verdana, Arial, Helvetica, sans-serif;
	letter-spacing:30px;
	text-align:center;
	padding-left:40%;
	padding-top:5%
}
label{
	height:30px;
	width:130px;
	font-size:24px;
	line-height:30px;
	padding-right:10px;
}
input{
	padding-left:5px;
	font-size:16px;
	height:20px;
	width:150px;
}
#lll{
padding-right:58px;
}
#main{
	padding-top:5%;
	padding-left:21%;
}
#loginin_button{
	margin-left:50%;
	margin-top:30px;
	width:60px;
	height:30px;
}
select{
	font-size:16px;
	height:20px;
	width:160px;
}
#blank{
	padding-left:78px;
}
#loginin_button{
	margin-left:33%;
	margin-top:6%;
	width:80px;
	height:30px;
	font-size:24px;
}
</style>
<%
	String path = request.getContextPath();
	path+="/member/register.action";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Health Club</title>
</head>
<body>
	<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
		<img src="../back.jpg" height="100%" width="100%"/>    
	</div>  
	<div id="title" align="center">
	注册
	</div>
	<div id="main">
	<form action=<%=path %> method="post">
		<label id="lll">身份：</label> 
		<select id="select" name="member_type" onChange="show(this)">
			<option value="1">个人会员</option>
			<option value="2">家庭会员</option>
		</select>
		<div>
		<label id="lll">姓名：</label>
		<input type="text" name="member_name"> 
		<label>年龄：</label>
		<input type="text" name="member_age"> 
		<label>性别：</label>
		<select id="select_sex" name="member_sex">
			<option>男</option>
			<option>女</option>
		</select>
		</div>
		<script type="text/javascript">
			function show(obj) 
			{
				var  myselect=document.getElementById("select");
				var index = myselect.selectedIndex ;   
				var addhref = "<a id=\"add\" href=\"javascript:add_member()\">添加</a>";
				if(myselect.options[index].value == 2)
					document.getElementById("select_sex").insertAdjacentHTML("afterEnd", addhref); 
			}
			
			function add_member()
			{
				var new_member = "<div><label id=\"lll\">姓名：</label>"
		+"\n<input type=\"text\" name=\"member_name\">"
		+"\n<label>年龄：</label>"
		+"\n<input type=\"text\" name=\"member_age\">"
		+"\n<label>性别：</label>"
		+"\n<select name=\"member_sex\">"
		+"\n<option>男</option>"
		+"\n<option>女</option>"
		+"\n</select>"
		+"</div>";
				document.getElementById("home_address").insertAdjacentHTML("beforeBegin", new_member); 
			}
		</script>
		<div class="info">
			<div>
				<label id="home_address">家庭住址：</label>
				<select id="s_province" name="s_province"></select>
				<label id="blank"></label>
				<select id="s_city" name="s_city"></select>
				<label id="blank"></label>
				<select id="s_county" name="s_county"></select>
				<script type="text/javascript" src="area.js"></script>
				<script type="text/javascript">_init_area();</script>
			</div>
			<div id="show"></div>
		</div>
		<script type="text/javascript">
			var Gid = document.getElementById;
			var showArea = function() {
				Gid('show').innerHTML = "<h3>" + Gid('s_province').value
						+ " - " + Gid('s_city').value + " - "
						+ Gid('s_county').value + "</h3>"
			}
			Gid('s_county').setAttribute('onchange', 'showArea()');
		</script>
 		<label id="lll">密码：</label>
 		<input type="password" name="member_password1"> 
 		<br> 
 		<label id="llll">确认密码：</label>
 		<input type="password" name="member_password2"> 
 		<br> 
 		<input type="submit" id="loginin_button" value="注册">
 		<%
			String message=null;
			if((message=(String)request.getAttribute("message"))!=null)
				out.println(message);
		%>
	</form>
	</div>
</body>
</html>