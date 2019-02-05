# MovieLand
Movie land is movie web application  which users can search movie details and comment &amp; rate movies.  Jsp sevlet technology usedfor implementation of this web site.


Functions(Home page)

Data retrieve (When page load popular views latest movies load for the page).

	Method – HTTP POST
	Response data type – Movie data (json)
	Servlet URL  - /HomeLoad
	
User login 

	Method – HTTP POST
	Request data type – User name , password (json)
	Servlet URL - /Login

User Registration – 

	Method – HTTP POST
	Request data type – User details (json)
	Servlet URL - /Register
  
Search movies by movie name
Search movie by genre sort by rate / year
Search movie by genre , rate sort by year
Search movie by rate sort by year
Sort all movies year or rate 
	
	Method – HTTP GET
	Request data  – genre/rate/ keyword/sort type (json)
	Servlet URL - /AdvanceSearch
	Response data type – Movie data (json)
  
  Search unique movie details, Related Movies 

	Method – HTTP POST
	Request data – movie id (json) 
	Servlet URL - /MovieDetails
	Response data – movie data(Movie Object)

Comment  & Rate 

	Method – HTTP POST
	Request data – movie id (json) 
	Servlet URL - /MovieDetails
	Response data – movie comment(Comment Object)
  
  Get user comment & rate
  
	Method – HTTP POST
	Request data – movie id, user id, Comment & rate 
	Servlet url - /com

User logout  

	Method – HTTP POST
	Request data – user id 
	Servlet URL - /Logout
  
  
