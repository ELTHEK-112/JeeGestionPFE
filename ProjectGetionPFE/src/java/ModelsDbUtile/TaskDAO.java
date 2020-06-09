package ModelsDbUtile;

import java.sql.*;
import java.util.*;

import Models.*;


public class TaskDAO {
public static Task getById(int id) {
	Task ts1 = null; 
	ArrayList<Avancement> lesavancement = new ArrayList<Avancement>();
	ArrayList<Problems> lesproblems = new ArrayList<Problems>();
	try {
		PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `task` where ID = ?");
		stm.setInt(1,id);
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			ts1 = new Task(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getDate(5));
			ts1.setPhase(phaseDAO.getById(rs.getInt(2)));
		}
		
		Statement stm3 = SingleConnection.getDbConnction().createStatement();
		ResultSet rs2 = stm3.executeQuery("SELECT * FROM `avancement` a, task t , problems p WHERE a.TaskID = t.ID and t.ID = p.TaskID and t.ID = '"+id+"'");
		while(rs2.next()) {
			lesavancement.add(AvancementDAO.getByID(rs2.getInt(1)));
			lesproblems.add(new Problems(rs2.getInt(12), rs2.getString(14), rs2.getDate(15)));
		}
		
		
		ts1.setAvancement(lesavancement);
		ts1.setProblems(lesproblems);
		
		
		return ts1;
		
		
	} catch (SQLException e) {
		e.getMessage();
		return null;
	}
	
}
public static ArrayList<Task> getAll(){
	
	ArrayList<Task > lestask = new ArrayList<Task >();
	
	try {
		PreparedStatement stm = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `task`");
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			Task ts =  new Task(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getDate(5));
			ts.setPhase(phaseDAO.getById(rs.getInt(2)));
			lestask.add(ts);
		}
		for (int i = 0; i < lestask.size(); i++) {
			Statement stm3 = SingleConnection.getDbConnction().createStatement();
			ResultSet rs2 = stm3.executeQuery("SELECT * FROM `avancement` a, task t , problems p WHERE a.TaskID = t.ID and t.ID = p.TaskID and t.ID = '"+lestask.get(i).getIdTask()+"'");
			while(rs2.next()) {
				ArrayList<Avancement> lesavancement = new ArrayList<Avancement>();
				ArrayList<Problems> lesproblems = new ArrayList<Problems>();
				lesavancement.add(AvancementDAO.getByID(rs2.getInt(1)));
				lesproblems.add(new Problems(rs2.getInt(12), rs2.getString(14), rs2.getDate(15)));
				lestask.get(i).setAvancement(lesavancement);
				lestask.get(i).setProblems(lesproblems);
				
			}
		}
		
		return lestask;
		
		
	} catch (SQLException e) {
		e.getMessage();
		return null;
	}
	
	
}
public static boolean add(Task tsk ,  int idtask) {
	try {
		PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `task`(`ID`, `phaseID`, `Nom`, `DateStar`, `DateFin`) VALUES (?,?,?,?,?)");
		stp.setInt(1,tsk.getIdTask());
		stp.setString(3, tsk.getNom());
		stp.setDate(4, new java.sql.Date(tsk.getDateStar().getTime()));
		stp.setDate(5, new java.sql.Date(tsk.getDateFin().getTime()));
		stp.setInt(2,idtask);
		stp.executeUpdate();
		return true;
	} catch (SQLException e) {
		e.getMessage();
		return false;
	}
	
	
}
public static boolean delete(Task tsk) {
	try {
		PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("DELETE FROM `task` WHERE ID = ?");
		
		stp.setInt(1,tsk.getIdTask());
		
		stp.executeUpdate();
		return true;
	} catch (SQLException e) {
		e.getMessage();
		return false;
	}
}
public static boolean updat(Task newtsk,Task lasstsk, Phase ph) {
	try {
		PreparedStatement stp = SingleConnection.getDbConnction().prepareStatement("UPDATE `task` SET `phaseID`=?,`Nom`=?,`DateStar`=?,`DateFin`=? WHERE ID = ?");
		stp.setInt(5,lasstsk.getIdTask());
		stp.setString(2, newtsk.getNom());
		stp.setDate(3, new java.sql.Date(newtsk.getDateStar().getTime()));
		stp.setDate(4, new java.sql.Date(newtsk.getDateFin().getTime()));
		stp.setInt(1,ph.getIdPhase() );
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
