package projectMovie.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import projectMovie.dao.UserCommentDao;

/**
 * Servlet implementation class movieComment
 */
@WebServlet("/com")
public class UserComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserComment() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("comment");
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int rate = Integer.parseInt(request.getParameter("rating"));
		int old_rate = Integer.parseInt(request.getParameter("getRate"));
		int no_rate = Integer.parseInt(request.getParameter("getNoRate"));
		String userName = request.getParameter("userName");
		
		System.out.println("user rate="+rate);
		
		
		int new_no_rate = (no_rate + 1);
		int all_rate = (old_rate * no_rate);
		int cal_rate = (all_rate + rate)/new_no_rate;
		
		UserCommentDao cs= new UserCommentDao();
		
		try {
			cs.new_rate(cal_rate,new_no_rate,movieId );
			cs.comment(movieId, comment,userName,rate);
			
			response.sendRedirect("details.jsp");
			System.out.println("rate & comment updated");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
