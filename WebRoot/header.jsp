<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<title>药品信息管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/laydate/laydate.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="layer/layer.js"></script>
	
</script>

<!-- Mainly scripts -->
<script src="js/jquery.metisMenu.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<link href="css/custom.css" rel="stylesheet">
<script src="js/custom.js"></script>
<script src="js/screenfull.js"></script>
<script>
	$(function() {
		$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

		if (!screenfull.enabled) {
			return false;
		}

		$('#toggle').click(function() {
			screenfull.toggle($('#container')[0]);
		});

		
	    	$("td > input").each(function(){
			    $(this).addClass("form-control-static");
	    	});
	    	
	    	
// 	    var url = document.URL;
// 	    if(url.indexOf("HomeServlet.do") >= 0){
// 	    	$(".nav li").removeClass("active");
// 	    	$(".nav1").addClass("active");
// 	    	$(".nav1>ul").removeClass("").addClass("collapse").addClass("in");
// 	    	$(".nav1>ul").css("aria-expanded",true);
// 	    }
	});
</script>


<style>
.table td, .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td,
	.table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
	border-top: 1px solid #ddd !important;
}

.style_serach {
	height: 34px;
	margin: 0px !important;
}

td>input, td>select {
	margin: 15px 0px;
	height: 34px;
}

.buttons {
	font-size: 1em !important;
}
</style>
</head>