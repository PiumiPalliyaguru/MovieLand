package projectMovie.dao;

import java.sql.*;

import projectMovie.model.MovieData;

public class UserCommentDao {

	public UserCommentDao() {
		super();

	}
    Connection con1 = null;
	ResultSet rs = null;
	MovieData data = new MovieData();
	String sql = null;
	
	public void comment(int movieId, String comment, String userName, int rate) throws SQLException {
		con1 = ConnectionDao.getConnection();
		Statement st = con1.createStatement();

		System.out.println("connection");

		int i = st.executeUpdate(
				"insert into comment(id, movieId, comment, userName, rate) values(null,'" + movieId + "', '" + comment + "','"+userName+"','"+rate+"')");

		System.out.println("okay" + i);

	}
	
	  public void new_rate(int cal_rate, int new_no_rate,int movieId) throws SQLException {
	 
	 con1 = ConnectionDao.getConnection(); 
	 Statement st = con1.createStatement();
	 
	 System.out.println("cal-rate="+cal_rate);
	 System.out.println("new_no_rate"+new_no_rate);
	 
	 // create the java mysql update preparedstatement
     String query = "update movie_data set current_rate = ?, num_of_rate = ? where id = ?";
     PreparedStatement preparedStmt = con1.prepareStatement(query);
     preparedStmt.setInt(1, cal_rate);
     preparedStmt.setInt(2, new_no_rate);
     preparedStmt.setInt(3, movieId);
     

     // execute the java preparedstatement
     preparedStmt.executeUpdate();
	 System.out.println("connection");
	 
	 System.out.println("okay rate updated ");
	 
	 }
	 
}
