package ModelsDbUtile;

import java.sql.*;

import java.util.*;


import Models.*;

public class SoutenanceDAO {

	public static boolean AddEtudiant(Soutenance stn,Rapport rp,Jury jr){
		   
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `soutenance`(`ID`, `RapportID`, `JuryID2`, `Note`, `Date`) VALUES (?,?,?,?,?)");
			st.setInt(1, stn.getIdSoutenance());
			st.setInt(2,rp.getIdRapport());
			st.setInt(3,jr.getIdjury());
			st.setDouble(4,stn.getNote());
			st.setDate(5,new java.sql.Date(stn.getDate().getTime()));
			
			return true;
		} catch (SQLException e2) {
			return false;
		}
	}
	public static Soutenance getByID(int id) {
		Soutenance sout = null;
	
		
		try {
			PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `soutenance` WHERE ID = ?");
			stm.setInt(1,id);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				sout = new Soutenance(rs.getInt(1), rs.getDouble(4), rs.getDate(5));
				sout.setRapport(RapportDAO.getById(rs.getInt(2)));
				sout.setJury(JuryDAO.getByID(rs.getInt(3)));
			 
			}
			
			return sout;
			
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	public static ArrayList<Soutenance> getAll(){
		
		ArrayList<Soutenance> arraysout = new ArrayList<Soutenance>(); 
		try {
		PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `soutenance`");

		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
		 Soutenance sout = new Soutenance(rs.getInt(1), rs.getDouble(4), rs.getDate(4));
			sout.setRapport(RapportDAO.getById(rs.getInt(2)));
			sout.setJury(JuryDAO.getByID(rs.getInt(3)));
			arraysout.add(sout);
		 
		}
			
	return arraysout;
	 
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
}
		
	public static boolean Update(Soutenance soutNew,Soutenance soutlass,Rapport rp,Jury j) {
		
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `soutenance` SET `RapportID`=?,`JuryID2`=?,`Note`=?,`Date`=? WHERE `ID`=?");
			st.setInt(1, rp.getIdRapport());
			st.setInt(2,j.getIdjury());
			st.setDouble(3,soutNew.getNote());
			st.setDate(4,new java.sql.Date(soutNew.getDate().getTime()));
			st.setInt(5,soutlass.getIdSoutenance());
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
	public static boolean delete(Soutenance sout){
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `soutenance` WHERE ID = ?");
			
			st.setInt(1,sout.getIdSoutenance());
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}
	public static void main(String Args[]) {
		
		System.out.println(getByID(1));
			
		}

	
}
