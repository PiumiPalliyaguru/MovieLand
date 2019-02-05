package projectMovie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import projectMovie.model.MovieData;

public class HomeLoadDao {
	
	Connection con1 = null;
	ResultSet rs = null;
	MovieData data = new MovieData();
	String sql = null;
	
	public List<MovieData> popular() throws SQLException {

		List<MovieData> list = new ArrayList<MovieData>();
		con1 = ConnectionDao.getConnection();
		sql = "select * from movie_data order  desc";
		Statement st1 = con1.createStatement();

		rs = st1.executeQuery(sql);

		while (rs.next()) {
			MovieData data1 = new MovieData();
			data1.setName(rs.getString("name"));
			data1.setCover_img(rs.getString("cover_img"));
			data1.setId(rs.getInt("id"));
			list.add(data1);

		}

		rs.close();
		con1.close();
		//System.out.print(list);
		return list;

	}

}
