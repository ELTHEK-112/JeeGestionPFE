package ModelsDbUtile;

import java.sql.*;

import java.util.*;

import Models.*;

public class RapportDAO {
public static Rapport getById(int id){
	
	
	Rapport rappor = null;
	try {
		PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `rapport` r,ProjetFE p  , soutenance s WHERE r.ProjetFEID = p.ID  and s.RapportID = r.ID and r.ID = ? ");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			rappor= new Rapport(rs.getInt(1), rs.getDate(3));
			rappor.setProjetFE(ProjetFEDAO.getById(rs.getInt(4)));
		
			rappor.setSoutenans(new Soutenance(rs.getInt(9), rs.getDouble(12),rs.getDate(13)));
		}
		return rappor;
		
	} catch (SQLException e) {
		e.getMessage();
		return null;
	}	
}
public static ArrayList<Rapport> getAll(){
	ArrayList<Rapport> arrayRapp = new ArrayList<Rapport>();
	try {
		PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `rapport` r,ProjetFE p ,soutenance s WHERE r.ProjetFEID = p.ID and s.RapportID = r.ID ");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			Rapport  rappor= new Rapport(rs.getInt(1), rs.getDate(3));
			rappor.setProjetFE(ProjetFEDAO.getById(rs.getInt(4)));
			
			rappor.setSoutenans(new Soutenance(rs.getInt(9), rs.getDouble(12),rs.getDate(13)));
			arrayRapp.add(rappor);
		}
		return arrayRapp;
		
	} catch (SQLException e) {
		e.getMessage();
		return null;
	}	
	
}
public static boolean add(Rapport rp ,ProjetFE p , Phase ph) {
	try {
		PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `rapport`(`ID`, `ProjetFEID`, `phaseID`, `Date`) VALUES (?,?,?,?)");
		stp.setInt(1,rp.getIdRapport());
		stp.setInt(2, p.getIdProjetFE());
		stp.setInt(3, ph.getIdPhase());
		stp.setDate(4, new java.sql.Date(rp.getDate().getTime()));
		stp.executeUpdate();
		return true;
	} catch (SQLException e) {
		e.getMessage();
		return false;
	}
	
	
}
public static boolean delete(Rapport rp) {
	try {
		PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `rapport` WHERE ID = ?");
		
		stp.setInt(1,rp.getIdRapport());
		
		stp.executeUpdate();
		return true;
	} catch (SQLException e) {
		e.getMessage();
		return false;
	}
}
public static boolean updat(Rapport newRp, Rapport lassRp, ProjetFE prj) {
	try {
		PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("UPDATE `rapport` SET `ProjetFEID`=?,`Date`=? WHERE ID = ?");
		stp.setInt(4,lassRp.getIdRapport());
		stp.setInt(1, prj.getIdProjetFE());
		stp.setDate(2, new java.sql.Date(newRp.getDate().getTime()));
		stp.executeUpdate();
		return true;
	} catch (SQLException e) {
		e.getMessage();
		return false;
	}
	
	
	
}

public static void main(String Args[]) {
	
	System.out.println(getAll().get(0).getProjetFE().getEtudiant());
		
	}

	
}
