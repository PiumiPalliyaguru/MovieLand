<%@page import="projectMovie.model.MovieData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>home</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<!-- font awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="stylesheet" href="css/navbar.css" type="text/css" media="screen" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<script type="text/javascript" src="js/navbar.js"></script> 

</head>
<body>

	
	<!-- Navigation -->
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark fixed-top " style="background-color:  #000000">
		<div class="container-fluid " style=" background-color:  #000000">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="row">
					<a class="navbar-brand" href="home.jsp"> <img src="images/logo.jpg" height="80" width="80" alt="C&T Movies" style="float: left; border-radius: 100px"> </a>
					<a class="navbar-brand" href="home.jsp"> <h3 class="text-primary">MOVIE LAND</h3></a>
					</div>
				</div>		
				<div class="col-md-4">
					<!--  <div class="basic-search" id="basic-search">
						<form id="basicSearchform" action="search" method="get">
							<input id="keyword" type="search" name="keyword" placeholder="search">
							<button id="basicSearchbtn" type="submit" class="fa fa-search"></button>
							<i class="fa fa-search" id="searchIcon" aria-hidden="true"></i>
						</form> 
						 
					</div>  -->
				</div>
				<div class="col-md-3">
					<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive"
							aria-controls="navbarResponsive" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarResponsive">
						
								
								<a href="search.jsp"><button class="btn btn-link" style="width: auto; margin: 5px">Browse Movies</button></a>
									<input type="hidden" name="order" value="year">
								
								<c:set var="name" value="${name }" />
								<c:if test="${name == null }">
								<button class="btn btn-link"
									onclick="document.getElementById('id01').style.display = 'block'" style="width:auto; margin:5px">Login</button>
								</c:if>
								<c:if test="${name != null }">
								<form action="logout" method="get">
								<button class="btn btn-link"  style="width:auto; margin:5px">Logout</button>
								<input type="hidden" name="name" value="${name}">
								</form>
								</c:if>
								<c:if test="${name == null }">
								<button class="btn  btn-link"
									onclick="document.getElementById('id02').style.display = 'block'"
									style="width: auto; margin: 15px">Register</button>
								</c:if>
								
					</div>
				</div>	
				</div>
			</div>
		</div>
	</nav> 

<!-- login popup form		 -->
<div id="id01" class="modal">
	<div class="container">
     <div class="row">
     <div class="col-md-6">
          <form class="modal-content animate" action="Login" method="post">
                <div class="imgcontainer">
                    <h1>Login</h1>
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close text-danger" title="Close Modal">&times;</span>
                </div>

                <div class="container">
                    <label for="uname"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                   
                </div>

                <div class="container" style="background-color:#f1f1f1">
                <div class="row">
                 	<div class="col-sm-1"></div>
	                <div class="col-sm-4">
	                 <button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="btn btn-danger" style="padding: 15px 50px">Cancel</button>
	                </div>
	                <div class="col-sm-2"></div>
	                <div class="col-sm-4">
	                 <button class="btn btn-primary" type="submit" style="padding: 15px 50px">Login</button>
	                </div>
                  </div> 
                   <!--  <span class="btn btn-primary">Forgot <a href="#">password?</a></span> -->
                    
                    
                </div>
            </form>
        </div>
     </div>
  </div>
</div>
     <!--    register popup form -->
    
     <div id="id02" class="modal">
      <div class="container">
     <div class="row">
     <div class="col-md-6">
            <form class="modal-content animate" action="Register"  method="post">
                 <div class="imgcontainer">
                     <h1>Sign Up</h1>
                     <span onclick="document.getElementById('id02').style.display = 'none'" class="close text-danger" title="Close Modal">&times;</span>
                    
                </div>
                <div class="container">
                    
                    
                    <p>Please fill in this form to create an account.</p>
                    <hr>
                    <label for="name"><b>Name</b></label>
                    <input type="text" placeholder="Enter Name" name="name" required>
                    
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>

                    <label for="psw-repeat"><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

                    

                    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

					   <div class="container" style="background-color:#f1f1f1">
                <div class="row">
                 	<div class="col-sm-1"></div>
	                <div class="col-sm-4">
	                  <button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="btn btn-danger" style="padding: 15px 50px">Cancel</button>
	                </div>
	                <div class="col-sm-2"></div>
	                <div class="col-sm-4">
	                 <button type="submit" class="btn btn-primary" style="padding: 15px 50px">Sign Up</button>
	                </div>
                  </div> 
                   <!--  <span class="btn btn-primary">Forgot <a href="#">password?</a></span> -->
                    
                    
                </div>
                    
                </div>
            </form>
        </div>

     
     
     </div>
     </div>
     </div>
     
        

        <script>
            // Get the modal
            var modal1 = document.getElementById('id01');
            var modal2 = document.getElementById('id02');


            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target == modal1) {
                    modal1.style.display = "none";
                }
                if (event.target == modal2) {
                    modal2.style.display = "none";
                }
                
            }
        </script> 


<!-- 	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script> -->
		
	
<script src="js/navbar.js"></script>
</body>
</html>