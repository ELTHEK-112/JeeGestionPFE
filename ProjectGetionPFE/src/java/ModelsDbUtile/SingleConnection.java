package ModelsDbUtile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SingleConnection {
	private static Connection connector = null;
    //public static SingleConnect dbConnectoin;
    
     
     private SingleConnection(){
    	 try {
    		             Class.forName("com.mysql.jdbc.Driver");
                         connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
     
     public static Connection getDbConnction(){
    	 if(connector == null)  new SingleConnection();
    	 return connector;
     }
     public static ResultSet readQury(String req) {
	     try {
	    	 Statement st = getDbConnction().createStatement();
	    	 return st.executeQuery(req);
	    	 
			
		} catch (SQLException e) {
			return null;
		}
	 
	 
 }
}
