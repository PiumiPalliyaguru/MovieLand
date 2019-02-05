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
<title>details</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<!-- font awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="css/search.css" type="text/css" media="screen" /> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" src="js/details.js"></script> 

</head>
<body>
	<header>
		<%@ include file='navbar.jsp'%> 
		<%@ include file='comment.jsp'%>
		<%-- <%@ include file='login.jsp' %> --%>
	</header>
	<main>

<div class="container-fluid" style="background-color: #0c0c0c">
	<br/><br/><br/><br/><br/><br/>
	<div class="row">
	<div class="col-md-2"></div>
	<c:forEach var="data" items="${movieData }">
	<div class="col-md-6">
		<div class="row">
			<div class="col-md-4">
					<img class="img" src="${data.cover_img }" style="width: 100%; height: 100%; border:5px; border:solid white" >
			</div>
			<div class="col-md-8">
					<h1 class="text-primary"><c:out value="${data.name}" /></h1>
					<h5 class="text-white"><c:out value="${data.year }" /></h5>
					<h5 class="text-white"><c:out value="${data.genre1 }" />/<c:out value="${data.genre2 }" /></h5>
					<c:set var="movieRate" value="${data.current_rate }"/>
				        	           <fmt:parseNumber var="rate" type="number" value="${movieRate }"/>
				        	           <c:forEach begin="1" end="${rate}" varStatus="loop">
				        	           <h5> <span class="float-left"><i class="text-warning fa fa-star"></i></span></h5>
				        	            </c:forEach>
				        	            <br/>
					<h5 class="text-white">Director : <c:out value="${data.director }" /></h5>
					<h5 class="text-primary">About Movie :</h5>
					<h6 class="text-white"><c:out value="${data.description }" /></h6>
			</div>			
		</div>
		<br/><br/>
		<div class="row">
		    <div class="col-md-6">
				<img class="img" src="${data.gallery_img }" style="width: 100%; height: 300px; border:5px; border:solid white" alt=""> 
		   </div>
		   <div class="col-md-6">
				<iframe src="${data.trailer }" style="width: 100%; height: 300px"></iframe>
		   </div>
		</div>
		</div>
		<div class="col-md-3">
			<h5 class="text-primary">Related Movies</h5>
			<div class="row">
				 <c:forEach var="similar" items="${similar }" begin="0" end="3" varStatus="loop">
				  <c:set var="id1" value="${data.id }" />
					<c:set var="id2" value="${similar.id }" />
					<c:if test="${id2 != id1 }"> 
					<div class="col-md-4">
						<form id="similarMoviefrom" action="MovieDetails" method="get">
							<input id="similarMovieImg" type="image" name="submit" src="${similar.cover_img }" alt="Submit" style="width: 80%;  border:5px; border:solid white" />  
							<input type="hidden" name="getMovieId" value="${similar.id }"> 
							<input type="hidden" name="getGenre1" value="${similar.genre1 }">
							<input type="hidden" name="getGenre2" value="${similar.genre2 }">
						</form>			
					</div>
					 </c:if> 
				</c:forEach> 
			</div>
			<br/>	
			
				<button class="btn btn-primary" onclick="document.getElementById('id03').style.display = 'block'" style="width: 100%; padding:10px 80px;">Comment & Rate Now </button>
				<form action="comment" method="get">
					<input type="hidden" name="getId" value="${data.id }">
				</form>	
				
				<br/>
				<button class="btn btn-primary" id="viewCommentbtn" style="width: 100%; padding:10px 80px;">View Comments </button>
				
				
								
			
		<div class ="viewComment" id="viewCommentdiv">
		 <br/>
		 <c:if test="${empty comment}">
			<h1 class="text-danger">No Comments</h1>
							
		</c:if>
		<c:if test="${not empty comment}">
			<c:forEach var="comment" items="${comment }" begin="0" end="2" varStatus="loop">
				<div class="row">				 	
					<div class="card" style="background-color:#1f1f1f">
					    <div class="card-body">
					        <div class="row">
				        	    <div class="col-md-2">
				        	        <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
				        	        <p class="text-secondary text-center"><!-- 15 Minutes Ago --></p>
				        	    </div>
				        	    <div class="col-md-10">
				        	        <p>
				        	           <h5 class="float-left text-primary"><c:out value="${comment.userName }" /></h5>
				        	           <c:set var="userRate" value="${comment.rate }"/>
				        	           <fmt:parseNumber var="rate" type="number" value="${userRate }"/>
				        	           <c:forEach begin="1" end="${rate}" varStatus="loop">
				        	            <span class="float-right"><i class="text-warning fa fa-star"></i></span>
				        	            </c:forEach>
				                        
				
				        	       </p>
				        	       <div class="clearfix"></div>
				        	        <p class="text-white"><c:out value="${comment.comment }" /></p>
				        	    </div>
					        </div>         
					    </div>
					</div>
					<br/>
				 </div> 
			</c:forEach>
		</c:if>			
		</div>
		
		</div>
	<div class="col-md-1"></div>	
	</c:forEach>	
	</div>
</div>


	</main>

	<fotter> </fotter>

<!-- 
 <script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
	type="text/javascript"></script> -->
</body>
</html>