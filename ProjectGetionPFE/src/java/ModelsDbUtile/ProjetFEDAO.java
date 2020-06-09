package ModelsDbUtile;
import Models.*;

import java.util.*;

import java.sql.*;

public class ProjetFEDAO {
	public static ProjetFE getById(int id) {
		ProjetFE projet = null;
		Professeur professeur = null;
		ArrayList<Etudiant> lesetudiant = new ArrayList<Etudiant>();
		ArrayList<Rapport> lesrapport = new ArrayList<Rapport>();
		ArrayList<Phase> lesphase = new ArrayList<Phase>();
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `projetfe` WHERE `ID` = ?");
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
			 projet = new ProjetFE(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
			}
			
			
			
			Statement stm3 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs2 = stm3.executeQuery("SELECT * FROM professeur p , ProjetFE pr WHERE p.ID = pr.professerurID and  pr.ID = '"+ projet.getIdProjetFE() +"'");
			while(rs2.next())   professeur = new Professeur(rs2.getInt(1), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6));
			
			Statement stm4 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs3 = stm4.executeQuery("SELECT * FROM `etudiant`e, projetfe p WHERE e.ProjetFEID = p.ID and p.ID = '"+ projet.getIdProjetFE() +"'");
			while(rs3.next()) lesetudiant.add(new Etudiant(rs3.getInt(1), rs3.getString(3), rs3.getString(4), rs3.getString(5), rs3.getString(6)));
			
			Statement stm5 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs4 = stm5.executeQuery("SELECT * FROM `rapport`  WHERE ProjetFEID = '"+ projet.getIdProjetFE() +"'");
			while(rs4.next()) lesrapport.add(new Rapport(rs4.getInt(1),rs4.getDate(3)));
			
			Statement stm6 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs5 = stm6.executeQuery("SELECT * FROM `phase` WHERE ProjetFEID = '"+ projet.getIdProjetFE() +"'");
			while(rs5.next()) lesphase.add(new Phase(rs5.getInt(1),rs5.getString(3),rs5.getDate(4),rs5.getDate(5)));
			
			projet.setEtudiant(lesetudiant);
			projet.setProfesseur(professeur);
			projet.setRapport(lesrapport);
			projet.setPhase(lesphase);
			
			
			
			return projet;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}
	public static ArrayList<ProjetFE> getAll() {
		ArrayList<ProjetFE>  projet = new ArrayList<ProjetFE>();
		
	
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `projetfe`");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
			 projet.add(new ProjetFE(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
			}
			
			for (int i = 0; i < projet.size(); i++) {
				Statement stm3 = SingleConnection.getDbConnction().createStatement();
				ResultSet rs2 = stm3.executeQuery("SELECT * FROM professeur p , ProjetFE pr WHERE p.ID = pr.professerurID and  pr.ID = '"+ projet.get(i).getIdProjetFE() +"'");
				while(rs2.next()) {
					
					projet.get(i).setProfesseur(new Professeur(rs2.getInt(1), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6)));
				}}
			
			
			for (int i = 0; i < projet.size(); i++) {
			Statement stm4 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs3 = stm4.executeQuery("SELECT * FROM `etudiant`, projetfe WHERE ProjetFEID = '"+ projet.get(i).getIdProjetFE() +"'");
			while(rs3.next()) { 
				ArrayList<Etudiant> lesetudiant = new ArrayList<Etudiant>();
				
				lesetudiant.add(new Etudiant(rs3.getInt(1), rs3.getString(3), rs3.getString(4), rs3.getString(5), rs3.getString(6)));
				projet.get(i).setEtudiant(lesetudiant);
				
			}}
			
			for (int i = 0; i < projet.size(); i++) {
			Statement stm5 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs4 = stm5.executeQuery("SELECT * FROM `rapport` WHERE ProjetFEID = '"+ projet.get(i).getIdProjetFE() +"'");
			while(rs4.next()) {
				
				ArrayList<Rapport> lesrapport = new ArrayList<Rapport>();
				
				lesrapport.add(new Rapport(rs4.getInt(1),rs4.getDate(3)));
				
				projet.get(i).setRapport(lesrapport);
			}}
			for (int i = 0; i < projet.size(); i++) {
			Statement stm6 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs5 = stm6.executeQuery("SELECT * FROM `phase` WHERE ProjetFEID = '"+ projet.get(i).getIdProjetFE() +"'");
			while(rs5.next()) {
				
				ArrayList<Phase> lesphase = new ArrayList<Phase>();
				lesphase.add(new Phase(rs5.getInt(1),rs5.getString(3),rs5.getDate(4),rs5.getDate(5)));
				projet.get(i).setPhase(lesphase);
				
			}}
			
			
			return projet;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}
	public static boolean add(ProjetFE p1,int Inprof) {
		  
		  try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `projetfe`(`ID`, `Nom`, `Description`, `Date_de_livraison_du_projet`,professerurID) VALUES (?,?,?,?,?)");
			st.setInt(1,p1.getIdProjetFE());
			st.setString(2,p1.getNom());
			st.setString(3,p1.getDescription());
			st.setDate(4,new java.sql.Date(p1.getDate_de_livraison_du_projet().getTime()));
			st.setInt(5, Inprof);
			
			st.executeUpdate();
			return true;


		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
		  
	}
	public static boolean updat(ProjetFE newpro, ProjetFE  lasspro,int idpof) {
		try {
			PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("UPDATE `projetfe` SET `Nom`=?,`Description`=?,`Date_de_livraison_du_projet`=? , professerurID = ? WHERE ID = ?");
			stp.setInt(5,lasspro.getIdProjetFE());
			stp.setString(1, newpro.getNom());
			stp.setString(2, newpro.getDescription());
			stp.setDate(3, new java.sql.Date(newpro.getDate_de_livraison_du_projet().getTime()));
			stp.setInt(4, idpof);
			stp.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
	public static boolean delete(ProjetFE av) {
		try {
			PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `projetfe` WHERE ID = ?");
			
			stp.setInt(1,av.getIdProjetFE());
			
			stp.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
		
	public static void main(String Args[]) {
		
	System.out.println(getById(1));
		
	}

		
	}

	
	

