package ModelsDbUtile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Models.*;

public class JuryDAO {
	

	public static boolean AddEtudiant(Jury jur){
		   
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `jury`(`ID2`, `NUMBER`) VALUES (?,?)");
			st.setInt(1, jur.getIdjury());
			st.setString(2, jur.getNom());
			
			return true;
		} catch (SQLException e2) {
			return false;
		}
	}
	
	public static Jury getByID(int id) {
		Jury jyr = null;

		ArrayList<Professeur> lesprofesseur = new ArrayList<Professeur>();
		ArrayList<Soutenance> lesSoutenance = new ArrayList<Soutenance>();
	
		
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `jury` WHERE ID2 = ?");
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) 
				jyr = new Jury(rs.getInt(1),rs.getString(2),rs.getString(3));
			
			Statement stm1 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs0 = stm1.executeQuery("SELECT * FROM `soutenance` s,Jury j WHERE j.ID2 = s.JuryID2 and s.ID= '"+ jyr.getIdjury() +"'");
			while(rs0.next()) 
				lesSoutenance.add(new Soutenance(rs0.getInt(1), rs0.getDouble(4), rs0.getDate(5)));
			
			Statement stm2 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs1 = stm2.executeQuery("SELECT * FROM `professeur` WHERE JuryID2 = '"+ jyr.getIdjury() +"'");
			while(rs1.next()) 
				lesprofesseur.add(ProfesseurDAO.getById(rs1.getInt(1)));
			
			jyr.setProfesseur(lesprofesseur);
			jyr.setSoutenance(lesSoutenance);
			
			return jyr;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	public static ArrayList<Jury> getAll(){
		
		ArrayList<Jury> jr=new ArrayList<Jury>();
		
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `jury`");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				 Jury jyr = new Jury(rs.getInt(1),rs.getString(2),rs.getString(3));
				 jr.add(jyr);
			
			}
			for (int i = 0; i < jr.size(); i++) {
				
				Statement stm1 = SingleConnection.getDbConnction().createStatement();
				ResultSet rs0 = stm1.executeQuery("SELECT * FROM `soutenance` WHERE JuryID2 = '"+ jr.get(i).getIdjury() +"'");
				while(rs0.next()) {
					ArrayList<Soutenance> lesSoutenance = new ArrayList<Soutenance>();
					lesSoutenance.add(SoutenanceDAO.getByID(rs0.getInt(1)));
					jr.get(i).setSoutenance(lesSoutenance);
				}
			}
			for (int i = 0; i < jr.size(); i++) {
				Statement stm2 = SingleConnection.getDbConnction().createStatement();
				ResultSet rs1 = stm2.executeQuery("SELECT * FROM `professeur` WHERE JuryID2 = '"+ jr.get(i).getIdjury() +"'");
				while(rs1.next()) {
					ArrayList<Professeur> lesprofesseur = new ArrayList<Professeur>();
				    lesprofesseur.add(ProfesseurDAO.getById(rs1.getInt(1)));
				    jr.get(i).setProfesseur(lesprofesseur);
				}
			}
			
			

			
			
	return jr;
	 
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}	
	}
		
		
public static boolean Update(Jury jurNew,Jury jurylass) {
		
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `Jury` SET `Nomber`=? WHERE `ID2`=?");
			st.setInt(1, jurNew.getIdjury());
			st.setInt(2, jurylass.getIdjury());
			
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
	public static boolean delete(Jury sout){
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `Jury` WHERE ID = ?");
			
			st.setInt(1,sout.getIdjury());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}
	
public static void main(String Args[]) {
	
		System.out.println(getAll().get(0).getProfesseur());
	}
}
