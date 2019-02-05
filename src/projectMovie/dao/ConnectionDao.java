package projectMovie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

	private static String url = "jdbc:mysql://localhost:3306/moviedb";
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "root";
    private static String pw =null;
    private static Connection con = null;
  

	public static  Connection getConnection() {
		
		  	/*System.out.println(url);
			System.out.println(pw);
			System.out.println(driverName);   */
			
			
	        try {
	            Class.forName(driverName);
	            try {
	            	
	                con = DriverManager.getConnection(url, username, pw);
	                System.out.println("connection successful");
	            } catch (SQLException ex) {
	               
	                System.out.println(ex); 
	            }
	        } catch (ClassNotFoundException ex) {
	           
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }   
}
