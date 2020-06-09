package Controlers;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.*;

import ModelsDbUtile.*;

/**
 * Servlet implementation class LoginControler
 */
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		int test = Integer.parseInt(request.getParameter("cat"));
		
		String nom = request.getParameter("nom");
		
	     PrintWriter out = response.getWriter();
	     HttpSession session = request.getSession(); 
		
	     switch (test) {
			case 1:    
				ResultSet rs = SingleConnection.readQury("select * from professeur where ID = '"+id+" '  and Nom like '"+ nom +"%'" );
			try {
				if(!rs.isBeforeFirst()) {
				   
				   
					   out.println("<script type='text/javascript' src='assets/js/jquery.min.js'></script>");
					   out.println("<script type='text/javascript'>");
					   out.println("$(document).ready( function() {");
					   out.println("alert('le nom au le id est incorrecte');");
					   out.println(" });");
					   out.println("</script>");
					   RequestDispatcher re = request.getRequestDispatcher("login.jsp");
	    	    	   re.include(request, response);
				   
				  }else {
					   Professeur pro = ProfesseurDAO.getById(id);
					   session.setAttribute("prof", pro);
					   response.sendRedirect("indexProf.jsp");
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case 2:
				ResultSet rs1 = SingleConnection.readQury("select * from admin where ID = '"+id+" '  and Nom like '"+ nom +"%'" );
				try {
					if(!rs1.isBeforeFirst()) {

						   out.println("<script type='text/javascript' src='assets/js/jquery.min.js'></script>");
						   out.println("<script type='text/javascript'>");
						   out.println("$(document).ready( function() {");
						   out.println("alert('le nom au le id est incorrecte');");
						   out.println(" });");
						   out.println("</script>");
						   RequestDispatcher re = request.getRequestDispatcher("login.jsp");
		    	    	   re.include(request, response);
					   
					  }else {
						   response.sendRedirect("indexAdmin.jsp");
					  }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   
				break;

			case 3:
				ResultSet rs2 = SingleConnection.readQury("select * from etudiant where ID = '"+id+" '  and Nom like '"+ nom +"%'" );
				try {
					if(!rs2.isBeforeFirst()) {
					   
					    
						   out.println("<script type='text/javascript' src='assets/js/jquery.min.js'></script>");
						   out.println("<script type='text/javascript'>");
						   out.println("$(document).ready( function() {");
						   out.println("alert('le nom au le id est incorrecte');");
						   out.println(" });");
						   out.println("</script>");
						   RequestDispatcher re = request.getRequestDispatcher("login.jsp");
		    	    	   re.include(request, response);
					   
					  }else {
						  Etudiant etd;
						  if(EtudiantDAO.getByIDwhiteProject(id) == null)
						       etd = EtudiantDAO.getByID(id);
						  else
							etd = EtudiantDAO.getByIDwhiteProject(id);
						    
						   session.setAttribute("etd", etd);
						   response.sendRedirect("indexEtudiant.jsp");
					  }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			}
	}

	

}
