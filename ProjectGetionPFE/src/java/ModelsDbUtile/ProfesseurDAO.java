package ModelsDbUtile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.*;

public class ProfesseurDAO {
	
	public static Professeur getById(int id) {
		Professeur prof = null;
		ArrayList<ProjetFE> arrproj = new ArrayList<ProjetFE>();
		
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM professeur  WHERE ID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				prof = new Professeur(rs.getInt(1), rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6));
				
			}
			      
			      PreparedStatement st1 = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `projetfe`   WHERE  professerurID = ? ");
					st1.setInt(1, prof.getIDProfesseur());
					ResultSet rs1 = st1.executeQuery();
					while(rs1.next()) {
						arrproj.add(new ProjetFE(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getDate(4)));
					}
					prof.setProjetFE(arrproj);
			
			return prof;
			
		} catch (SQLException e) {
			
			return prof;
		}
	}
	public static Professeur getByIdWhitjury(int id) {
		Professeur prof = null;
		ArrayList<ProjetFE> arrproj = new ArrayList<ProjetFE>();
		Jury jury = null;
		try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `jury` j , professeur p WHERE j.`ID2` = p.JuryID2 and p.ID = ? ");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				prof = new Professeur(rs.getInt(4), rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9));
				jury = new Jury(rs.getInt(1), rs.getString(2),rs.getString(3));
			}
			      prof.setJury(jury);
			      PreparedStatement st1 = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `projetfe`   WHERE  professerurID = ? ");
					st1.setInt(1, prof.getIDProfesseur());
					ResultSet rs1 = st1.executeQuery();
					while(rs1.next()) {
						arrproj.add(new ProjetFE(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getDate(4)));
					}
					prof.setProjetFE(arrproj);
			
			return prof;
			
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	public static  ArrayList<Professeur> getAll(){
		  
		ArrayList<Professeur> arrayProf = new ArrayList<Professeur>();
		  try {
			  PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM professeur");
		      
			  ResultSet rs = st.executeQuery();
			  while(rs.next()) {
				 arrayProf.add(new Professeur(rs.getInt(1), rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6)));
				  	  
				}
			 return arrayProf; 
			  
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}
	
	public static  ArrayList<Professeur> getAllwhiteJury(){
		  
		ArrayList<Professeur> arrayProf = new ArrayList<Professeur>();
		  try {
			  PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `jury` j , professeur p WHERE j.`ID2` = p.JuryID2");
		      
			  ResultSet rs = st.executeQuery();
			  while(rs.next()) {
				  Professeur prof = new Professeur(rs.getInt(4), rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9));
				  
				  Jury jury = new Jury(rs.getInt(1), rs.getString(2),rs.getString(3));
				  prof.setJury(jury);
				  arrayProf.add(prof);
				  
				}
			  for (int i = 0; i < arrayProf.size(); i++) {
				  PreparedStatement st1 = SingleConnection.getDbConnction().prepareStatement("SELECT * FROM `projetfe`  WHERE professerurID = ? ");
					st1.setInt(1, arrayProf.get(i).getIDProfesseur());
					ResultSet rs1 = st1.executeQuery();
					while(rs1.next()) {
					ArrayList<ProjetFE>	 arrproj = new ArrayList<ProjetFE>();
					arrproj.add(new ProjetFE(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getDate(4)));
					arrayProf.get(i).setProjetFE(arrproj);
					}
			}
			 return arrayProf; 
			  
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}
	  public static boolean add(Professeur p1,int idj){
		  
		  try {
			PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("INSERT INTO `professeur`(`ID`, `JuryID2`, `Nom`, `Prenom`, `Branch`, `Cin`) VALUES (?,?,?,?,?,?)");
			st.setInt(1,p1.getIDProfesseur());
			st.setInt(2,idj);
			st.setString(3,p1.getNom());
			st.setString(4,p1.getPrenom());
			st.setString(5,p1.getBranch());
			st.setString(6,p1.getCin());
			st.executeUpdate();
			return true;


		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
		  
	  }
	  public static boolean delete(int id) {
		  
		  try {
				PreparedStatement st = SingleConnection.getDbConnction().prepareStatement(" DELETE FROM `professeur` WHERE `ID` = ?");
				st.setInt(1,id);
				
				
				st.executeUpdate();
				return true;


			} catch (SQLException e) {
				e.getMessage();
				return false;
			}
		  
	  }
	  public static boolean update(Professeur pleass , Professeur newp , int idju) {
		  try {
				PreparedStatement st = SingleConnection.getDbConnction().prepareStatement("UPDATE `professeur` SET `JuryID2`=?,`Nom`=?,`Prenom`=?,`Branch`=?,`Cin`=? WHERE ID = ?");
				st.setInt(6,pleass.getIDProfesseur());
				st.setInt(1,idju);
				st.setString(2,newp.getNom());
				st.setString(3,newp.getPrenom());
				st.setString(4,newp.getBranch());
				st.setString(5,newp.getCin());
				st.executeUpdate();
				return true;

			} catch (SQLException e) {
				e.getMessage();
				return false;
			}
	  }
	
	public static void main(String Arg[]){
		
		System.out.print(getById(4));
	}

	
}
