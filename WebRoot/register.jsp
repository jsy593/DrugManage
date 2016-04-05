<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="images/res.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery.min.js"></script>
	<script src="layer/layer.js"></script>
  <script type="text/javascript">
      function  checkPs(obj){
	     var  ps = obj.value;
		 var  flag;
		 if(ps.length<6 && !isNaN(ps)){
		    flag = 0;
		 }else if(ps.length>=6 && !isNaN(ps)){
		    flag = 1;
		 }else if(ps.length>=6 && ps.length<=12 && isNaN(ps)){
		    flag = 2;
		 }else{
		     layer.alert("密码不合法！",{icon:5});
			 return;
		 }
		 //判断 flag的值
		 switch(flag){
		    case 0:
			  test();
			  
			  document.getElementById("one").style.backgroundColor="blue";
			  break;
			case 1:
			  test();
			  
			  document.getElementById("one").style.backgroundColor="red";
			  document.getElementById("two").style.backgroundColor="red";
			  break;
			case 2:
			  test();
			   document.getElementById("one").style.backgroundColor="green";
			   document.getElementById("two").style.backgroundColor="green";
			   document.getElementById("three").style.backgroundColor="green";
			   
		 }
	 
	
	 
	 function   test(){
	 
	          document.getElementById("one").style.backgroundColor="#CCCCCC";
			  document.getElementById("two").style.backgroundColor="#CCCCCC";
			  document.getElementById("three").style.backgroundColor="#CCCCCC";
	 }

   }
    function check(){
	   var ps1=document.getElementById("password");
	   var ps2=document.getElementById("password1");
	   if(ps1.value!=ps2.value){
	      layer.alert("输入不一致",{icon:5});
		  return;
	   }
	}
</script>
<style type="text/css">
   .styleSpan{background-color:#CCCCCC}
</style>
</head>

<body>
		<div id="3" style="position: relative; top: 20px; z-index: 3;">
			<form id="f1" action="RegisterServlet.do" method="post">
				<table align="center" cellspacing="0" class="table">
					<tr class="thead">
						<td align="center">
							会员注册
						</td>
					</tr>
					<tr>
						<td>
							<table id="registertable" border="0px" align="center"
								cellspacing="0" cellpadding="5px">
								<tr>
									<tr>
										<td align="right">
											员工编号：
										</td>
										<td align="left">
											<input type="text" name="username" placeholder="用户名" required />
										</td>
									</tr>
									<tr>
										<td align="right">
											密 码：
										</td>
										<td align="left">
											<input type="text" name="password" id="password"
												placeholder="密码" onblur="checkPs(this)" />
											<span id="one" class="styleSpan">&nbsp;弱&nbsp;</span>
                                            <span id="two" class="styleSpan">&nbsp;中&nbsp;</span>
                                            <span id="three" class="styleSpan">&nbsp;强&nbsp;</span>
										</td>
									</tr>
									<tr>
										<td align="right">
											密码确认：
										</td>
										<td align="left">
											<input type="text" name="password2" id="password1" placeholder="确认密码"
												required   onblur="check()"/>
										</td>
									</tr>
									
									<tr>
										<td align="right">
											性 别：
										</td>
										<td align="left">
											<input type="radio" name="sex" value="男" checked />
											男
											<input type="radio" name="sex" value="女" />
											女
										</td>
									</tr>
									<tr>
										<td align="right">
											邮 箱：
										</td>
										<td align="left">
											<input type="email" name="email" placeholder="邮箱" id="email"
												required />
										</td>
									</tr>
									<tr>
										<td align="right">
											手 机：
										</td>
										<td align="left">
											<input type="tel" pattern="[0-9]{11}" id="p" name="phone"
												placeholder="请输入11位数字" />
										</td>
									</tr>
									

									<tr height="60px">
										<td align="center" colspan="2">
											<input type="button" value="转到登录"
												onclick="window.location.replace('login.jsp')"
												class="submit" />
											<input type="submit" accesskey="enter" value="注册"
												class="submit" formmethod="post" />
										</td>
									</tr>
							</table>
						</td>
					</tr>
				</table>
		</form>
		</div>	
	</body>
	
</html>
