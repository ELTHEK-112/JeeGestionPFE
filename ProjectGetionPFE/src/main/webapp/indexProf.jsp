<%@page import="javax.print.attribute.standard.Severity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="java.sql.*"
	import="Models.*" import="ModelsDbUtile.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@page import="Models.Professeur"%>
<html lang="en">
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Index Professeur</title>
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

		<!-- Modernizr -->
		<script src="assets/js/modernizr.min.js"></script>

		<!-- jQuery -->
		<script src="assets/js/jquery.min.js"></script>

		<!-- Moment -->
		<script src="assets/js/moment.min.js"></script>
		
		<!-- BEGIN CSS for this page -->
		<link href="assets/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" /> 
		<style>	
		#external-events .fc-event {
			margin: 10px 0;
			cursor: pointer;
		}
				
		#calendar {
			width: 100%;
		}

		.fc-event {
		font-size: 1em;
		border-radius: 2px;
		border: none;
		padding: 5px;
		}
		
		.fc-day-grid-event .fc-content {
		color: #fff;
		}	
		
		.fc-button {
		background: #eaeaea;
		border: none;
		color: #666b6f;
		margin: 0 3px !important;
		padding: 5px 12px !important;    
		text-transform: capitalize;
		height: auto !important;
		box-shadow: none !important;
		border-radius: 3px !important;    
		}
		
		.fc-state-down, .fc-state-active, .fc-state-disabled {
		background-color: #009ffc !important;
		color: #ffffff !important;
		text-shadow: none !important;
		}
		
		.fc-toolbar h2 {
		font-size: 20px;
		font-weight: 600;
		line-height: 28px;
		text-transform: uppercase;
		}
		
		.fc th.fc-widget-header {
		background: #e6e6e6;
		font-size: 13px;
		text-transform: uppercase;
		line-height: 18px;
		padding: 10px 0px;
		}
		
		.fc-unthemed th, .fc-unthemed td, .fc-unthemed thead, .fc-unthemed tbody, .fc-unthemed .fc-divider, .fc-unthemed .fc-row, .fc-unthemed .fc-popover {
		border-color: #eff1f3;
		}
		</style>
</head>

<body class="adminbody">

<div id="main">

	<!-- top bar navigation -->
	<div class="headerbar">

		<!-- LOGO -->
        <div class="headerbar-left">
			<a href="indexProf.jsp" class="logo"><img alt="Logo" src="assets/images/logo.png" /> <span>Admin</span></a>
        </div>

        <nav class="navbar-custom">
        <%
              Professeur pr = (Professeur) session.getAttribute("prof");
        
        %>
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

                               
                                <a href="login.jsp" class="dropdown-item notify-item">
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
						<a class="active" href="indexProf.jsp"><i class="fa fa-fw fa-bars"></i><span> Dashboard </span> </a>
                    </li>

				
					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-table"></i> <span> Tables Gestion </span> <span class="menu-arrow"></span></a>
							<ul class="list-unstyled">
								<li><a href="tables-listpro.jsp">Les Project</a></li>
								<li><a href="tables-etdprof.jsp">Les Etudiant</a></li>
								
							</ul>
                    </li>
										
                  

					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-file-text-o"></i> <span>Forms Gestion</span> <span class="menu-arrow"></span></a>
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
													<h1 class="main-title float-left">Dashboard</h1>
													<ol class="breadcrumb float-right">
														<li class="breadcrumb-item">Home</li>
														<li class="breadcrumb-item active">Dashboard</li>
													</ol>
													<div class="clearfix"></div>
											</div>
									</div>
						</div>
						
            </div>
              <div class="col-xs-8 col-md-6 col-lg-6 col-xl-5">
                                <div class="card-box tilebox-one noradius">
                                    <div id="calendar"></div>
									<div class="clearfix"></div>

                                </div>
                            </div>
                        </div>
			<!-- END container-fluid -->
		
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">						
							<div class="card mb-3">
								<div class="card-header">
									<h3><i class="fa fa-table"></i> List des Avanecemant</h3>
								</div>
									
								<div class="card-body">
									<div class="table-responsive">
									<table id="example5" class="table table-bordered table-hover display">
										<thead>
											<tr>
												
												<th>ID </th>
												<th>Etudiant  prenom</th>
												<th>Etudiant Nom </th>
												<th>Branch </th>
												<th>Nom Task</th>
												<th>temp pasee(jr)</th>
												<th>temp rest(jr)</th>
												<th>Date</th>
											</tr>
										</thead>										
										<tbody>
										<%
										List avns;
										if(request.getAttribute("avans") == null)
											 avns = AvancementDAO.getAll();
										else
											 avns = (ArrayList) request.getAttribute("avans"); 
										if(avns != null ){
										 for(int i = 0 ; i<avns.size();i++){
											 Avancement av = (Avancement) avns.get(i);
											 if(av.getEtudiant().getBranch().equalsIgnoreCase(pr.getBranch())){
										 
										%>
											<tr>
												<td><%=av.getIdAvancement() %></td>
												<td><%=av.getEtudiant().getPrenom() %></td>
												<td><%=av.getEtudiant().getNom() %></td>
												<td><%=av.getEtudiant().getBranch() %></td>
												<td><%=av.getTask().getNom() %></td>
												<td><%=av.getTpst() %></td>
												<td><%=av.getTrst() %></td>
												<td><%=av.getDate() %></td>
											</tr>
											
											<%}}} %>
										</tbody>
									</table>
									</div>
									
								</div>														
							</div><!-- end card-->					
						</div>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">						
							<div class="card mb-3">
								<div class="card-header">
									<h3><i class="fa fa-table"></i> List Des Rapport</h3>
									
								</div>
									
								<div class="card-body">
									<div class="table-responsive">
									<table id="example6" class="table table-bordered table-hover display">
										<thead>
											<tr>
												
												<th>ID</th>
												<th>Nom project</th>
												<th>Nom Etudiant </th>
												<th>Branch </th>
												<th>Date </th>
												<th>Action</th>
											</tr>
										</thead>										
										<tbody>
											<tr>
											<%
											List rappor;
											if(request.getAttribute("rapp")==null)
												rappor = RapportDAO.getAll();
											else 
												rappor = (ArrayList) request.getAttribute("rapp");
											
											if(rappor != null){
											for(int i=0 ; i<rappor.size();i++){
												
											     Rapport rp = (Rapport) rappor.get(i);
											     if(rp.getProjetFE().getProfesseur().getBranch().equalsIgnoreCase(pr.getBranch())){
											%>
												
												<td><%=rp.getIdRapport() %></td>
												<td><%=rp.getProjetFE().getNom() %></td>
												<td><%
												      for(int j = 0;j<rp.getProjetFE().getEtudiant().size();j++)
												    	  out.print(rp.getProjetFE().getEtudiant().get(j).getNom()+" "+rp.getProjetFE().getEtudiant().get(i).getPrenom()+"\n");
                                                     %></td>
												<td><%=rp.getProjetFE().getEtudiant().get(0).getBranch() %></td>
												<td><%=rp.getDate() %></td>
												<td>

                                                     <a href="#addSout<%=rp.getIdRapport() %>"  data-toggle="modal" >
                            <button type='button'  class="btn btn-info"><i class="fa fa-exclamation"></i></button>
                            </a>
                            
                      <div id="addSout<%=rp.getIdRapport() %>" class="modal fade" role="dialog">
                        <form method="get" action="visitControler" class="form-horizontal" role="form">
                              <input type="hidden" name="idRapor" value="<%=rp.getIdRapport() %>">
                              <input type="hidden" name="command" value="3"> 
                            <div class="modal-dialog modal-lg">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Ajouter un Soutenance pour le Rappor de Project <%=rp.getProjetFE().getNom() %> :</h4>
                                    </div>
                                    <div class="modal-body"> 
                                        <input type="hidden" name="command" value="4">
                                        <div class="form-row">
                                            <label class="control-label col-sm-2" for="item_name">ID:</label>
                                            <div class="col-sm-4">
                                            <%
                                            int idSot;
                                            try{
                                            ResultSet rs = SingleConnection.readQury("select MAX(ID) from soutenance");
                                              while(rs.next()){ idSot =1+rs.getInt(1);
                                            
                                            
                                            
                                            %>
                                                <input type="text" class="form-control" id="item_name" value="<%=idSot %>" name="idsot"  placeholder="Item Name" required autofocus>
                                            <%}}catch(SQLException s){} %>
                                             </div>
                                             <label class="control-label col-sm-2" for="item_name">Jury :</label>
                                            <div class="col-sm-4">
                                               <select class="form-control" name="prof">
								                         <%
                                                    ArrayList<Jury> list = JuryDAO.getAll();
                                                   
                                                    for(Jury jury : list){
                                                    
                                                    %>
							 	                    <option value="<%=jury.getIdjury() %>"><% out.print(jury.getNom()+" "+jury.getBranch()); } %></option>
							                     	
							                     	</select>
                                             </div>
                                             </div>
                                             <div class="form-row">
                                             <label class="control-label col-sm-2" for="item_name">Note:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control" id="item_name" name="note"  required autofocus>
                                             </div>
                                             
                                              <label class="control-label col-sm-2" for="item_name">Date:</label>
                                            <div class="col-sm-4">
                                                <input type="date" class="form-control" id="item_name" name="datesot"  required autofocus>
                                             </div>
                                             </div>
                                            
                                        
                                        
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary" name="update_item"><span class="glyphicon glyphicon-edit"></span> Save</button>
                                        <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span> Cancel</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                            
                           


</td>
											
											</tr>
											<%}}} %>
										</tbody>
									</table>
									</div>
									
								</div>														
							   </div><!-- end card-->					
						
																			
							</div>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">						
							<div class="card mb-3">
								<div class="card-header">
									<h3><i class="fa fa-table"></i> List Des Jury</h3>
									
								</div>
							<div class="card-body">
									<div class="table-responsive">
									<table id="example5" class="table table-bordered table-hover display">
										<thead>
											<tr>
												
												<th>ID </th>
												<th>Jury</th>
												<th>Branch</th>
												<th>Les Professeur</th>
											</tr>
										</thead>										
										<tbody>
										<%
										List jury;
										if(request.getAttribute("jury") == null)
											jury = JuryDAO.getAll();
										else
											jury = (ArrayList) request.getAttribute("jury"); 
										if(jury != null ){
										 for(int i = 0 ; i<jury.size();i++){
											 Jury jur = (Jury) jury.get(i);
											 if(jur.getBranch().equalsIgnoreCase(pr.getBranch())){
										 
										%>
											<tr>
												<td><%=jur.getIdjury() %></td>
												<td><%=jur.getNom() %></td>
												<td><%=jur.getBranch() %></td>
							 					<td><%
							 					 for(int j = 0 ; j<jur.getProfesseur().size();j++){
							 						 Professeur p = jur.getProfesseur().get(j);
							 						 out.println(p.getNom()+" "+p.getPrenom()+"\n");
							 					 }
							 					
							 					%></td>
											</tr>
											
											<%}}} %>
										</tbody>
									</table>
									</div>
									
								</div>
								</div>	
</div>
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

<!-- END main -->

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script src="assets/js/detect.js"></script>
<script src="assets/js/fastclick.js"></script>
<script src="assets/js/jquery.blockUI.js"></script>
<script src="assets/js/jquery.nicescroll.js"></script>

<!-- App js -->
<script src="assets/js/pikeadmin.js"></script>

<!-- BEGIN Java Script for this page -->
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/plugins/fullcalendar/fullcalendar.min.js"></script>
<script>
$(document).ready(function() {
	
		/* initialize the external events
		-----------------------------------------------------------------*/
		$('#external-events .fc-event').each(function() {

			// store data so the calendar knows to render an event upon drop
			$(this).data('event', {
				title: $.trim($(this).text()), // use the element's text as the event title
				stick: true // maintain when user navigates (see docs on the renderEvent method)
			});

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});

		});

		/* initialize the calendar
		-----------------------------------------------------------------*/
		var date = new Date();
		var d    = date.getDate();
        m    = date.getMonth();
        y    = date.getFullYear();
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			selectable: true,
			selectHelper: true,
			select: function(start, end) {
				var title = prompt('Event Title:');
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					};
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
				$('#calendar').fullCalendar('unselect');
			},
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: [
					{
					  title          : 'All Day Event',
					  start          : new Date(y, m, 2),
					  className: 'bg-primary',
					},
					{
					  title          : 'Long Event',
					  start          : new Date(y, m, d - 4),
					  end            : new Date(y, m, d - 2),
					  className: 'bg-info',
					},
					{
					  title          : 'Meeting John',
					  start          : new Date(y, m, d, 15, 20),
					  allDay         : false,
					  className: 'bg-primary',
					},
					{
					  title          : 'New Task',
					  start          : new Date(y, m, d, 12, 0),
					  end            : new Date(y, m, d, 16, 0),
					  allDay         : false,
					  className: 'bg-danger',
					},
					{
					  title          : 'Birthday Party',
					  start          : new Date(y, m, d + 2, 15, 0),
					  end            : new Date(y, m, d + 2, 20, 40),
					  allDay         : false,
					  className: 'bg-warning',
					},
					{
					  title          : 'Alice Birthday',
					  start          : new Date(y, m, d + 4, 15, 0),
					  end            : new Date(y, m, d + 4, 18, 30),
					  allDay         : false,
					  className: 'bg-info',
					},
					{
					  title          : 'Click for Google',
					  start          : new Date(y, m, 27),
					  end            : new Date(y, m, 28),
					  url            : 'http://google.com/',
					  className: 'bg-danger', 
					}
				
			],
			droppable: true, // this allows things to be dropped onto the calendar
			drop: function() {
		
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
			}
		});
});
</script>
</body>
</html>