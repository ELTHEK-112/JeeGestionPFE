package Controlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.org.glassfish.gmbal.Description;

import Models.*;
import ModelsDbUtile.*;

/**
 * Servlet implementation class controlerProject
 */
public class controlerProject extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the "command" parameter
			int theCommand = Integer.parseInt(request.getParameter("command"));
			
			// if the command is missing, then default to listing students
			if (theCommand == 0) {
				theCommand = 1;
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case 1:
				listProject(request, response);
				break;
				
			case 2:
				addProject(request, response);
				break;
		    case 3:
		    	deletProject(request, response);
		    	break;
		    case 4:
		    	updarProject(request, response);

			default:
				listProject(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int theCommand = Integer.parseInt(request.getParameter("command"));
		if(theCommand == 3) {
			int id  =  Integer.parseInt(request.getParameter("idprofM"));
		 
		 int idprf = Integer.parseInt(request.getParameter("idprofSes"));
		 HttpSession session = request.getSession();
		 ProjetFE proj = ProjetFEDAO.getById(id);
		 
		 if(ProjetFEDAO.delete(proj)) {
				
				session.setAttribute("prof", ProfesseurDAO.getById(idprf));
				listProject(request, response);
				
		 } else {
					response.sendRedirect("form_project.jsp");
		 }
		}if(theCommand==4) {
			
			int id  =  Integer.parseInt(request.getParameter("idprofM"));
			 
		
			 
			 int idprf = Integer.parseInt(request.getParameter("idprofSes"));
			 String nom = request.getParameter("nomproj");
			 String Discr = request.getParameter("disc");
			 String date = request.getParameter("dateproj");
			 SimpleDateFormat rf = new SimpleDateFormat("yyyy-MM-dd");
			 Date dt = null;
			try {
				dt = rf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 HttpSession session = request.getSession();
				
			 
			 
			 ProjetFE proj = new ProjetFE(id, nom, Discr, dt);
			 
			 if(ProjetFEDAO.updat(proj, proj, idprf)) {
				
		
			
					session.setAttribute("prof", ProfesseurDAO.getById(idprf));
					listProject(request, response);
			 } else {
						response.sendRedirect("form_project.jsp");
			 }
		}
				
	}

	private void updarProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
 
		
		
		 
	}

	private void deletProject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
        
		 
		
	}
	private void addProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		
		
		 int id  =  Integer.parseInt(request.getParameter("id"));
		 
	
		 
		 int idprf = Integer.parseInt(request.getParameter("prof"));
		 String nom = request.getParameter("nom");
		 String Discr = request.getParameter("description");
		 String date = request.getParameter("date");
		 SimpleDateFormat rf = new SimpleDateFormat("yyyy-MM-dd");
		 Date dt = rf.parse(date);
		 
	  
		
		 ProjetFE proj = new ProjetFE(id, nom, Discr, dt);
		 
		
		 
		 
		if(ProjetFEDAO.add(proj, idprf))
					listProject(request, response);
	            else
						response.sendRedirect("form_project.jsp");
		 
		
		
	}
	private void listProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get students from db util
				List<ProjetFE> prf = ProjetFEDAO.getAll();
				
			
				
				// add students to the request
			
					
					request.setAttribute("proj", prf);
					
					// send to JSP page (view)
					RequestDispatcher dispatcher = request.getRequestDispatcher("tables-listpro.jsp");
					dispatcher.forward(request, response);
			
					
				
				
		
	}
	
}
