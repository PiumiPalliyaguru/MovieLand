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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import projectMovie.model.MovieData;
import projectMovie.dao.AdSearchDao;


@WebServlet("/HomeLoad")
public class HomeLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdSearchDao obj = new AdSearchDao();
		
		System.out.println("in Home load");
		
		try {
			List<MovieData> md = obj.order_by_rate();
			List<MovieData> md2 = obj.orderYear();
		
			 String popular = new Gson().toJson(md);
			 String latest = new Gson().toJson(md2);
		
			 String bothObject = "["+popular+","+latest+"]";
			  
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(bothObject);
			    
			    System.out.println(popular);
			    System.out.println(latest);

			//HttpSession session = request.getSession();
			//session.setAttribute("popularMovie",md );
			//session.setAttribute("latestMovie", md2);
			//response.sendRedirect("moviehome.jsp");
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
