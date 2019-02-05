package projectMovie.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectMovie.model.CommentData;
import projectMovie.model.MovieData;
import projectMovie.dao.MoiveDetailsDao;


@WebServlet("/MovieDetails")
public class MovieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieDetails() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("getMovieId"));
		String genre1 = request.getParameter("getGenre1");
		String genre2 = request.getParameter("getGenre2");
		
		System.out.println(id);
		System.out.println(genre1);
		System.out.println(genre2);
		
		
		MoiveDetailsDao ds = new MoiveDetailsDao();
		
		
		try {
			List<MovieData> md = ds.movieDetails(id);
			List<MovieData> md2 = ds.similarMovie(genre1, genre2);
			List<CommentData> md3 = ds.comment(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("movieData", md);
			session.setAttribute("similar", md2);
			session.setAttribute("comment", md3);
			response.sendRedirect("details.jsp");
		
			
			System.out.println("similar" +md2);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
