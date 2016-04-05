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
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 
  <body>
      <!-- 条件查询 -->
     <form action="CukuServlet.do" method="post">
     <input type="hidden" name="type2" value="query"/>
       <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
         <tr>
			<td >药品名称：<input type="text" name="dname"/>			
				<select name="cyear">
				  <option value=""></option>
				  <option value="2013">2013</option>
				  <option value="2014">2014</option>
				  <option value="2015">2015</option>
				</select>年
				<select name="cmouth">
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
				</select>			
				<select name="cday">
				   <option value=""></option>
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
				 <option value="23">23</option><option value="24">24</option>
				 <option value="24">25</option><option value="26">26</option>			 
				</select>		
			 <input type="submit" value="查询"/>
			 </td>
         </tr>
       </table>
         
     </form>
     <hr/>	
    <table border="1" width="100%"  align="center" cellspacing="0" cellpadding="0">
      <tr>
          <th>出库编号</th>
           <th>药品编号</th>
            <th>药名</th>
            <th>数量(盒)</th>
            <th>出货人</th>
            <th>日期</th>
      </tr>
      <c:forEach var="ckm" items="${requestScope.ckm}">
          <tr align="center">           
              <td>${ckm.cid}</td>   
              <td>${ckm.did}</td>
              <td>${ckm.dname}</td>
              <td>${ckm.cnumber}</td>
              <td>${ckm.uname}</td>    
              <td>${ckm.cyear}年${ckm.cmouth }${ckm.cday }</td>        
          </tr>
      </c:forEach>
    </table> 
    <p>
      <c:if test="${nowPage==1 }">
                 首页&nbsp;&nbsp;&nbsp;&nbsp;上一页
      </c:if>
      <c:if test="${nowPage>1 }">
      <a href="CukuServlet.do">首页</a>
      <a href="CukuServlet.do?page=${nowPage-1}">上一页</a>
      </c:if>
      <input type="text" value="${nowPage}" size=1 readonly="readonly"/>
      <c:if test="${nowPage<allPage}">
      <a href="CukuServlet.do?page=${nowPage+1 }">下一页</a>
      <a href="CukuServlet.do?page=${allPage}">尾页</a>
      </c:if>
      <c:if test="${nowPage==allPage}">
               下一页   尾页
      </c:if>
          第${nowPage}页     一共${allPage}页    每页${pageNumber}条记录  共${count}条记录
    </p>    
  </body>
</html>
