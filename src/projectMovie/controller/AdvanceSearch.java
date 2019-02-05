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

import projectMovie.dao.AdSearchDao;
import projectMovie.model.MovieData;


@WebServlet("/AdvanceSearch")
public class AdvanceSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdvanceSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String genre = request.getParameter("genre");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String order = request.getParameter("order");

		
		if(keyword == null) {
			System.out.println("null");
		}
		else if(keyword.isEmpty()) {
			System.out.println(2);
		}
		else {
			System.out.println(keyword);
		}
		System.out.println(keyword);
		System.out.println(genre);
		System.out.println(rating);
		System.out.println(order);


		AdSearchDao sr = new AdSearchDao();
		
		if (keyword.isEmpty()) {
			if (order.equals("year") ) {
				if (genre.equals("All") && rating == 0) {

					System.out.println("orderYear 1");
					try {	
						List<MovieData> md = sr.orderYear();
			
						
						 String json = new Gson().toJson(md);
						  
						  	response.setContentType("application/json");
						    response.setCharacterEncoding("UTF-8");
						    response.getWriter().write(json);
						    
						    System.out.println(json);
			            HttpSession session = request.getSession();
						session.setAttribute("movie", md);
						/*session.setAttribute("noOfPages", noOfPages);
			            session.setAttribute("currentPage", pageNo);*/
						
						//response.sendRedirect("search.jsp");
						

					} catch (SQLException e) {
						e.printStackTrace();
					}

				} // end of 3rd
				else if (genre != "All" && rating == 0) {
					System.out.println("genre 2");
					try {
						List<MovieData> md = sr.genre(genre);
						int list_count = md.size();

						String json = new Gson().toJson(md);
						  
					  	response.setContentType("application/json");
					    response.setCharacterEncoding("UTF-8");
					    response.getWriter().write(json);
					    
					    System.out.println(json);
						HttpSession session = request.getSession();
						session.setAttribute("movie", md);
						System.out.println(list_count);
						
						//response.sendRedirect("search.jsp");
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

				} else if (genre.equals("All") && rating != 0) {
					System.out.println("rate-year 3");
					try {
						//System.out.println(rating);
						List<MovieData> md = sr.rate_year(rating);
						int list_count = md.size();

						String json = new Gson().toJson(md);
						  
					  	response.setContentType("application/json");
					    response.setCharacterEncoding("UTF-8");
					    response.getWriter().write(json);
					    
					    System.out.println(json);
						HttpSession session = request.getSession();
						session.setAttribute("movie", md);
						System.out.println(list_count);
						
						//response.sendRedirect("search.jsp");
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

				} else {
					try {
						System.out.println("genre rate 4");
						List<MovieData> md = sr.genre_rate(genre, rating);
						int list_count = md.size();

						String json = new Gson().toJson(md);
						  
					  	response.setContentType("application/json");
					    response.setCharacterEncoding("UTF-8");
					    response.getWriter().write(json);
					    
					    System.out.println(json);
						HttpSession session = request.getSession();
						session.setAttribute("movie", md);
						System.out.println(list_count);
						
						//response.sendRedirect("search.jsp");
						
					} catch (SQLException e) {

						e.printStackTrace();
					}
				}

			} // end order by year
			else if (order.equals("rating")) {
				if (genre.equals("All") && rating == 0) {
					try {
						List<MovieData> md = sr.order_by_rate();
						int list_count = md.size();

						String json = new Gson().toJson(md);
						  
					  	response.setContentType("application/json");
					    response.setCharacterEncoding("UTF-8");
					    response.getWriter().write(json);
					    
					    System.out.println(json);
					    
						HttpSession session = request.getSession();
						session.setAttribute("movie", md);
						System.out.println(list_count);

						//response.sendRedirect("search.jsp");
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						List<MovieData> md = sr.genre_rate(genre);
						int list_count = md.size();

						String json = new Gson().toJson(md);
						  
					  	response.setContentType("application/json");
					    response.setCharacterEncoding("UTF-8");
					    response.getWriter().write(json);
					    
					    System.out.println(json);
					    
						HttpSession session = request.getSession();
						session.setAttribute("movie", md);
						System.out.println(list_count);
						
						//response.sendRedirect("search.jsp");
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}

		} // end of 1st if//search by keyword
		else {
			try {
				List<MovieData> md = sr.keyword(keyword);
				int list_count = md.size();

				String json = new Gson().toJson(md);
				  
			  	response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
			    
			    System.out.println(json);
			    
				HttpSession session = request.getSession();
				session.setAttribute("movie", md);
				System.out.println(list_count);
				
				//response.sendRedirect("search.jsp");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}// end of doget
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdSearchDao sr = new AdSearchDao();
		try {	
			List<MovieData> md = sr.orderYear();

			
			 String json = new Gson().toJson(md);
			  
			  	response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(json);
			    
			    System.out.println(json);
            HttpSession session = request.getSession();
			session.setAttribute("movie", md);
			/*session.setAttribute("noOfPages", noOfPages);
            session.setAttribute("currentPage", pageNo);*/
			
			//response.sendRedirect("search.jsp");
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
