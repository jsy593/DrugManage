<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>药品信息管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
body {
	background: #686868;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	margin: 0px;
	margin-bottom: 2px;
	border-bottom: 1px #ccc solid;
}

h1 {
	color: #FFF;
}

a {
	color: #FFF;
	text-decoration: none; /*防止滤镜下链接失效*/
	position: relative;
}

ul {
	list-style: none;
}

#all {
	width: 100%;
}

#banner {
	margin-top: 8px;
	margin-left: 32px;
}

#main {
	width: 100%;
	margin-bottom: 2px;
	background: #eeeeee;
	margin-left: 0px;
	margin-right: 0px;
	height: 30px;
	color: #000;
	line-height: 2.4;
	overflow: auto;
}

#main a {
	color: #000;
}

#welcome {
	float: left;
	width: 40%;
	font-weight: 800;
	padding-left: 8px;
	position: relative;
}

#adminop {
	float: left;
	width: 59%;
	position: relative;
	text-align: right;
	line-height: 1; *
	line-height: 2.2;
}

#adminop ul li {
	float: right;
	width: 80px;
}

#sp {
	float: left;
	font-weight: 800;
	padding-left: 8px;
}

</style>
		<script type="text/javascript" language="javascript"
			src="js/jquery-1.3.2.min.js">
</script>
		<SCRIPT src="js/Clock.js" type="text/javascript" language="javascript"></SCRIPT>
		<script type="text/javascript">
var oplist = new Array('about', 'user', 'news', 'mars', 'jielong', 'box',
		'school', 'config', 'other');
$(document).ready(function() {
	$('#nav').find("a").click(function() {
		var id = $(this).attr('id');
		$.each(oplist, function(i, n) {
			$('#' + n).attr('class', 'inactive');
		});
		$(this).parents("li").attr('class', 'active');
	});
});
</script>
	</head>
	<body>
		<div id="all">
			<div id="banner">
				<h1>
					药品后台管理登录
				</h1>
			</div>
			<div id="main">
				<div id="welcome">
					<div id="sp">
						欢迎${sessionScope.user.username}回来
						<img src="images/clock.gif" />
						<span id="clock"></span>
					</div>
				</div>
				<div id="adminop">
					<ul>
						<li><a href="login.jsp" target="_parent">退出登录</a></li>
					</ul>
				</div>
			</div>
		</div>
		<script type="text/javascript">
              var clock = new Clock();
             clock.display(document.getElementById("clock"));
        </script>
	</body>
</html>
