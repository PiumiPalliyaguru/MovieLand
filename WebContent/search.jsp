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
<title>search</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<!-- font awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="stylesheet" href="css/search.css" type="text/css" media="screen" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" src="js/search.js"></script>

</head>
<body>

	<header>
		 <%@ include file='navbar.jsp'%> 
	
	</header>
	<main style="background-color:#0c0c0c"> <br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
 <div class="container col-md-6" style="background-color: black"> 
			<br/><br/><br/><br/>
			 <form id="advanceSearchform"> 
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-10 text-white">
						<div id="main-search-fields">
							<p class="pull-left-term">Movie Name :</p>
							<div class="row">
								<div class="col-sm-9">
									<input class="text-white" id="keyword" type="search" name="keyword"
									placeholder="Enter movie name" autocomplete="off"
									style="padding: 15px 100px; width:100%; background-color: #0c0c0c; border:5px; border:solid black">
								</div>
								<div class="col-sm-2 ">
									<div class="search-btn">
										<input id="advanceSearchbtn" class="btn btn-primary" name="id" type="submit" value="Search" style="width: 100%; padding: 15px; text-decoration: none; border-color:  #0c0c0c; font-size: 15px">
									</div>
								</div>	
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<br />
					<div class="col-sm-1"></div>
					<div class="col-sm-10">
					<div class="row">
					<div class="col-sm-3">
						<br />
						<div class="select-container text-white">
							<p>Genre:</p>
							<select class="input-lg text-white" id="genre" name="genre"
								style="padding: 15px; width:100%; background-color:  #0c0c0c; border:5px; border:solid black">
								<option value="All">All</option>
								<option value="Action">Action</option>
								<option value="Biography">Biography</option>
								<option value="Comedy">Comedy</option>
								<option value="Cartoon">Cartoon</option>
								<option value="History">History</option>
								
							</select>
						</div>
					</div>
					<div class="col-sm-3">
						<br />
						<div class="form-group text-white" >
							<p>Rating:</p>
							<select class="input-lg text-white" name="rating" id="rating"
								style="padding: 15px; width:100%; background-color:  #0c0c0c; border:5px; border:solid black">
								<option value="0">All</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select>
						</div>
					</div>
					<div class="col-sm-3">
						<br />
						<div class="select-container text-white" >
							<p>Order by:</p>
							<select class="input-lg text-white" name="order" id="order"
								style="padding: 15px; width:100%; background-color:  #0c0c0c; border:5px; border:solid black">
								<option value="year">Year</option>
								<option value="rating">Rating</option>
							</select>
						</div>
					</div>
					</div>
					</div>
				</div>
				<br /> <br />
			</form>
	</div> 
	
	<div class="container">
	<br /> <br />
		<div class="row" id="content1">
		
		<%-- <div class="container-fluid text-center">
		<br /> <br />
		<!-- left side -->
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>

			<!-- search result -->
			<div class="col-sm-8 text-left" id="searchResult">
			
				<div class="row" id="content1">
					
					<c:if test="${empty movie}">
						<div class="col-sm-4"></div>
						<div class="card" style="width: 400px">

							<div class="card-body" style="background-color: black">
							
								<h1 class="text-danger">No Result</h1>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty movie}">

						<c:forEach var="data" items="${movie}">

							<div class="col-sm-2">

								<div class="flip-card">
									<div class="flip-card-inner">
										<div class="flip-card-front">
											<input type="image" name="submit" src="${data.cover_img }" alt="Submit" style="width: 100%;  border:5px; border:solid white" /> 
										</div>
										<div class="flip-card-back">
										<br>
											<h5 class="text-primary">
												<c:out value="${data.name}" />
											</h5><br/>
											<h6 class="text-white">
												<i class="text-warning fa fa-star" ></i><br/>
												<c:out value="${data.current_rate }" />/5
											</h6><br/>
											<h6 class="text-white">
												<c:out value="${data.year }" />
											</h6><br/>
											<h6 class="text-white">
												<c:out value="${data.genre1 }" />
												/
												<c:out value="${data.genre2 }" />
											</h6><br/>

											<form action="details" method="get">
												<input class="btn btn-primary" name="id" type="submit"
													value="View Movie" style="width: 80%" /> <input
													type="hidden" name="getMovieId" value="${data.id }">

												<input type="hidden" name="getGenre1"
													value="${data.genre1 }"> <input type="hidden"
													name="getGenre2" value="${data.genre2 }">

											</form>

										</div>
									</div>
								</div>
								<br>
							</div>
							<div class="col-sm-1"></div>
							<br>
						</c:forEach>
						

						
					</c:if>

				
				</div>
						</div>

		</div>
	</div> --%>
		
		</div>
	</div>
	
	
	<%-- <!-- movie content -->

	 --%>




	</main>
	<footer> </footer>
	
	<script>
	$(document).on("click", "#searchbtn", function() {             // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	    $.get("searchMo", function(responseXml) {                // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response XML...
	        $("#searchResult").html($(responseXml).find("data").html()); // Parse XML, find <data> element and append its HTML to HTML DOM element with ID "somediv".
	    });
	});
	</script>
	
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