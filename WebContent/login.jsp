<%@page import="projectMovie.model.MovieData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<!-- font awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="stylesheet" href="css/search.css" type="text/css" media="screen" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/search.js"></script>

</head>
<body>

<header>
		<%@ include file='navbar.jsp'%>
	
	</header>
<main style="background-color: #0c0c0c">
<br><br><br><br><br>
<div class="container mt-3 bg-white">
  <h2>Login & Registration</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#home">Login</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#menu1">Register</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
  
    <div id="home" class="container tab-pane active"><br>
     
       <form  action="Login" method="post">
                <div class="imgcontainer">
                    <h1>Login</h1>
                  
                </div>

                <div class="container">
                    <label for="uname"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" autocomplete="off" required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="psw" required>

                   
                    <!-- <label>
                        <input type="checkbox" checked="checked" name="remember"> Remember me
                    </label> -->
                </div>

                <div class="container" style="background-color:#f1f1f1">
                    <button class="btn btn-danger" type="button" onclick="document.getElementById('id01').style.display = 'none'" style="padding: 15px 50px">Cancel</button>
                     <button  type="submit" class="btn btn-primary" style="padding: 15px 50px">Login</button>
                    <!-- <span class="psw">Forgot <a href="#">password?</a></span> -->
                </div>
            </form>
    </div>
    
    <div id="menu1" class="container tab-pane fade"><br>
   
       <form action="Register"  method="post">
                 <div class="imgcontainer">
                     <h1>Sign Up</h1>
                    
                </div>
                <div class="container">
                    
                    
                    <p>Please fill in this form to create an account.</p>
                    <hr>
                    <label for="name"><b>Name</b></label>
                    <input type="text" placeholder="Enter Name" name="name" autocomplete="off"  required>
                    
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" autocomplete="off"  required>

                    <label for="psw"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>

                    <label for="psw-repeat"><b>Repeat Password</b></label>
                    <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

                    

                    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

                    <div class="clearfix">
                        <button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="btn btn-danger" style="padding: 15px 50px">Cancel</button>
                        <button type="submit" class="btn btn-primary" style="padding: 15px 50px">Sign Up</button>
                        <label>
                       <!--  <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me -->
                    </label>
                    </div>
                </div>
            </form>
    </div>
    
     
  </div>
  <br/><br/>
</div>

</main>
<footer> </footer>


</body>
</html>