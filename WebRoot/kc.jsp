<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="common.jsp"%>
<!-- 条件查询 -->
<div id="page-wrapper" class="gray-bg dashbard-1">
	<div class="content-main">

		<!--banner-->
		<!--//banner-->
		<!--faq-->
		<div class="blank">


			<div class="blank-page">
				<form action="KcServlet.do" method="post">
					<input type="hidden" name="type2" value="query" />
					<table width="100%" align="center" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td>药品名称:<input type="text" name="dname" />
							</td>
							<td><input type="submit" class="btn btn-info" value="查询" />
							</td>
						</tr>
					</table>

				</form>
				<hr />
				<table class="table table-border table-condensed table-hover ">
					<tr>
						<th>库存编号</th>
						<th>药品编号</th>
						<th>药品名称</th>
						<th>数量(盒)</th>

					</tr>
					<c:forEach var="kc" items="${requestScope.kc}">
						<tr>
							<td>${kc.kid}</td>
							<td>${kc.did}</td>
							<td>${kc.dname}</td>
							<td>${kc.knumber}</td>

						</tr>
					</c:forEach>
				</table>
				<!-- 分頁開始 -->
				<p style="text-align: right;">
					<c:if test="${nowPage==1 }">
                 首页&nbsp;&nbsp;&nbsp;&nbsp;上一页
      </c:if>
					<c:if test="${nowPage>1 }">
						<a href="KcServlet.do">首页</a>
						<a href="KcServlet.do?page=${nowPage-1}">上一页</a>
					</c:if>
					<input type="text" style="text-align: center;" value="${nowPage}"
						size=1 readonly="readonly" />
					<c:if test="${nowPage<allPage}">
						<a href="KcServlet.do?page=${nowPage+1 }">下一页</a>
						<a href="KcServlet.do?page=${allPage}">尾页</a>
					</c:if>
					<c:if test="${nowPage==allPage}">
               下一页   尾页
      </c:if>
					<b>${nowPage}</b>/${allPage}, 共<font color="orange">${count}</font>条记录
				</p>
				<!-- 分頁結束-->
			</div>
		</div>
		<!-- 分頁結束-->
		<!--//faq-->
		<%@ include file="footer.jsp"%>
		</body>
		</html>
		</body>
		</html>