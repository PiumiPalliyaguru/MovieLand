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

import projectMovie.model.MovieData;
import projectMovie.dao.AdSearchDao;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Logout() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		
		System.out.println(name);
		
		AdSearchDao hs = new AdSearchDao();
		
		try {
			List<MovieData> md = hs.order_by_rate();
			List<MovieData> md2 = hs.orderYear();
			System.out.println(md);

			HttpSession session = request.getSession();
			session.setAttribute("popularMovie", md);
			session.setAttribute("latestMovie", md2);
			session.removeAttribute("name");
			response.sendRedirect("home.jsp");
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*HttpSession  session= request.getSession();
		session.removeAttribute("name");
		response.sendRedirect("home.jsp");*/
		/*session.invalidate();*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
