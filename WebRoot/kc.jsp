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
     <form action="KcServlet.do" method="post">
     <input type="hidden" name="type2" value="query"/>
       <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
         <tr>
			<td >药品名称：<input type="text" name="dname"/>					
			 <input type="submit" value="查询"/>
			 </td>
         </tr>
       </table>
         
     </form>
     <hr/>	
    <table border="1" width="100%"  align="center" cellspacing="0" cellpadding="0">
      <tr>
          <th>库存编号</th>
           <th>药品编号</th>
            <th>药品名称</th>
            <th>数量(盒)</th>    
            
      </tr>
      <c:forEach var="kc" items="${requestScope.kc}">
          <tr align="center">           
              <td>${kc.kid}</td>   
              <td>${kc.did}</td>
              <td>${kc.dname}</td>
              <td>${kc.knumber}</td>
                  
          </tr>
      </c:forEach>
    </table> 
    <p>
      <c:if test="${nowPage==1 }">
                 首页&nbsp;&nbsp;&nbsp;&nbsp;上一页
      </c:if>
      <c:if test="${nowPage>1 }">
      <a href="KcServlet.do">首页</a>
      <a href="KcServlet.do?page=${nowPage-1}">上一页</a>
      </c:if>
      <input type="text" value="${nowPage}" size=1 readonly="readonly"/>
      <c:if test="${nowPage<allPage}">
      <a href="KcServlet.do?page=${nowPage+1 }">下一页</a>
      <a href="KcServlet.do?page=${allPage}">尾页</a>
      </c:if>
      <c:if test="${nowPage==allPage}">
               下一页   尾页
      </c:if>
          第${nowPage}页     一共${allPage}页    每页${pageNumber}条记录  共${count}条记录
    </p>    
  </body>
</html>
