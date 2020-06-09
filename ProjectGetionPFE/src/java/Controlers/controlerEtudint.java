package Controlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.*;

import ModelsDbUtile.*;

/**
 * Servlet implementation class controlerEtudint
 */
public class controlerEtudint extends HttpServlet {
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
				listEtudiant(request, response);
				break;
				
			case 2:
				addEtudiant(request, response);
				break;
		    case 3:
		    	deletEtudiant(request, response);
		    	break;
		    case 4:
		    	updarEtudiant(request, response);
		    case 5:
		    	addProjectToEtudiant(request, response);

			default:
				listEtudiant(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
		
	}

	private void addProjectToEtudiant(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id  =  Integer.parseInt(request.getParameter("idetdM"));
		int idproj  =  Integer.parseInt(request.getParameter("project"));
		
		 
		 String nom = request.getParameter("nometd");
		 String prenom = request.getParameter("prenometd");
		 String cne = request.getParameter("cneetd");
		 String branch = request.getParameter("branchetd");
		  
		 Etudiant etdNew = new Etudiant(id, nom, prenom, branch, cne);
		 HttpSession session = request.getSession();
		
		 
		 session.setAttribute("prof", ProfesseurDAO.getById(idproj));
		 EtudiantDAO.Update(etdNew, etdNew, idproj);
		              	

				
				// send to JSP page (view)
		response.sendRedirect("tables-listpro.jsp");
		
		
	}

	private void updarEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id  =  Integer.parseInt(request.getParameter("idetdM"));
		 
		
		 
		 String nom = request.getParameter("nometd");
		 String prenom = request.getParameter("prenometd");
		 String cne = request.getParameter("cne");
		 String branch = request.getParameter("brnch");
		  
		 Etudiant etdNew = new Etudiant(id, nom, prenom, branch, cne);
		
		 
		 
		 EtudiantDAO.Update(etdNew, etdNew, 0);
		              	

				
				// send to JSP page (view)
		response.sendRedirect("tables-etd.jsp");
		
	
		
				
				
        
			   
	}

	private void deletEtudiant(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id  =  Integer.parseInt(request.getParameter("iddeleted"));
		
		EtudiantDAO.delete(EtudiantDAO.getByID(id));
		
		listEtudiant(request, response);
		
		
	}
	private void addEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 int id  =  Integer.parseInt(request.getParameter("id"));
		 
	
		 
		 String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String cin = request.getParameter("cin");
		 String branch = request.getParameter("brnch");
	  
		
		 Etudiant etd1 = new Etudiant(id, nom, prenom, branch, cin);
		 
		
		 
		 
		if(EtudiantDAO.AddEtudiant(etd1, 0))
					listEtudiant(request, response);
	            else
					response.sendRedirect("forms-etd.jsp");
		 
		
		
	}
	private void listEtudiant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get students from db util
				List<Etudiant> prf = EtudiantDAO.getAll();
			
				
				// add students to the request
			
					
					request.setAttribute("etd", prf);
					
					// send to JSP page (view)
					RequestDispatcher dispatcher = request.getRequestDispatcher("tables-etd.jsp");
					dispatcher.forward(request, response);
			
					
				
				
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int theCommand = Integer.parseInt(request.getParameter("command"));
		if(theCommand == 1)
		    	updarEtudiant(request, response);
		if(theCommand == 2) 
			  deletEtudiant(request, response);
		if(theCommand == 3) 
			  addProjectToEtudiant(request, response);
	}
	
}
