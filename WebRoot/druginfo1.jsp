<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

  </head>
 <body>
 <form action="AddServlet.do?method=update1" method="post">
   <table width="400" height="400" border="0" cellpadding="0" cellspacing="0">
   <c:forEach var="dr" items="${requestScope.dr}">
  <tr>
    <td width="30%" align="center">药品编号：</td>
    <td width="70%"><input type="text" name="did" readonly="readonly"  value="${dr.did }"/></td>
  </tr>
  <tr>
    <td width="30%" align="center">药品名称：</td>
    <td width="70%"><input type="text" name="dname" value="${dr.dname }"/></td>
  </tr>
   <tr>
    <td width="20%"  align="center">规格：</td>
    <td width="80%"><input type="text" name="guige" value="${dr.guige }"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">价格:</td>
    <td width="80%"><input type="text" name="price" value="${dr.price }"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">功效:</td>
    <td width="80%"><input type="text" name="effect" value="${dr.effect }"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">药品类型:</td>
    <td width="80%"><input type="text" name="type" readonly="readonly" value="${dr.type }"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">生产厂家:</td>
    <td width="80%"><input type="text" name="factory" disabled="disabled" value="${dr.factory }"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">生产日期:</td>
    <td width="80%"><input type="text"name="date" disabled="disabled" value="${dr.date }"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">有效期:</td>
    <td width="80%"><input type="text" name="indate" disabled="disabled" value="${dr.indate }"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">批准文号:</td>
    <td width="80%"><input type="text" name="anumber" disabled="disabled" value="${dr.anumber }"/></td>
  </tr>
    <tr>
    <td width="20%"></td>
    <td width="80%">
    <input type="submit" value="确认修改"/>
    <input type="reset" value="重新输入"/></td>
  </tr>
  <tr><td>${success}</td></tr>
 </c:forEach>
</table>
</form>
 </body>
</html>
