package Controlers;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.*;

import ModelsDbUtile.*;

/**
 * Servlet implementation class profcontroler
 */
public class profcontroler extends HttpServlet {
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
				listProf(request, response);
				break;
				
			case 2:
				addProf(request, response);
				break;
		    case 3:
		    	deletProf(request,response);
		    	break;
		    case 4:
		    	updarProf(request,response);
		    	break;

			default:
				listProf(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	}

	private void updarProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id  =  Integer.parseInt(request.getParameter("id"));
		 String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String cin = request.getParameter("cin");
		 String branch = request.getParameter("brnch");
		
		 Professeur p1 = new Professeur(id, nom, prenom, branch, cin);
		 
		 if(ProfesseurDAO.update(p1, p1, 0)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("tables-prof.jsp");
				dispatcher.forward(request, response);
		
		 }else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("tables-prof.jsp");
				dispatcher.forward(request, response);
		
		 }
		
		
		
	}

	private void deletProf(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
int id  =  Integer.parseInt(request.getParameter("iddeleted"));
		
	if(	ProfesseurDAO.delete(id)) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("tables-prof.jsp");
		dispatcher.forward(request, response);
		
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("tables-prof.jsp");
		dispatcher.forward(request, response);
	}
		
		
	}
	private void addProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 int id  =  Integer.parseInt(request.getParameter("id"));
		 
		 
		 Professeur rs;
		 try {
			rs = ProfesseurDAO.getById(id);
		} catch (Exception e) {
			rs = null;
		}
		 
		 String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String cin = request.getParameter("cin");
		 String branch = request.getParameter("brnch");
	  
		 if(rs==null) {
		 Professeur p1 = new Professeur(id, nom, prenom, branch, cin);
		 
		 
		 
		 ProfesseurDAO.add(p1, 0);
		    
		 
		 listProf(request, response);
		 
		 }else {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/forms_prof.jsp");
				dispatcher.forward(request, response);
		
		 }
		
	}
	private void listProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get students from db util
				List<Professeur> prf = ProfesseurDAO.getAll();
			
				
				// add students to the request
			
					
					request.setAttribute("prof", prf);
					
					// send to JSP page (view)
					RequestDispatcher dispatcher = request.getRequestDispatcher("tables-prof.jsp");
					dispatcher.forward(request, response);
			
					
				
				
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int theCommand = Integer.parseInt(request.getParameter("command"));
		if(theCommand == 1)
			updarProf(request, response);
		if(theCommand == 2) 
			deletProf(request, response);
		if(theCommand == 3) 
			  addprofToJury(request, response);
	}

	private void addprofToJury(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id  =  Integer.parseInt(request.getParameter("idprofM"));
		 int idjur  =  Integer.parseInt(request.getParameter("jury"));
		 
		 Professeur p = ProfesseurDAO.getById(id);
		 if(ProfesseurDAO.update(p, p, idjur)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("tables-prof.jsp");
				dispatcher.forward(request, response);
		
		 }else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("tables-prof.jsp");
				dispatcher.forward(request, response);
		
		 }
		
	}
	
}
