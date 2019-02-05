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
<link rel="stylesheet" href="css/home.css" type="text/css" media="screen" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" src="js/home.js"></script>

</head>
<body>

<header>
		<%@ include file='navbar.jsp'%>
</header> 

<div class="container-fluid" id="main content" style="background-color: #0c0c0c">

	<div class="container">
	<br/><br/><br/><br/><br/><br/>
	<div class="row">
			<div class="col-md-2"></div>	
			<div class="col-md-8 text-center">
			
				<h1 class="text-primary">Search your favorite movie details, Comment & Rate movies </h1><br/>
				
				 <div id="slider">
	                <ul class="slides">
	                    <li class="slide slide1"><img src="images/beauty and the beast.jpg" style="width:720px; height: 400px;"/></li>
	                    <li class="slide slide2"><img src="images/smallfoot.jpg" style="width:720px; height: 400px;"/></li>
	                    <li class="slide slide3"><img src="images/fisr man1.jpg" style="width:720px; height: 400px;"/></li>
	                    <li class="slide slide4"><img src="images/panadora.jpg" style="width:720px; height: 400px;"/></li>
	                    <li class="slide slide5"><img src="images/blade runer.jpg" style="width:720px; height: 400px;"/></li>
	                    <li class="slide slide1"><img src="images/jhonny1.jpg" style="width:720px; height: 400px;"/></li>
	                </ul>
            	</div>
				
				</div>
				<div class="col-md-2"></div>
		</div>	

	</div>
		<div class="container" style="background-color: #0c0c0c">
			<div class="row">
				<div class="col-md-12">
				<br/><br/><br/>
					<h3 class="text-primary">Popular Movies</h3><br/>
					<div class="row" id="content1">
					</div>
				</div>	
			</div>	
			
			<div class="row">
			<div class="col-md-12">
			<br/><br/><br/>
				<h3 class="text-primary">Latest Movies</h3><br/>
				<div class="row" id="content2">
				</div>
			</div>
				
			</div>
		</div>
</div>


<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
		
<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>  -->
		

</body>
</html>