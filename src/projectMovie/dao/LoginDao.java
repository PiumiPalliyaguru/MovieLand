package projectMovie.dao;

import java.sql.*;

public class LoginDao {
	 
	 public LoginDao() {
		super();
		  System.out.println("loginsql");
	}

	public int login(String name, String password) throws SQLException {
		  Connection con1 = null;
		  ResultSet rs1 = null;
		  ResultSet rs2 = null;
		  
		
		  con1 = ConnectionDao.getConnection();
			  
		  String sql1 = "select * from user where name=? and password=?"; 
		  String sql2 = "select * from admin where name=? and password=?";
		  
		  System.out.println("loginsql");
		 
		  PreparedStatement st1 = con1.prepareStatement(sql1);
		  st1.setString(1,name);
		  st1.setString(2,password);
		  rs1 = st1.executeQuery();
		  
		  PreparedStatement st2 = con1.prepareStatement(sql2); 
		  st2.setString(1,name);
		  st2.setString(2,password);
		  rs2 = st2.executeQuery();
		  
		  if(rs1.next()) {
			  return 1; 
		  }
		  else if(rs2.next()) {
			  return 2;
		  }
		  else {
			  return 3;  
		  }
	 
		
	  }

}
