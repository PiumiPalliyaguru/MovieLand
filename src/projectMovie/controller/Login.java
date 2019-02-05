package projectMovie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import projectMovie.dao.AdSearchDao;
import projectMovie.dao.LoginDao;
import projectMovie.model.MovieData;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		System.out.println("login sevlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name1 = request.getParameter("uname");
        String password1 = request.getParameter("psw");
        PrintWriter out = response.getWriter();
      
        LoginDao dao =  new LoginDao();
        AdSearchDao sr = new AdSearchDao();
            
        try {
			if(dao.login(name1, password1)== 1){
			    
				List<MovieData> md = sr.orderYear();
				int list_count = md.size();

				System.out.println(list_count);
				
			    HttpSession session = request.getSession();
			    session.setAttribute("name", name1);
				session.setAttribute("movie", md);
		    
			    if(session.getAttribute("movieData") !=null) {
			    	response.sendRedirect("details.jsp");
			    }
			    else {
			    	response.sendRedirect("search.jsp");
			    }
			    
			    System.out.println("user");
			}
			else if(dao.login(name1, password1)== 2) {
				HttpSession session = request.getSession();
			    session.setAttribute("name", name1);
			    response.sendRedirect("admin.jsp");
			    
			    System.out.println("admin");
			}
      
   
			else{
				
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('Username or password incorrect');");
				   out.println("location='login.jsp';");
				   out.println("</script>");
				
}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
