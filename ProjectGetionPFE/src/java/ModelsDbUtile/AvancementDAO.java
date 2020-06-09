package ModelsDbUtile;

import java.sql.*;
import java.util.ArrayList;

import Models.*;

public class AvancementDAO {
	public static Avancement getByID(int id) {
		Avancement avan = null;
		
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from avancement a,task t where a.TaskID = t.ID  and a.ID = ? ");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				avan = new Avancement(rs.getInt(1), rs.getInt(4),rs.getInt(5), rs.getDate(6));
				avan.setEtudiant(EtudiantDAO.getByID(rs.getInt(2)));
				avan.setTask(new Task(rs.getInt(7), rs.getString(9),rs.getDate(10), rs.getDate(11)));
			}
			return avan;
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	
	}
	public static ArrayList<Avancement> getAll(){
		
		ArrayList<Avancement> avan = new ArrayList<Avancement>();
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("select * from avancement a,task t where a.TaskID = t.ID  and a.ID");
	
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Avancement avancnt = new Avancement(rs.getInt(1), rs.getInt(4),rs.getInt(5), rs.getDate(6));
				avancnt.setEtudiant(EtudiantDAO.getByID(rs.getInt(3)));
				avancnt.setTask(new Task(rs.getInt(7), rs.getString(9),rs.getDate(10), rs.getDate(11)));
				avan.add(avancnt);
			}
			return avan;
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	public static boolean Add(Avancement av,int etd, int t) {
		try {
			PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `avancement`(`ID`, `TaskID`, `EtudiantID`, `Le_temps_passé_a_la_semain_sur_Task`, `Le_temps_restant_estimé_à_la_semaine_sur_Task`, `Date`) VALUES (?,?,?,?,?,?)");
			stp.setInt(1,av.getIdAvancement());
			stp.setInt(2, t);
			stp.setInt(3, etd);
			stp.setInt(4, av.getTpst());
			stp.setInt(5, av.getTrst());
			stp.setDate(6, new java.sql.Date(av.getDate().getTime()));
			stp.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
			
	}
	public static boolean delete(Avancement av) {
		try {
			PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `avancement` WHERE ID = ?");
			
			stp.setInt(1,av.getIdAvancement());
			
			stp.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
	public static boolean updat(Avancement newAvan, Avancement lassAvan,int idetd, int tsk) {
		try {
			PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("UPDATE `avancement` SET `TaskID`=?,`EtudiantID`=?,`Le_temps_passé_a_la_semain_sur_Task`=?,`Le_temps_restant_estimé_à_la_semaine_sur_Task`=?,`Date`=? WHERE ID = ?");
			stp.setInt(6,lassAvan.getIdAvancement());
			stp.setInt(2, idetd);
			stp.setInt(1, tsk);
			stp.setInt(3, newAvan.getTpst());
			stp.setInt(3, newAvan.getTrst());
			stp.setDate(3, new java.sql.Date(newAvan.getDate().getTime()));
			stp.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
		
		
		
	}
public static void main(String Arg[]) {
	System.out.println(getAll());
}
	
}
