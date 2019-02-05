$(document).ready(function(){
	
//	comment fade
	$("#viewCommentdiv").hide();
	$("#viewCommentbtn").click(function(e){
		$("#viewCommentdiv").fadeToggle(1000);
	});
	
	/*//similar movie form submit
	$("#similarMovieImg").click(function(){
		alert("image click");
		$(this).parent().submit();
		
	});*/
	
	return false;
	
});