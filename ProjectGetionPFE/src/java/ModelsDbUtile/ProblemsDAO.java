package ModelsDbUtile;

import java.sql.*;
import java.util.*;

import Models.*;

public class ProblemsDAO {

	public static Problems getById(int id) {
		Problems ppm = null;
		
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `problems` WHERE ID = ?");
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				ppm = new Problems(rs.getInt(1), rs.getString(3), rs.getDate(4));
				ppm.setTask(TaskDAO.getById(rs.getInt(2)));
			}
				
			return ppm;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}
	public static ArrayList<Problems> getAll(){
		
		ArrayList<Problems> lesProblems = new ArrayList<Problems>();
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `problems`");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Problems ppm = new Problems(rs.getInt(1), rs.getString(3), rs.getDate(4));
				ppm.setTask(TaskDAO.getById(rs.getInt(2)));
				lesProblems.add(ppm);
			}
				
			return lesProblems;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
		
		
	}
	public static boolean add(Problems pas , Task tsk) {
		 
		  try {
			  
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `problems`(`ID`, `TaskID`, `Description`, `Date`) VALUES (?,?,?,?)");
			st.setInt(1,pas.getIdProblems());
			st.setInt(2,tsk.getIdTask());
			st.setString(3,pas.getDescription());
			st.setDate(4,new java.sql.Date(pas.getDate().getTime()));
			st.executeUpdate();
			return true;


		} catch (SQLException e) {
			e.getMessage();
			return false;
		}			
	}
	public static boolean update(Problems lasspas ,Problems newpas , Task tsk) {
		 try {
			  
				PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `problems` SET `TaskID`=?,`Description`=?,`Date`=? WHERE `ID`=?");
				
				st.setInt(1,tsk.getIdTask());
				st.setInt(4,lasspas.getIdProblems());
				st.setString(2,newpas.getDescription());
				st.setDate(3,new java.sql.Date(newpas.getDate().getTime()));
				st.executeUpdate();
				
				return true;


			} catch (SQLException e) {
				e.getMessage();
				return false;
			}		
	}
	public static boolean delete(Problems pas) {
		
		try {
			PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `problems`  WHERE ID = ?");
			
			stp.setInt(1,pas.getIdProblems());
			
			stp.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
public static void main(String arg[]){
	
	
	System.out.println(getAll());	
	}
}
