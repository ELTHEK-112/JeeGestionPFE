package ModelsDbUtile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.*;



public class phaseDAO {
	public static Phase getById(int id) {
		Phase pas = null;
		ArrayList<Task> lesTask = new ArrayList<Task>();
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `phase` ph, projetfe p WHERE ph.`ProjetFEID` = p.ID and ph.ID = ?");
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				pas = new Phase(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getDate(5));
				pas.setProjetFE(new ProjetFE(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getDate(9)));
			}
			
			Statement stm3 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs2 = stm3.executeQuery("SELECT * FROM `task` WHERE `phaseID` ='"+ pas.getIdPhase() +"'");
			while(rs2.next()) lesTask.add(new Task(rs2.getInt(1), rs2.getString(3), rs2.getDate(4), rs2.getDate(5)));
			
			
			pas.setLesTask(lesTask);
			
			
			
			return pas;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}
	public static ArrayList<Phase> getAll(){
		
		ArrayList<Phase> lesPhase = new ArrayList<Phase >();
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `phase` ph, projetfe p WHERE ph.`ProjetFEID` = p.ID ");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Phase pas = new Phase(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getDate(5));
				
				pas.setProjetFE(new ProjetFE(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getDate(9)));
				lesPhase.add(pas);
			}
			for (int i = 0; i < lesPhase.size(); i++) {
				Statement stm3 = SingleConnection.getDbConnction().createStatement();
				ResultSet rs2 = stm3.executeQuery("SELECT * FROM `task` WHERE `phaseID` ='"+ lesPhase.get(i).getIdPhase() +"'");
				while(rs2.next()) {
					ArrayList<Task> lesTask = new ArrayList<Task>();
					lesTask.add(new Task(rs2.getInt(1), rs2.getString(3), rs2.getDate(4), rs2.getDate(5)));
					lesPhase.get(i).setLesTask(lesTask);
				}
				
			}
						
			return lesPhase;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
		
	}
	public static boolean add(Phase pas , int idproj) {
		 
		  try {
			  
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `phase`(`ID`, `ProjetFEID`, `Nom`, `DateStar`, `DateFin`) VALUES (?,?,?,?,?)");
			st.setInt(2,idproj);
			st.setInt(1,pas.getIdPhase());
			st.setString(3,pas.getNom());
			st.setDate(4,new java.sql.Date(pas.getDateStar().getTime()));
			st.setDate(5,new java.sql.Date(pas.getDateFin().getTime()));
			st.executeUpdate();
			return true;


		} catch (SQLException e) {
			e.getMessage();
			return false;
		}			
	}
	public static boolean update(Phase lasspas ,Phase newpas , ProjetFE proj) {
		 try {
			  
				PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `phase` SET `ProjetFEID`=?,`Nom`=?,`DateStar`=?,`DateFin`=? WHERE ID = ?");
				
				st.setInt(1,proj.getIdProjetFE());
				st.setInt(5,lasspas.getIdPhase());
				st.setString(2,newpas.getNom());
				st.setDate(3,new java.sql.Date(newpas.getDateStar().getTime()));
				st.setDate(4,new java.sql.Date(newpas.getDateFin().getTime()));
				st.executeUpdate();
				
				return true;


			} catch (SQLException e) {
				e.getMessage();
				return false;
			}		
	}
	public static boolean delete(Phase pas) {
		
		try {
			PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `phase`  WHERE ID = ?");
			
			stp.setInt(1,pas.getIdPhase());
			
			stp.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
	public static void main(String Arg[]) {
		
			System.out.println(getById(3));
		
	}
}
