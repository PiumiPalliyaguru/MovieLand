package projectMovie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projectMovie.model.CommentData;
import projectMovie.model.MovieData;

public class MoiveDetailsDao {
	
	Connection con1 = null;
	ResultSet rs = null;
	MovieData data = new MovieData();
	String sql = null;
	
	public List<MovieData> movieDetails(int id) throws SQLException {
		
		  List<MovieData> list = new ArrayList<MovieData>();
		  con1 = ConnectionDao.getConnection();
		  sql = "select * from movie_data where id='"+id+"'" ;
		  Statement st1 = con1.createStatement(); 
		 
		  rs = st1.executeQuery(sql);
		  
			  while(rs.next()){
				  MovieData data1 =  new MovieData();
				  data1.setName(rs.getString("name")); 
				  data1.setCurrent_rate(rs.getInt("current_rate"));
				  data1.setYear(rs.getString("year"));
				  data1.setGenre1(rs.getString("genre1"));
				  data1.setGenre2(rs.getString("genre2"));
				  data1.setCover_img(rs.getString("cover_img"));
				  data1.setDirector(rs.getString("director"));
				  data1.setDescription(rs.getString("description"));
				  data1.setGallery_img(rs.getString("gallery_img"));
				  data1.setTrailer(rs.getString("trailer"));
				  data1.setNum_of_rate(rs.getInt("num_of_rate"));
				  data1.setId(rs.getInt("id"));
				  
				  list.add(data1);
				
			  	}
			  
			  	rs.close();
			  	con1.close();
			  //	System.out.print(list);
				return list;
			
	}
	
	public List<CommentData> comment(int id) throws SQLException {
		
		  List<CommentData> list = new ArrayList<CommentData>();
		  con1 = ConnectionDao.getConnection();
		  sql = "select  *from comment where movieId='"+id+"' order by rate desc" ;
		  Statement st1 = con1.createStatement(); 
		 
		  rs = st1.executeQuery(sql);
		  
			  while(rs.next()){
				 CommentData data1 =  new CommentData();
				 data1.setComment(rs.getString("comment"));
				 data1.setUserName(rs.getString("userName"));
				 data1.setRate(rs.getInt("rate"));
				  list.add(data1);
				
			  	}
			  
			  	rs.close();
			  	con1.close();
			  //	System.out.print(list);
				return list;
			
	}
	
	public List<MovieData> similarMovie(String gen1, String gen2) throws SQLException {

		List<MovieData> list = new ArrayList<MovieData>();
		con1 = ConnectionDao.getConnection();
		sql = "select * from movie_data where (genre1='" + gen1 + "' || genre2='" + gen2 + "')";
		Statement st1 = con1.createStatement();

		rs = st1.executeQuery(sql);

		while (rs.next()) {
			MovieData data1 =  new MovieData();
			  data1.setName(rs.getString("name")); 
			  data1.setCurrent_rate(rs.getInt("current_rate"));
			  data1.setYear(rs.getString("year"));
			  data1.setGenre1(rs.getString("genre1"));
			  data1.setGenre2(rs.getString("genre2"));
			  data1.setCover_img(rs.getString("cover_img"));
			  data1.setDirector(rs.getString("director"));
			  data1.setDescription(rs.getString("description"));
			  data1.setGallery_img(rs.getString("gallery_img"));
			  data1.setTrailer(rs.getString("trailer"));
			  data1.setNum_of_rate(rs.getInt("num_of_rate"));
			  data1.setId(rs.getInt("id"));
			  
			
			
			list.add(data1);

		}

		rs.close();
		con1.close();
		System.out.print(list);
		return list;

	}


}
