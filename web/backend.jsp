<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Backend.main.Bean" %>
<html>
<head>
		<meta charset="utf-8" />
        <title>后台管理</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <link rel="stylesheet" href="stylesheets/style.css">
        <!-- App favicon -->
        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <!-- App css -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="assets/js/modernizr.min.js"></script>
        <!-- Sweet Alert css -->
        <link href="plugins/sweet-alert/sweetalert2.min.css" rel="stylesheet" type="text/css" />
        <!--Footable-->
        <link href="plugins/footable/css/footable.core.css" rel="stylesheet">
</head>
<style>
	input{
		display:none;
	}
</style>
<body>
<!-- Navigation Bar-->
 <header id="topnav">
     <div class="topbar-main">
         <div class="container-fluid">
             <!-- Logo container-->
             <div class="logo">
                 <a href="#" class="logo">
                     <span class="logo-large">后台管理</span>
                 </a> 
             </div>
             <!-- End Logo container-->
             <div class="menu-extras topbar-custom">
                 <ul class="list-unstyled topbar-right-menu float-right mb-0">      
                 </ul>
             </div>
             <!-- end menu-extras -->
             <div class="clearfix"></div>
         </div> <!-- end container -->
     </div>
     <!-- end topbar-main -->

     <div class="navbar-custom">
         <div class="container-fluid">
             <div id="navigation">
                 <!-- Navigation Menu-->
                 <form action="">
                 </form>
                 <!-- End navigation menu -->
             </div> <!-- end #navigation -->
         </div> <!-- end container -->
     </div> <!-- end navbar-custom -->
 </header>
 <!-- End Navigation Bar-->
<div class="wrapper">
     <div class="container-fluid">
         <div class="row mt-4">
            <div class="col-12">
                <div class="card-box" style="min-height: 300px;">
                   <!-- Left sidebar -->
                   <div class="inbox-leftbar">
                       <div class="mail-list">
                           <a href="#" class="list-group-item border-0 manage-menu active" _target="user"><i class="mdi mdi-inbox font-18 align-middle mr-2"></i>用户管理</a>
                           <a href="#" class="list-group-item border-0 manage-menu" _target="goods"><i class="mdi mdi-star font-18 align-middle mr-2"></i>商品管理</a>
                           <a href="#" class="list-group-item border-0 manage-menu" _target="ad"><i class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>广告栏管理</a>
                       </div>
                   </div>
                   <div class="inbox-rightbar">
                      <div role="toolbar">
                          <div id="table_container" class="ml-5">
                          		<h4 class="m-t-0 header-title" id="ms_title">用户管理</h4>
                          		 <table class="table table-colored m-b-0 toggle-arrow-tiny footable-loaded footable tablet breakpoint" data-page-size="7" data-filter="#filter">
                          		 	<thead>
                          		 		<tr>
                          		 			<th data-toggle="true" > 用户名 </th>
                          		 			<th data-hide="phone"> 昵称 </th>
                          		 			<th> 用户权限 </th>
                          		 			<th> 用户状态 </th>
                          		 			<th data-sort-ignore="true"> 操作 </th>
                          		 			<!-- <th data-hide="all"> id </th>
                          		 			<th data-hide="all"> 注册时间 </th> -->
                          		 			<th></th>
                          		 			<th></th>
                          		 			<th></th>
                          		 		</tr>
                          		 	</thead>
                          		 	<tbody>
	                          		 	<% Bean bean=new Bean(); 
										bean.open();
										int row=bean.getRowNum(); 
										for (int i=1;i<=row;i++){
											bean.setIndex(i);
											%>
											<tr>
												<td><%=bean.getUserName()%></td>
												<td><%=bean.getNickName() %></td>
												<td ><%=bean.getPower()%></td>
                                                <td><span class="badge label-table <%=bean.getState().equals("正常")?"badge-success":"badge-danger"%>"><%=bean.getState()%><span></span></td>
											
												<form action="backendServlet" method="post">
													<td><button type="submit" name="operation" value="1" class="btn btn-sm btn-outline-danger waves-light waves-effect mr-2">封号</button></td>
													<td><button type="submit" name="operation" value="2" class="btn btn-sm btn-outline-warning waves-light waves-effect mr-2">删除用户</button></td>
													<td><button type="submit" name="operation" value="3" class="btn btn-sm btn-outline-info waves-light waves-effect mr-2">解封</button></td>
													<td><input name="index" value="null"></td>
												</form>
												<%
												} bean.close();
												%>
											</tr>
                                    </tbody>
                                    <tfoot>
                                    	<tr class="active">
                                            <td colspan="5">
                                                <div class="text-right">
                                                    <ul class="pagination pagination-split justify-content-end footable-pagination m-t-10 m-b-0"></ul>
                                                </div>
                                            </td>
                                        </tr>
                                    </tfoot>
                                   </table>
                          		
                          </div>
                      </div>
                   </div>
                </div>
            </div>
        </div>
    </div> <!-- end container -->
</div>
<!-- end wrapper -->

	
	
<!-- Footer -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                这里是页脚
            </div>
        </div>
    </div>
</footer>
<!-- End Footer -->
</body>
</html>
<script type="text/javascript">
	function test(){
		var len=document.getElementsByTagName('input').length;
		for (var i=0;i<len;i++)
		{ 
			document.getElementsByTagName('input')[i].value=i+1;
		}
	}

	test();
</script>
<!-- jQuery  -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/waves.js"></script>
<script src="assets/js/jquery.slimscroll.js"></script>
<!-- App js -->
<script src="assets/js/jquery.core.js"></script>
<script src="assets/js/jquery.app.js"></script>
<!-- getVerificationCode -->
<script src="javascripts/verificationCode.js"></script>
<!-- Sweet Alert Js  -->
<script src="plugins/sweet-alert/sweetalert2.min.js"></script>
<script src="assets/pages/jquery.sweet-alert.init.js"></script>
<script src="assets/js/modernizr.min.js"></script>
<!--FooTable-->
<script src="plugins/footable/js/footable.all.min.js"></script>
<!--FooTable Example-->
<script src="assets/pages/jquery.footable.js"></script>
