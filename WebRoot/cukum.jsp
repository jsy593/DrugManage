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
				<form action="CukuServlet.do" method="post">
					<input type="hidden" name="type2" value="query" />
					<table width="100%" align="center" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td>药品名称:<input type="text" name="dname" />
							</td>
							<td>日期: <select name="cyear">
									<option value=""></option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2015">2016</option>
									<option value="2015">2017</option>
									<option value="2015">2018</option>
									<option value="2015">2019</option>
									<option value="2015">2020</option>
							</select> <select name="cmouth">
									<option value=""></option>
									<option value="1月">01</option>
									<option value="2月">02</option>
									<option value="3月">03</option>
									<option value="4月">04</option>
									<option value="5月">05</option>
									<option value="6月">06</option>
									<option value="7月">07</option>
									<option value="8月">08</option>
									<option value="9月">09</option>
									<option value="10月">10</option>
									<option value="11月">11</option>
									<option value="12月">12</option>
							</select> <select name="cday">
									<option value=""></option>
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="24">25</option>
									<option value="26">26</option>
									<option value="24">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="27">29</option>
									<option value="28">30</option>
									<option value="28">31</option>
							</select>
							</td>
							<td><input type="submit" class="btn btn-info" value="查询" />
							</td>
						</tr>
					</table>

				</form>
				<hr />
				<table class="table table-border table-condensed table-hover ">
					<tr>
						<th>出库编号</th>
						<th>药品编号</th>
						<th>药名</th>
						<th>数量(盒)</th>
						<th>出货人</th>
						<th>日期</th>
					</tr>
					<c:forEach var="ckm" items="${requestScope.ckm}">
						<tr>
							<td>${ckm.cid}</td>
							<td>${ckm.did}</td>
							<td>${ckm.dname}</td>
							<td>${ckm.cnumber}</td>
							<td>${ckm.uname}</td>
							<td>${ckm.cyear}年${ckm.cmouth }${ckm.cday }</td>
						</tr>
					</c:forEach>
				</table>
				<!-- 分頁開始 -->
				<p style="text-align: right;">
					<c:if test="${nowPage==1 }">
                 首页&nbsp;&nbsp;&nbsp;&nbsp;上一页
      </c:if>
					<c:if test="${nowPage>1 }">
						<a href="CukuServlet.do">首页</a>
						<a href="CukuServlet.do?page=${nowPage-1}">上一页</a>
					</c:if>
					<input type="text" style="text-align: center;" value="${nowPage}"
						size=1 readonly="readonly" />
					<c:if test="${nowPage<allPage}">
						<a href="CukuServlet.do?page=${nowPage+1 }">下一页</a>
						<a href="CukuServlet.do?page=${allPage}">尾页</a>
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