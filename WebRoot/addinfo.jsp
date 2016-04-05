<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="common.jsp" %>
 <div id="page-wrapper" class="gray-bg dashbard-1">
       <div class="content-main">
 
 	<!--banner-->	
		<!--//banner-->
 	 <!--faq-->
 	<div class="blank">
	

			<div class="blank-page">
<div class="grid-form1">		
 <form  class="form-horizontal" action="AddServlet.do?method=add" name="form1" method="post" onsubmit="return add()">
   <table width="400" height="400" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30%" align="center">药品名称：</td>
    <td width="70%"><input type="text" style="margin:10px 0px" class="form-control-static" name="dname"/><span id="dname">必填</span></td>
  </tr>
   <tr>
    <td width="20%"  align="center">规格：</td>
    <td width="80%"><input type="text" style="margin:10px 0px" class="form-control-static" name="guige"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">价格:</td>
    <td width="80%"><input type="text" style="margin:10px 0px" class="form-control-static" name="price"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">功效:</td>
    <td width="80%"><input type="text" style="margin:10px 0px" class="form-control-static" name="effect"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">药品类型:</td>
    <td width="80%"><input type="text" style="margin:10px 0px" class="form-control-static" name="type"/></td>
  </tr>
   <tr>
    <td width="20%" align="center">生产厂家:</td>
    <td width="80%"><input type="text" style="margin:10px 0px" class="form-control-static" name="factory"/><span id="factory">必填</span></td>
  </tr>
   <tr>
    <td width="20%" align="center">生产日期:</td>
    <td width="80%"><input type="text" style="margin:10px 0px" class="form-control-static" name="date"/><span id="date">必填</span></td>
  </tr>
   <tr>
    <td width="20%" align="center">有效期:</td>
    <td width="80%"><input type="text" onclick="laydate()" style="margin:10px 0px" class="form-control-static" name="indate"/><span id="indate">必填</span></td>
  </tr>
   <tr>
    <td width="20%" align="center">批准文号:</td>
    <td width="80%"><input type="text" style="margin:10px 0px" class="form-control-static" name="anumber"/><span id="anumber">必填</span></td>
  </tr>
    <tr>
    <td width="20%"></td>
    <td width="80%">
    <div class="col-md-6 login-do">
		<label class="hvr-shutter-in-horizontal login-sub">
    		<input type="submit" class="hvr-shutter-in-horizontal" value="Submit"/>
		</label>
		<a href="javascript:void(0)"  class="hvr-shutter-in-horizontal" onclick="clearInput()">Reset</a>
	</div>
    
  </tr>
 
</table>
</form>
</div>
	<script type="text/javascript">
	    function add(){
	    	var factory=document.form1.factory;
	    	var dname=document.form1.dname;
	    	var date=document.form1.date;
	    	var indate=document.form1.indate;
	    	var anumber=document.form1.anumber;
	    	if(dname.value.length==0){
	    		 document.getElementById("dname").innerHTML = "<font color='red'>必填</font>";
	    		return false;
	    	}
	    	if(factory.value.length==0){
	    		 document.getElementById("factory").innerHTML = "<font color='red'>必填</font>";
	    		return false;
	    	}
	    	if(date.value.length==0){
	    		 document.getElementById("date").innerHTML = "<font color='red'>必填</font>";
	    		return false;
	    	}
	    	if(indate.value.length==0){
	    		 document.getElementById("indate").innerHTML = "<font color='red'>必填</font>";
	    		return false;
	    	}
	    	if(anumber.value.length==0){
	    		 document.getElementById("anumber").innerHTML = "<font color='red'>必填</font>";
	    		return false;
	    	}
	    }
	    //清空輸入框
    	function clearInput(){
	    	$("td > input").each(function(){
			    $(this).val("");
	    	});
    	}

		/*设置日历颜色*/
		laydate.skin('molv');
	</script>
	 </div>
	       </div>
	
	<!--//faq-->
	<%@ include file="footer.jsp" %>
</body>
<html>
