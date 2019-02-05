package projectMovie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projectMovie.dao.ConnectionDao;
import projectMovie.model.MovieData;

public class AdSearchDao {


	Connection con1 = null;
	ResultSet rs = null;
	MovieData data = new MovieData();
	String sql = null;
	
/*	public int getNoOfRecords() throws SQLException {
		con1 = ConDao.getConnection();
		  sql = "select count(*) from movie_data order by year desc" ;
		  Statement st1 = con1.createStatement(); 
		  
		  rs = st1.executeQuery(sql);
		  rs.next();
		 int totalNoOfRecords= rs.getInt(1);
		
		 return totalNoOfRecords;
		
	}*/

//	 order by year //int start, int recordsPerPage
	public List<MovieData> orderYear() throws SQLException {
		  List<MovieData> list = new ArrayList<MovieData>();
	  con1 = ConnectionDao.getConnection();
	  sql = "select * from movie_data order by year desc " ;
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
			  data1.setId(rs.getInt("id"));
			  
			  list.add(data1);
			
		  	}
		  
		  	rs.close();
		  	con1.close();
		//System.out.print(list);
			return list;
	}
	//order by genre
	public List<MovieData> genre(String genre) throws SQLException {
		  List<MovieData> list = new ArrayList<MovieData>();
	  con1 = ConnectionDao.getConnection();
	  sql = "select * from movie_data where genre1='"+genre+"' || genre2='"+genre+"' order by year desc" ;
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
			  data1.setId(rs.getInt("id"));
			  
			  list.add(data1);
			
		  	}	  
		  	rs.close();
		  	con1.close();
		  //	System.out.println(list);
			return list;
	}
	//order by rate with year
		public List<MovieData> rate_year(int rating) throws SQLException {
			
			System.out.println(rating);
			  List<MovieData> list = new ArrayList<MovieData>();
		  con1 = ConnectionDao.getConnection();
		  sql = "select * from movie_data where current_rate='"+rating+"' order by year desc" ;
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
				  data1.setId(rs.getInt("id"));
				  
				  list.add(data1);
				
			  	}	  
			  	rs.close();
			  	con1.close();
			//  	System.out.println(list);
				return list;
		}
		
	
	//order by genre & rate
		public List<MovieData> genre_rate(String genre, int rating) throws SQLException {
		
			  List<MovieData> list = new ArrayList<MovieData>();
		  con1 = ConnectionDao.getConnection();
		  sql = "select * from movie_data where (current_rate='"+rating+"' && genre1='"+genre+"') || (current_rate='"+rating+"' && genre2='"+genre+"') order by year desc" ;
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
				  data1.setId(rs.getInt("id"));
				  
				  list.add(data1);
				 // System.out.print(list);
				
			  	}	  
			  	rs.close();
			  	con1.close();
			  //	System.out.print(list);
				return list;
		}
		//order by  rate
				public List<MovieData> order_by_rate() throws SQLException {
					
					  List<MovieData> list = new ArrayList<MovieData>();
				  con1 = ConnectionDao.getConnection();
				  sql = "select * from movie_data order by current_rate desc" ;
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
						  data1.setId(rs.getInt("id"));
						  
						  list.add(data1);
						  //System.out.print(list);
						
					  	}	  
					  	rs.close();
					  	con1.close();
				//	  	System.out.print(list);
						return list;
				}
				//genre order by  rate
				public List<MovieData> genre_rate(String genre) throws SQLException {
					
					  List<MovieData> list = new ArrayList<MovieData>();
				  con1 = ConnectionDao.getConnection();
				  sql = "select * from movie_data where genre1='"+genre+"' || genre2='"+genre+"' order by current_rate desc" ;
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
						  data1.setId(rs.getInt("id"));
						  
						  list.add(data1);
						  //System.out.print(list);
						
					  	}	  
					  	rs.close();
					  	con1.close();
					  	System.out.print(list);
						return list;
				}
				//keyword
				public List<MovieData> keyword(String keyword) throws SQLException {
					//System.out.println("keyword");
					  List<MovieData> list = new ArrayList<MovieData>();
				  con1 = ConnectionDao.getConnection();
				  sql = "select * from movie_data where name like '%"+keyword+"%' order by current_rate desc" ;
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
						  data1.setId(rs.getInt("id"));
						  
						  list.add(data1);
						  //System.out.print(list);
						
					  	}	  
					  	rs.close();
					  	con1.close();
					  	//System.out.print(list);
						return list;
				}
				


}
