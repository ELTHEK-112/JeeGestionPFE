<%@page import="javax.print.attribute.standard.Severity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="java.sql.*"
	import="Models.*" import="ModelsDbUtile.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <%
              Professeur pr = (Professeur) session.getAttribute("prof");
        
        %>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Les Etudiant</title>
		<meta name="description" content="Free Bootstrap 4 Admin Theme | Pike Admin">
		<meta name="author" content="Pike Web Development - https://www.pikephp.com">

		<!-- Favicon -->
		<link rel="shortcut icon" href="assets/images/favicon.ico">

		<!-- Bootstrap CSS -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Font Awesome CSS -->
		<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Custom CSS -->
		<link href="assets/css/style.css" rel="stylesheet" type="text/css" />		
		
		<!-- BEGIN CSS for this page -->
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>	
		<style>	
		td.details-control {
		background: url('assets/plugins/datatables/img/details_open.png') no-repeat center center;
		cursor: pointer;
		}
		tr.shown td.details-control {
		background: url('assets/plugins/datatables/img/details_close.png') no-repeat center center;
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
			<a href="indexEtudiant.jsp" class="logo"><img alt="Logo" src="assets/images/logo.png" /> <span>Admin</span></a>
        </div>
</div>
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
                        <a href="#" class="active"><i class="fa fa-fw fa-table"></i> <span> Tables Gestion </span> <span class="menu-arrow"></span></a>
							<ul class="list-unstyled">
								
								<li><a href="tables-listpro.jsp">Les project</a></li>
								<li><a href="tables-etdprof.jsp"> Les Etudiant </a></li>
							</ul>
                    </li>
										
                
					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-file-text-o"></i> <span> Forms Gestion </span> <span class="menu-arrow"></span></a>
                            <ul class="list-unstyled">
                            
                            <li><a href="form-project.jsp">Form Project</a></li>
                               
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
										<h1 class="main-title float-left">Tables</h1>
										<ol class="breadcrumb float-right">
											<li class="breadcrumb-item">Home</li>
											<li class="breadcrumb-item active">Les Etudaint</li>
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
									<h3><i class="fa fa-table"></i>Les Etudiant</h3>
								
								</div>
									
								<div class="card-body">
									<div class="table-responsive">
									<table id="example1" class="table table-bordered table-hover display">
										<thead>
											<tr>
												<th></th>
												<th>Nom </th>
												<th>prenom</th>
												<th>Cne</th>
												<th>BRanch</th>
												<th>ID</th>
												<th>Action</th>
											</tr>
										</thead>										
										<tbody>
										<%
										List re;
				                  if(request.getAttribute("etd")== null){
				                	  re = EtudiantDAO.getAll();
				                  }else{
				                	  re = (ArrayList) request.getAttribute("etd"); 
				                  }
				                   
										for(int i = 0 ; i<re.size(); i++){
											
										  Etudiant etd = (Etudiant) re.get(i);
										  if(etd.getBranch().equalsIgnoreCase(pr.getBranch())){
										
										%>
											<tr>
												<td>  
														
															<img src="assets/images/avatars/avatar1.png" alt="Profile image" class="avatar-rounded">
														</td>
												<td><%=etd.getNom() %></td>
												<td><%=etd.getPrenom() %></td>
												<td><%=etd.getCne() %></td>
												<td><%=etd.getBranch() %></td>
												<td><%=etd.getIdEtudiant() %></td>
												<td>
                                                     <a href="#addproj<%=etd.getIdEtudiant() %>" data-toggle="modal" >
                            <button type='button'  class="btn btn-info"><i class="fa fa-exclamation"></i></button>
                            </a>
                        
                             <div id="addproj<%=etd.getIdEtudiant() %>" class="modal fade" role="dialog">
                        <form method="post" action="controlerEtudint" class="form-horizontal" role="form">
                              <input type="hidden" name="idetdM" value="<%=etd.getIdEtudiant() %>">
                              <input type="hidden" name="idprofses" value="<%=pr.getIDProfesseur() %>">
                              <input type="hidden" name="command" value="3"> 
                            <div class="modal-dialog modal-lg">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        
                                        <h4 class="modal-title">Modifer Etudiant :</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <div class="modal-body"> 
                                       
                                        <div class="form-row">
                                            <label class="control-label col-sm-2" for="item_name">ID Etudiant:</label>
                                            <div class="col-sm-4">
                                          
                                                <input type="text" class="form-control" readonly id="item_name" value="<%=etd.getIdEtudiant() %>" name="idetd"  placeholder="Item Name" required autofocus>
                                            
                                             </div>
                                             <label class="control-label col-sm-2" for="item_name">Nom Etudiant :</label>
                                            <div class="col-sm-4">
                                               <input type="text" readonly class="form-control" id="item_name"  name="nometd" value="<%=etd.getNom() %>" placeholder="Item Name" required autofocus>
                                             </div>
                                             <label class="control-label col-sm-2" for="item_name">Prenom Etudiant :</label>
                                            <div class="col-sm-4">
                                               <input type="text" readonly class="form-control" id="item_name"  name="prenometd" value="<%=etd.getPrenom() %>" placeholder="Item Name" required autofocus>
                                             </div>
                                             
                                        </div>
                                             <div class="form-row">
                                             <label class="control-label col-sm-2" for="item_name">CNE Etudiant :</label>
                                            <div class="col-sm-4">
                                               <input type="text" readonly class="form-control" id="item_name"  name="cneetd" value="<%=etd.getCne() %>" placeholder="Item Name" required autofocus>
                                             </div>
                                             <label class="control-label col-sm-2" for="item_name"> Branch:</label>
                                            <div class="col-sm-4">
                                                <input type="text" readonly class="form-control" id="item_name" name="branchetd" value="<%=etd.getBranch() %>"  required autofocus>
                                             </div>
                                             <label class="control-label col-sm-2" for="item_name">Project :</label>
                                              <div class="col-sm-4">
                                             <select class="form-control" name="project">
								                         <%
                                                    ArrayList<ProjetFE> list = ProjetFEDAO.getAll();
                                                   
                                                    for(ProjetFE Proje : list){
                                                    
                                                    %>
							 	                    <option value="<%=Proje.getIdProjetFE() %>"><% out.print(Proje.getNom());}%></option>
							                     	
							                     	</select>
							                     	
							                 </div>
                                    
                                    </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary" name="update_item"><span class="glyphicon glyphicon-edit"></span> Edit</button>
                                        <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span> Cancel</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    
											</tr>
											<%}} %>
										</tbody>
									</table>
									</div>
									
								</div>														
							</div><!-- end card-->					
						</div>
						
			


            </div>
			<!-- END container-fluid -->

		</div>
		<!-- END content -->

    </div>
	<!-- END content-page -->
    
	<footer class="footer">
		<span class="text-right">
		Copyright <a target="_blank" href="#">PFE DSI 2019</a>
		</span>
		<span class="float-right">
			Designed by  <a target="_blank" href="https://www.pikeadmin.com"><b>MedAliBah</b></a>
		</span>
	</footer>

</div>
<!-- END main -->

<script src="assets/js/modernizr.min.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/moment.min.js"></script>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script src="assets/js/detect.js"></script>
<script src="assets/js/fastclick.js"></script>
<script src="assets/js/jquery.blockUI.js"></script>
<script src="assets/js/jquery.nicescroll.js"></script>

<!-- App js -->
<script src="assets/js/pikeadmin.js"></script>

<!-- BEGIN Java Script for this page -->
	<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

	<script>
	// START CODE FOR BASIC DATA TABLE 
	$(document).ready(function() {
		$('#example1').DataTable();
	} );
	// END CODE FOR BASIC DATA TABLE 
	
	
	// START CODE FOR Child rows (show extra / detailed information) DATA TABLE 
	function format ( d ) {
		// `d` is the original data object for the row
		return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
			'<tr>'+
				'<td>Full name:</td>'+
				'<td>'+d.name+'</td>'+
			'</tr>'+
			'<tr>'+
				'<td>Extension number:</td>'+
				'<td>'+d.extn+'</td>'+
			'</tr>'+
			'<tr>'+
				'<td>Extra info:</td>'+
				'<td>And any further details here (images etc)...</td>'+
			'</tr>'+
		'</table>';
	}
 
		$(document).ready(function() {
			var table = $('#example2').DataTable( {
				"ajax": "assets/data/dataTablesObjects.txt",
				"columns": [
					{
						"className":      'details-control',
						"orderable":      false,
						"data":           null,
						"defaultContent": ''
					},
					{ "data": "name" },
					{ "data": "position" },
					{ "data": "office" },
					{ "data": "salary" }
				],
				"order": [[1, 'asc']]
			} );
			 
			// Add event listener for opening and closing details
			$('#example2 tbody').on('click', 'td.details-control', function () {
				var tr = $(this).closest('tr');
				var row = table.row( tr );
		 
				if ( row.child.isShown() ) {
					// This row is already open - close it
					row.child.hide();
					tr.removeClass('shown');
				}
				else {
					// Open this row
					row.child( format(row.data()) ).show();
					tr.addClass('shown');
				}
			} );
		} );
		// END CODE FOR Child rows (show extra / detailed information) DATA TABLE 		
		
				
		
		// START CODE Show / hide columns dynamically DATA TABLE 		
		$(document).ready(function() {
			var table = $('#example3').DataTable( {
				"scrollY": "350px",
				"paging": false
			} );
		 
			$('a.toggle-vis').on( 'click', function (e) {
				e.preventDefault();
		 
				// Get the column API object
				var column = table.column( $(this).attr('data-column') );
		 
				// Toggle the visibility
				column.visible( ! column.visible() );
			} );
		} );
		// END CODE Show / hide columns dynamically DATA TABLE 	
		
		
		// START CODE Individual column searching (text inputs) DATA TABLE 		
		$(document).ready(function() {
			// Setup - add a text input to each footer cell
			$('#example4 thead th').each( function () {
				var title = $(this).text();
				$(this).html( '<input type="text" placeholder="Search '+title+'" />' );
			} );
		 
			// DataTable
			var table = $('#example4').DataTable();
		 
			// Apply the search
			table.columns().every( function () {
				var that = this;
		 
				$( 'input', this.header() ).on( 'keyup change', function () {
					if ( that.search() !== this.value ) {
						that
							.search( this.value )
							.draw();
					}
				} );
			} );
		} );
		// END CODE Individual column searching (text inputs) DATA TABLE 	 	
	</script>	
<!-- END Java Script for this page -->

</body>
</html>