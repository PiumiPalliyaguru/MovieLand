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

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Font Awesome Icon Library -->
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">

	
<style>
/* .checked {
	color: orange;
} */

.wrapper {
  display: inline-block;
}
.wrapper * {
  float: right;
}
input {
  display: none;
}
label {
  font-size: 30px;
}

input:checked ~ label {
  color: orange;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}

%> 
<div id="id03" class="modal">
	<div class="container col-sm-4" style="background-color:">
	<form  class="modal-content animate" action="com" method="get">
	<div class="imgcontainer">
		<span onclick="document.getElementById('id03').style.display = 'none'" class="close text-danger" title="Close Modal">&times;</span>
	</div>
	<h4 class="text-center">Comment & Rate</h4><br/>
	<div class="row">
		<c:forEach var="data" items="${movieData }">
		<div class="col-sm-1"></div>
		<div class="col-sm-4">
			<img src="${data.cover_img }" style="width: 100%;border:5px; border:solid black ">
			<br/><br/>
		</div>
		<div class="col-sm-6">
		<h5><c:out value="${data.name }"/></h5>
		<h6 class="text-primary">Your comment:</h6>
		<input type="text" placeholder="Enter your comment" name="comment"  style="width:100%" required><br/>
		<h6 class="text-primary">Your Rate:</h6>
		<!-- <div class="row"> -->
			<!-- <div class="col-sm-2"></div> -->
			 <div class="wrapper">
				<input type="radio" id="r5" name="rating" value="5"><label for="r5">&#9733;</label>
				<input type="radio" id="r4" name="rating" value="4"><label for="r4">&#9733;</label>
				<input type="radio" id="r3" name="rating" value="3"><label for="r3">&#9733;</label>
				<input type="radio" id="r2" name="rating" value="2"><label for="r2">&#9733;</label>
				<input type="radio" id="r1" name="rating" value="1"><label for="r1">&#9733;</label>
			</div>
		<!-- </div> -->
			<input type="hidden" name="getNoRate" value="${data.num_of_rate }">
			<input type="hidden" name="getRate" value="${data.current_rate }">
			<input type="hidden" name="movieId" value="${data.id }">
			<input type="hidden" name="userName" value="${name }">
		<div class="row">
		<br><br>
		<div class="col-sm-5">
			<button type="button" onclick="document.getElementById('id03').style.display = 'none'" class="btn btn-danger" style="padding: 10px; width:100%">Cancel</button>
		</div>
		<div class="col-sm-2"></div>
		<div class="col-sm-5">
			<button type="submit" class="btn btn-primary" style="padding: 10px; width:100%" onclick="showAlert()">Ok</button>
		</div>
		
		
		</div>
		</div>
	</div>
	</c:forEach>
	</form>		    	
	</div>	
</div>			
				
				 
				    	
						
						
							
							<br><br>
									
									
								
							


	<script>
		/* function add(ths, sno) {

			for (var i = 1; i <= 5; i++) {
				var cur = document.getElementById("star" + i)
				cur.className = "fa fa-star"
			}

			for (var i = 1; i <= sno; i++) {
				var cur = document.getElementById("star" + i)
				if (cur.className == "fa fa-star") {
					cur.className = "fa fa-star checked"
				}
			}

		} */
		
		// Get the modal
		var modal3 = document.getElementById('id03');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {

			if (event.target == modal3) {
				modal3.style.display = "none";
			}

		}
	</script> 
	
	
 <script type="text/javascript">
function showAlert(){
alert("Comment & Rate success ");
} 
</script> 

</body>
</html>