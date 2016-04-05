<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div id="wrapper">
       <!----->
        <nav class="navbar-default navbar-static-top" role="navigation">
             <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <h1> <a class="navbar-brand" href="index.html">Medicine</a></h1>         
			   </div>
			 <div class=" border-bottom">
        	<div class="full-left">
            <div class="clearfix"> </div>
           </div>
     
       
            <!-- Brand and toggle get grouped for better mobile display -->
		 
		   <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="drop-men" style="width: 100px;line-height: 60px;">
		        <ul class=" nav_1">
		           
					<li class="dropdown">
		              <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret">${sessionScope.user.username}<i class="caret"></i></span></a>
		              <ul class="dropdown-menu " role="menu">
		                <li><a href="login.jsp"><i class="fa fa-user"></i>退出登录</a></li>
		              </ul>
		            </li>
		           
		        </ul>
		     </div><!-- /.navbar-collapse -->
			<div class="clearfix">
       
     </div>
	  
		    <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
				
                    <li class="nav1">
                        <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-indent nav_icon"></i> <span class="nav-label">药品管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="HomeServlet.do?type2=frist" class=" hvr-bounce-to-right"> <i class="fa fa-area-chart nav_icon"></i>药品信息</a></li>
                            
                            <li><a href="addinfo.jsp" class=" hvr-bounce-to-right"><i class="fa fa-map-marker nav_icon"></i>添加药品</a></li>
			
					   </ul>
                    </li>
					 <li class="nav2">
                        <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-inbox nav_icon"></i> <span class="nav-label">入库管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                       		 <li><a href="ruku.jsp" class=" hvr-bounce-to-right"><i class="fa fa-file-text-o nav_icon"></i>药品入库</a></li>
                        
                       		 <li><a href="RukuServlet.do?type1=frist" class=" hvr-bounce-to-right"><i class="fa fa-file-text-o nav_icon"></i>入库明细</a></li>
                        </ul>
                    </li>
                    
                     <li class="nav3">
                        <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-desktop nav_icon"></i> <span class="nav-label">出库管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="Kc2Servlet.do?type1=frist" class=" hvr-bounce-to-right"> <i class="fa fa-info-circle nav_icon"></i>药品出库</a></li>
                            <li><a href="CukuServlet.do?type1=frist" class=" hvr-bounce-to-right"><i class="fa fa-question-circle nav_icon"></i>出库明细</a></li>
                       </ul>
                    </li>
                   
                    <li class="nav4">
                        <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-list nav_icon"></i> <span class="nav-label">库存管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="KcServlet.do?type1=frist" class=" hvr-bounce-to-right"><i class="fa fa-align-left nav_icon"></i>库存查询</a></li>
                            <li><a href="Kc1Servlet.do" class=" hvr-bounce-to-right"><i class="fa fa-check-square-o nav_icon"></i>下限提醒</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
			</div>
        </nav>
