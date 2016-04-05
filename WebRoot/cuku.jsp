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
	<script type="text/javascript">
      
	</script>
  </head>
 <body>
 <form action="CKServlet.do" method="post">
   <table width="400" height="400" border="0" cellpadding="0" cellspacing="0">
  <c:forEach var="ck" items="${requestScope.ck}"> 
  <tr>
    <td width="30%" align="center">药品编码：</td>
    <td width="70%"><input type="text" name="did" value="${ck.did}"  readonly="readonly"/></td>
  </tr>
  <tr>
    <td width="30%" align="center">药品名称：</td>
    <td width="70%"><input type="text" name="dname" value="${ck.dname}" readonly="readonly"/></td>
  </tr>
   <tr>
    <td width="20%"  align="center">数量：</td>
    <td width="80%"><input type="text" name="cnumber" id="rumber" value="${ck.knumber}" size="5"/>盒</td>
  </tr>
   <tr>
    <td width="20%" align="center">年份:</td>
    <td width="80%"><select name="cyear">
				  <option value=""></option>
				  <option value="2013">2013</option>
				  <option value="2014">2014</option>
				  <option value="2015">2015</option>
				</select>年</td>
  </tr>
   <tr>
    <td width="20%" align="center">月份：</td>
    <td width="80%"><select name="cmouth">
				   <option value=""></option>
				  <option value="一月">一月</option>
				 <option value="二月">二月</option>
				 <option value="三月">三月</option>
				 <option value="四月">四月</option>
				 <option value="五月">五月</option>
				 <option value="六月">六月</option>
				 <option value="七月">七月</option>
				 <option value="八月">八月</option>
				 <option value="九月">九月</option>
				 <option value="十月">十月</option>
				 <option value="十一月">十一月</option>
				 <option value="十二月">十二月</option>				 
				</select></td>
  </tr>
   <tr>
    <td width="20%" align="center">日:</td>
    <td width="80%">
       <select name="cday">
        <option value="01">01</option><option value="02">02</option>
        <option value="03">03</option><option value="04">04</option>
        <option value="05">05</option><option value="06">06</option>
        <option value="07">07</option><option value="08">08</option>
        <option value="09">09</option><option value="10">10</option>
        <option value="11">11</option><option value="12">12</option>
        <option value="13">13</option><option value="14">14</option>
        <option value="15">15</option><option value="16">16</option>
        <option value="17">17</option><option value="18">18</option>
        <option value="19">19</option><option value="20">20</option>
        <option value="21">21</option><option value="22">22</option>
        
      </select>
    </td>
  </tr>
   <tr>
    <td width="20%" align="center">出库人:</td>
    <td width="80%">
      <select name="uname">
				   <option value=""></option>
				  <option value="admin">admin</option>
				 <option value="wang">wang</option>
	  </select>
    </td>
  </tr>
    <tr>
    <td width="20%"></td>
    <td width="80%">
    <input type="submit" onclick="add()" value="确认出库"/>
    <input type="reset" value="重新输入"/></td>
  </tr>
 </c:forEach>
</table>
</form>
 </body>
</html>
