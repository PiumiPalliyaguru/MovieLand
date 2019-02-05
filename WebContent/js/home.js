/*this mean when page loading to browser*/

$(document).ready(function(){
	
	
	
	   //settings for slider
    var width = 720;
    var animationSpeed = 1000;
    var pause = 3000;
    var currentSlide = 1;

    //cache DOM elements
    var $slider = $('#slider');
    var $slideContainer = $('.slides', $slider);
    var $slides = $('.slide', $slider);

    var interval;

    function startSlider() {
        interval = setInterval(function() {
            $slideContainer.animate({'margin-left': '-='+width}, animationSpeed, function() {
                if (++currentSlide === $slides.length) {
                    currentSlide = 1;
                    $slideContainer.css('margin-left', 0);
                }
            });
        }, pause);
    }
    function pauseSlider() {
        clearInterval(interval);
    }

    $slideContainer
        .on('mouseenter', pauseSlider)
        .on('mouseleave', startSlider);

    startSlider();
    
    
  
	
  
   /* get popular & latest movies using ajx
    */
	$.ajax({
		type: 'POST',
		url:'HomeLoad',
		//data :{keyword:$('#keyword').val()},
		success: function(result){
			$("#content1").empty();
			$("#content2").empty();
		
	        $.each(result[0], function(index1, movie1) { 
	        	
	        	var popularMovie = 
	        
        		"<div class='col-md-3' id='homeContent'>\
					    <form id='movieSearchById' action='MovieDetails' method='get'>\
					        <input class ='resultImg' type='image' name='submit' src='"+movie1.cover_img+"' alt='Submit' style='width: 80%; border:5px solid white'>\
							<input type='hidden' name='getMovieId' value='"+movie1.id+"'>\
							<input type='hidden' name='getGenre1' value='"+movie1.genre1+"'>\
							<input type='hidden' name='getGenre2' value='"+movie1.genre2+"'>\
						</form></br>\
					</div>";
	        	
	        	if(index1 < 4){
	        		$("#content1").append(popularMovie);
	        	
	        	}
	        	
	        });
	        $.each(result[1],function(index2,movie2) {
	        	var latestMovie= 	
				       "<div class='col-md-3' id='homeContent'>\
						    <form id='movieSearchById' action='MovieDetails' method='get'>\
						        <input type='image' class ='resultImg' name='submit' src='"+movie2.cover_img+"' alt='Submit' style='width: 80%; border:5px solid white'>\
								<input type='hidden' name='getMovieId' value='"+movie2.id+"'>\
								<input type='hidden' name='getGenre1' value='"+movie2.genre1+"'>\
								<input type='hidden' name='getGenre2' value='"+movie2.genre2+"'>\
							</form></br>\
						</div>";
	        	
	        	if(index2 < 4){
	        		$("#content2").append(latestMovie);
	        	}
	        });
	   	
		},
		error: function(e){
			alert(e);
		}
	});
	
	$(document).ajaxComplete(function(){
		
		$(".resultImg").css('opacity','0.4');
	    $(".resultImg").on("mouseover",function(){
	    	$(this).fadeTo(100,1);
	    	$(".resultImg").not(this).fadeTo(100,0.4);
	    	
	    	
	    });
	    
	    $(".resultImg").on("mouseout",function(){
	    	$(".resultImg").fadeTo(100,0.4);
			//$(".movieName").css("visibility","hidden");
		});
	    
	    $(".resultImg").on("mouseover",function(){
    		$(".movieName").css("visibility","visible");
    		$(".movieName").not(this).css("visibility","hidden");
    	});
	    
		
	});
	
	//when mouse hover dispaly text on img
	/*$("#resultImg").on("mouseover",function(){
		alert("mouse over work");
		$("#movieName").css("visibility","visible");
	});
	*/
	
	//image fade jqury // not work
	  
	
	return false;	
});