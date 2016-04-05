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
	
	<link href="images/login.css" rel="stylesheet" type="text/css" />
   <script type="text/javascript"> 
	
	     function    newCode(){
	    	 var  today = new  Date();
	    	 document.getElementById("imgNumber").src="validateNumber.jpg?tm="+today.getTime();
	    	 
	     }
  </script>

  </head>

	<body>
		<div id="login">

			<div id="top">
				<div id="top_left">
					<img src="images/login_03.gif" />
				</div>
				<div id="top_center"></div>
			</div>

			<div id="center">
				<div id="center_left"></div>
				<div id="center_middle">
					<form action="LoginServlet.do" method="post">
						<div id="user">
							用&nbsp;&nbsp;户
							<input type="text" name="username" value="${error} " />
						</div>
						<div id="password">
							密&nbsp;&nbsp;码
							<input type="password" name="password" />
						</div>
						<div id="va">
							验证码
							<input type="text" name="number" value="${error1}" />
							<img src="validateNumber.jpg" id="imgNumber"
								onclick="newCode()" />

						</div>
						<div id="btn">
						
							<input type="submit" value="登录">
							<input type="reset" value="重置" />
						</div>
					</form>
					<div id="re">
						<a href="register.jsp">注册新用户</a>
					</div>
				</div>

				<div id="center_right"></div>
			</div>
			<div id="down">
				<div id="down_left">
					<div id="inf">
						<span class="inf_text">版本信息</span>
						<span class="copyright">药店管理信息系统 2015 v1.0</span>
					</div>
				</div>
				<div id="down_center"></div>
			</div>

		</div>
	</body>
</html>
