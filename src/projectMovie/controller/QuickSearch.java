package projectMovie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import projectMovie.model.MovieData;
import projectMovie.dao.AdSearchDao;


@WebServlet("/search")
public class QuickSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QuickSearch() {
        super();
        System.out.println("in quick search");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("in quick search get");
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		
		
		 AdSearchDao sr = new AdSearchDao();
		 
		  try { 
			  List<MovieData> md = sr.keyword(keyword); 
		 
			  String json = new Gson().toJson(md);
		  
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
			    
			    System.out.println(json);
		     HttpSession session = request.getSession();
		  session.setAttribute("movie", md); 
		  		  
		 // session.setAttribute("movie", result);
	 // response.setContentType(result);
		 // response.getWriter().print(result);
		  
		  
		// response.sendRedirect("search.jsp");
		  
		 // System.out.println(response);
		  
		  
		  } catch (SQLException e) 
		  { 
			  e.printStackTrace();
		  }
		 
	}
	
	
	/*
	 * private void write(HttpServletResponse response, Map<String, Object> map)
	 * throws IOException { response.setContentType("application/json");
	 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(new
	 * Gson().toJson(map));
	 * 
	 * }
	 */
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
