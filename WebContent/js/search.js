$(document).ready(function(){	
	$.ajax({
		type: 'POST',
		url:'AdvanceSearch',
		success: function(result){
			$("#content1").empty();
			
	        $.each(result, function(index, movie) { 
	  	
	        	var movieData = 
	        		"<div class='col-md-2'>\
	        			<div class='flip-card'>\
							<div class='flip-card-inner'>\
								<div class='flip-card-front'>\
									<input type='image' name='submit' src='"+movie.cover_img+"' alt='Submit' style='width: 100%;  border:5px solid white'>\
								</div>\
								<div class='flip-card-back'>\
									<br>\
									<h5 class='text-primary'> "+movie.name+" </h5><br/>\
									<h6 class='text-white'>\
										<i class='text-warning fa fa-star' ></i><br/> "+movie.current_rate+"/5 </h6>\
									<h6 class='text-white'> "+movie.year+" </h6>\
									<br/>\
									<h6 class='text-white'> "+movie.genre1+" / "+movie.genre2+" </h6><br/>\
									<form id='movieSearchById' action='MovieDetails' method='get'>\
										<input class='btn btn-primary' name='id' type='submit' value='View Movie' style='width: 80%' />\
										<input type='hidden' name='getMovieId' value='"+movie.id+"'>\
										<input type='hidden' name='getGenre1' value='"+movie.genre1+"'>\
										<input type='hidden' name='getGenre2' value='"+movie.genre2+"'>\
									</form>\
								</div>\
							</div>\
						</div>\
						<br>\
					</div>\
					<div class='col-sm-1'></div>\
					<br>"
	        	$("#content1").fadeIn(1000).append(movieData);
	  
	        });
	        
	   	
		},
		error: function(e){
			alert(e);
		}

	});
	
	
	$('#advanceSearchbtn').on("click",function(e){
	e.preventDefault();
	$.ajax({
		type: 'GET',
		url:'AdvanceSearch',
		data :{
			keyword: $('#keyword').val(),
			genre: $('#genre').val(),
			rating: $('#rating').val(),
			order: $('#order').val()
			
			},
		
		success: function(result){
			if(!$.trim(result)){
				$("#content1").empty();
        		var error = "<h1 class='text-danger'>No Result</h1>";
        		
        		$("#content1").append(error);			
        	}
        	else{
        		$("#content1").empty();
    			
		        $.each(result, function(index, movie) { 
			
		        	var movieData = 
		        		"<div class='col-sm-2'>\
		        			<div class='flip-card'>\
								<div class='flip-card-inner'>\
									<div class='flip-card-front'>\
										<input type='image' name='submit' src='"+movie.cover_img+"' alt='Submit' style='width: 100%;  border:5px solid white'>\
									</div>\
									<div class='flip-card-back'>\
										<br>\
										<h5 class='text-primary'> "+movie.name+" </h5><br/>\
										<h6 class='text-white'>\
											<i class='text-warning fa fa-star' ></i><br/> "+movie.rate+"/5 </h6><br/>\
										<h6 class='text-white'> "+movie.year+" </h6>\
										<br/>\
										<h6 class='text-white'> "+movie.genre1+" / "+movie.genre2+" </h6><br/>\
										<form id='movieSearchById' action='MovieDetails' method='get'>\
											<input class='btn btn-primary' name='id' type='submit' value='View Movie' style='width: 80%' />\
											<input type='hidden' name='getMovieId' value='"+movie.id+"'>\
											<input type='hidden' name='getGenre1' value='"+movie.genre1+"'>\
											<input type='hidden' name='getGenre2' value='"+movie.genre2+"'>\
										</form>\
									</div>\
								</div>\
							</div>\
							<br>\
						</div>\
						<div class='col-sm-1'></div>\
						<br>";
		        	$("#content1").append(movieData);
		        });		
        	}
        	     
	   	
		},
		error: function(e){
			alert("Something wrong ");
		}

	});
	/*after button submit select menu get defult setting*/
	$("#keyword").val();
	$("#genre").val();
	$("#rating").val();
	$("#order").val();
	
	});
	return false;
});