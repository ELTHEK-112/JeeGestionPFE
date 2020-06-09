<%@page import="javax.print.attribute.standard.Severity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="java.sql.*"
	import="Models.*" import="ModelsDbUtile.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Form Project</title>
		<meta name="description" content="Free Bootstrap 4 Admin Theme | Pike Admin">
		<meta name="author" content="Pike Web Development - https://www.pikephp.com">

		<!-- Favicon -->
		<link rel="shortcut icon" href="assets/images/favicon.ico">

		<!-- Switchery css -->
		<link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet" />
		
		<!-- Bootstrap CSS -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Font Awesome CSS -->
		<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Custom CSS -->
		<link href="assets/css/style.css" rel="stylesheet" type="text/css" />
		
		<script src="assets/js/modernizr.min.js"></script>
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/moment.min.js"></script>

		<!-- BEGIN CSS for this page -->
		<style>
		.parsley-error {
			border-color: #ff5d48 !important;
		}
		.parsley-errors-list.filled {
			display: block;
		}
		.parsley-errors-list {
			display: none;
			margin: 0;
			padding: 0;
		}
		.parsley-errors-list > li {
			font-size: 12px;
			list-style: none;
			color: #ff5d48;
			margin-top: 5px;
		}
		.form-section {
			padding-left: 15px;
			border-left: 2px solid #FF851B;
			display: none;
		}
		.form-section.current {
			display: inherit;
		}
		</style>
		<!-- END CSS for this page -->
				
</head>

<body class="adminbody">

<div id="main">

	<!-- top bar navigation -->
	<div class="headerbar">

		<!-- LOGO -->
        <div class="headerbar-left">
			<a href="indexProf.jsp" class="logo"><img alt="logo" src="assets/images/logo.png" /> <span>Admin</span></a>
        </div>
  <%
              Professeur pr = (Professeur) session.getAttribute("prof");
        
        %>
        <nav class="navbar-custom">

                    <ul class="list-inline float-right mb-0">
                        <li class="list-inline-item dropdown notif">
                            <a class="nav-link dropdown-toggle nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <img src="assets/images/avatars/admin.png" alt="Profile image" class="avatar-rounded">
                            </a>
                            
                         <div class="dropdown-menu dropdown-menu-right profile-dropdown">
                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h5 class="text-overflow"><small>Hello, <%=pr.getNom() %>  <%=pr.getPrenom() %></small> </h5>
                                </div>

                               
                                <a href="logoutControler" class="dropdown-item notify-item">
                                    <i class="fa fa-power-off"></i> <span>Logout</span>
                                </a>

                               
                            </div>
                            </li>

                    </ul>

                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left">
								<i class="fa fa-fw fa-bars"></i>
                            </button>
                        </li>                        
                    </ul>

        </nav>

	</div>
	<!-- End Navigation -->
	
 
	<!-- Left Sidebar -->
	<div class="left main-sidebar">
	
		<div class="sidebar-inner leftscroll">

			<div id="sidebar-menu">
        
			<ul>

					<li class="submenu">
						<a href="indexProf.jsp"><i class="fa fa-fw fa-bars"></i><span> Dashboard </span> </a>
                    </li>

				
					
					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-table"></i> <span> Tables Gestion </span> <span class="menu-arrow"></span></a>
							<ul class="list-unstyled">
								<li><a href="tables-listpro.jsp"> Les Project</a></li>
								<li><a href="tables-etdprof.jsp"> Les etudiant</a></li>
							</ul>
                    </li>
										
                   

					<li class="submenu">
                        <a href="#" class="active"><i class="fa fa-fw fa-file-text-o"></i> <span> Forms Gestion </span> <span class="menu-arrow"></span></a>
                            <ul class="list-unstyled">
                           
						
                                <li class="active"><a href="form-project.jsp">Form Project</a></li>
                               
								
								
                            </ul>
                    </li>
					
                   				
            </ul>

            <div class="clearfix"></div>

			</div>
        
			<div class="clearfix"></div>

		</div>

	</div>
	<!-- End Sidebar -->


    <div class="content-page">
	
		<!-- Start content -->
        <div class="content">
            
			<div class="container-fluid">


			<div class="row">
					<div class="col-xl-12">
							<div class="breadcrumb-holder">
                                    <h1 class="main-title float-left">Form </h1>
                                    <ol class="breadcrumb float-right">
										<li class="breadcrumb-item">Home</li>
										<li class="breadcrumb-item active">Form Project</li>
                                    </ol>
                                    <div class="clearfix"></div>
                            </div>
					</div>
			</div>
            <!-- end row -->
			

			

			
			<div class="row">
			
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">						
						<div class="card mb-3">
							<div class="card-header">
								<h3><i class="fa fa-hand-pointer-o"></i> Form Project </h3>
								
							</div>
								
							<div class="card-body">
																
										<form action="controlerProject" method="get" data-parsley-validate novalidate>
									<input  type="hidden"  value="2" name="command"  >
                                                    <div class="form-group">
                                                        <label for="userName">Nom :<span class="text-danger">*</span></label>
                                                        <input type="text" name="nom" data-parsley-trigger="change" required placeholder="Enter le nom" class="form-control" id="userName">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="userName">Date project  :<span class="text-danger">*</span></label>
                                                        <input type="date" name="date" data-parsley-trigger="change" required placeholder="Enter le Prenom" class="form-control" id="emailAddress">
                                                    </div>
                                                    <%
                                                    try{
                                                    	ResultSet rs =SingleConnection.readQury("select MAX(ID) from projetfe");
                                                          while(rs.next()){
                                                        	  
                                                          int id = rs.getInt(1) + 1;
                                                    
                                                    
                                                    %>
                                                   
                                                     <div class="form-group">
                                                        <label for="userName">ID Project  :<span class="text-danger">*</span></label>
                                                        <input type="text"  value="<%=id %>" readonly  name="id" data-parsley-trigger="change" required placeholder="ID Project " class="form-control" id="userName">
                                                    
                                                    </div>
                                                    <%
                                                          }}catch(SQLException ex){}
                                                    %>
                                                     <div class="form-group">
                                                        <label>Description :</label>
                                                        <div>
                                                            <textarea name="description" required class="form-control"></textarea>
                                                        </div>
                                                    </div>
                                                  
                                                    <div class="form-group">
                                                   
								                   <label for="userName">ID Professeru   :<span class="text-danger">*</span></label>
                                                        <input type="text"  value="<%=pr.getIDProfesseur() %>" readonly  name="prof" data-parsley-trigger="change" required placeholder="ID Project " class="form-control" id="userName">
                                                    </div>
                                                   

                                                    <div class="form-group text-right m-b-0">
                                                        <button class="btn btn-primary" type="submit">
                                                            Submit
                                                        </button>
                                                        <button type="reset" class="btn btn-secondary m-l-5">
                                                            Cancel
                                                        </button>
                                                    </div>

                                        </form>
										
							</div>														
						</div><!-- end card-->					
                    </div>
			</div>





            </div>
			<!-- END container-fluid -->

		</div>
		<!-- END content -->

    </div>
	<!-- END content-page -->
    
	<footer class="footer">
		<span class="text-right">
		Copyright <a target="_blank" href="#">Your Website</a>
		</span>
		<span class="float-right">
		Powered by <a target="_blank" href="https://www.pikeadmin.com"><b>Pike Admin</b></a>
		</span>
	</footer>

</div>
<!-- END main -->

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script src="assets/js/detect.js"></script>
<script src="assets/js/fastclick.js"></script>
<script src="assets/js/jquery.blockUI.js"></script>
<script src="assets/js/jquery.nicescroll.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/plugins/switchery/switchery.min.js"></script>

<!-- App js -->
<script src="assets/js/pikeadmin.js"></script>

<!-- BEGIN Java Script for this page -->
<script src="assets/plugins/parsleyjs/parsley.min.js"></script>
<script>
  $('#form').parsley();
</script>
<!-- END Java Script for this page -->

</body>
</html>