package ModelsDbUtile;

import Models.*;



import java.sql.*;
import java.util.ArrayList;


public class EtudiantDAO {
    
	
	public static boolean AddEtudiant(Etudiant E,int idpfe){
		   
		try {
			Statement st = SingleConnection.getDbConnction().createStatement();
			st.executeUpdate("INSERT INTO `etudiant`(`ID`, `ProjetFEID`, `Nom`, `Prenom`, `Branch`, `Cne`) VALUES ('"+ E.getIdEtudiant() + "','"+idpfe+"','"+E.getNom()+"','"+E.getPrenom()+"','"+E.getBranch()+"','"+E.getCne()+"')");
			return true;
		} catch (SQLException e2) {
			return false;
		}
	}
	public static Etudiant getByIDwhiteProject(int id) {
		Etudiant etd = null;
		ProjetFE project = null;
	
		ArrayList<Etudiant> lesetudiant =  new ArrayList<Etudiant>();
		ArrayList<Rapport> lesrapport= new ArrayList<Rapport>();
		ArrayList<Phase> lesphase = new ArrayList<Phase>();
		ArrayList<Avancement> lesAvancements = new ArrayList<Avancement>();
	
		
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("select * from etudiant e,projetfe p where e.ProjetFEID = p.ID  and e.ID = ?");
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
			etd = new Etudiant(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			
			 project = new ProjetFE(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getDate(10));
			}
			Statement stm1 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs0 = stm1.executeQuery("SELECT * FROM `avancement` where EtudiantID = '"+ etd.getIdEtudiant() +"'");
			while(rs0.next()) lesAvancements.add(new Avancement(rs0.getInt(1), rs0.getInt(4), rs0.getInt(5), rs0.getDate(6)));
			
			etd.setAvancement(lesAvancements);
			
			
			Statement stm3 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs2 = stm3.executeQuery("SELECT * FROM professeur p , ProjetFE pr WHERE p.ID = pr.professerurID and  pr.ID = '"+ project.getIdProjetFE() +"'");
			while(rs2.next()) project.setProfesseur(new Professeur(rs2.getInt(1), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6)));
			
			Statement stm4 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs3 = stm4.executeQuery("SELECT * FROM `etudiant`, projetfe WHERE  ProjetFEID = '"+ project.getIdProjetFE() +"'");
			while(rs3.next()) lesetudiant.add(new Etudiant(rs3.getInt(1), rs3.getString(3), rs3.getString(4), rs3.getString(5), rs3.getString(6)));
			
			Statement stm5 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs4 = stm5.executeQuery("SELECT * FROM `rapport` WHERE ProjetFEID = '"+ project.getIdProjetFE() +"'");
			while(rs4.next()) lesrapport.add(new Rapport(rs4.getInt(1),rs4.getDate(4)));
			
			Statement stm6 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs5 = stm6.executeQuery("SELECT * FROM `phase` WHERE ProjetFEID = '"+ project.getIdProjetFE() +"'");
			while(rs5.next()) lesphase.add(new Phase(rs5.getInt(1),rs5.getString(3),rs5.getDate(4),rs5.getDate(5)));
			
			project.setEtudiant(lesetudiant);
		
			project.setPhase(lesphase);
			
			etd.setProjetFE(project);
			
			return etd;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	public static Etudiant getByID(int id) {
		Etudiant etd = null;
		
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("select * from etudiant e where ID = ?");
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
			etd = new Etudiant(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			
			}
			
			
			return etd;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	public static ArrayList<Etudiant> getAllwhteProject(){
		
		ArrayList<ProjetFE> arrayProjt = new ArrayList<ProjetFE>(); 
		ArrayList<Etudiant> ArryEtdout = new ArrayList<Etudiant>();
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from etudiant e,projetfe p where e.ProjetFEID = p.ID");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				ArryEtdout.add(new Etudiant(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			
				arrayProjt.add(new ProjetFE(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getDate(10)));
			}
			for (int i = 0; i < ArryEtdout.size(); i++) {
				for (int j = 0; j < arrayProjt.size(); j++) {
					
					ArryEtdout.get(i).setProjetFE(arrayProjt.get(j));
				
				}
			}
			
			
	return ArryEtdout;
	 
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}	
	}
public static ArrayList<Etudiant> getAll(){
		
		
		ArrayList<Etudiant> ArryEtdout = new ArrayList<Etudiant>();
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from etudiant");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				ArryEtdout.add(new Etudiant(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
	return ArryEtdout;
	 
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}	
	}
	public static boolean Update(Etudiant etdNew,Etudiant etdlass,int idproj) {
		
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `etudiant` SET `ProjetFEID`=?,`Nom`=?,`Prenom`=?,`Branch`=?,`Cne`=? WHERE ID = ?");
			st.setInt(1, idproj);
			st.setString(2,etdNew.getNom());
			st.setString(3,etdNew.getPrenom());
			st.setString(4,etdNew.getBranch());
			st.setString(5,etdNew.getCne());
			st.setInt(6,etdlass.getIdEtudiant());
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
	public static boolean delete(Etudiant etd){
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `etudiant` WHERE ID = ?");
			
			st.setInt(1,etd.getIdEtudiant());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}
	public static void main(String ar[]) {
		
		System.out.println(Update(getByID(24), getByID(25), 0));
		
		
		
	}
			
}
