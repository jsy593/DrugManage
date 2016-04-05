<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="common.jsp" %>
      <!-- 条件查询 -->
      <div id="page-wrapper" class="gray-bg dashbard-1">
       <div class="content-main">
 
 	<!--banner-->	
		<!--//banner-->
 	 <!--faq-->
 	<div class="blank">
	

			<div class="blank-page">
			
     <form  action="HomeServlet.do" method="post">
     <input type="hidden" name="type1" value="query"/>
       <table  width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td align="right">名称：</td>
			<td ><input type="text" class="form-control-static" height="34px" name="dname" value="${dq.dname  }"/></td>
		    <td align="right">价格：</td>
			<td ><input type="text" class="form-control-static" name="price1"/>--
			<input type="text" class="form-control-static" name="price2"/>元</td>
			
			<td >类型：</td>
			<td>
				<select name="type" class="form-control">
				   <option value=""></option>
				  <option value="OTC">OTC</option>
				  <option value="处方药">处方药</option>
				</select>
			</td>
			
			<td width="2%"> <input type="submit" class="btn btn-info" value="查询"/> </td>
         </tr>
       </table>  
     </form>
     <hr/>	
    <table class="table table-border table-condensed table-hover ">
      <tr>
         <th>编号</th>
          <th>药名</th>
            <th>规格</th>
            <th>价格(元)</th>
            <th>功效</th>
            <th>药品类型</th>
            <th>生产厂家</th>
            <th>生产日期</th>
            <th>有效期</th>
            <th>批准文号</th>
            <th>操作</th>
      </tr>
      <c:forEach var="drug" items="${requestScope.druginfo}">
          <tr align="center">           
              <td>${drug.did}</td>   
              <td>${drug.dname}</td>
              <td>${drug.guige}</td>
              <td>${drug.price}</td>
              <td>${drug.effect}</td>
              <td>${drug.type}</td>
              <td>${drug.factory}</td>
              <td>${drug.date}</td>
              <td>${drug.indate}</td>
              <td>${drug.anumber}</td>
              <td>
                <a href="AddServlet.do?method=update&did=${drug.did}" style="color:orange"><b>修改</b></a>
                <a href="AddServlet.do?method=delete&did=${drug.did}" style="color:gary"><b>删除</b></a>
              </td>
          </tr>
      </c:forEach>
    </table> 
    <p style="text-align: right;">
      <c:if test="${nowPage==1 }">
                 首页&nbsp;&nbsp;&nbsp;&nbsp;上一页
      </c:if>
      <c:if test="${nowPage>1 }">
      <a href="HomeServlet.do">首页</a>
      <a href="HomeServlet.do?page=${nowPage-1}">上一页</a>
      </c:if>
      <input type="text" style="text-align: center;" value="${nowPage}" size=1 readonly="readonly"/>
      <c:if test="${nowPage<allPage}">
      <a href="HomeServlet.do?page=${nowPage+1 }">下一页</a>
      <a href="HomeServlet.do?page=${allPage}">尾页</a>
      </c:if>
      <c:if test="${nowPage==allPage}">
               下一页   尾页
      </c:if>
          ${nowPage}/${allPage}, 共${count}条记录
    </p>    
    </div>
   </div>
	
	<!--//faq-->
	<%@ include file="footer.jsp" %>
