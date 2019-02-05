$(document).ready(function(){
	
	$("#basicSearchbtn").click(function(e){ 
		e.preventDefault();
		
		
		if($(this).hasClass("active") && $("#keyword").val().length !== 0){
			alert(" key word ");
			
			$.ajax({
				type: 'GET',
				url:'search',
				data :{keyword:$('#keyword').val()},
				success: function(result){
					alert("data"+result);
					console.log(result);
					//$.load("details.jsp");
					
				},
				error: function(e){
					alert(e);
				}
				});
			$("#keyword").val(null);
			
		}
		
		else if($(this).hasClass("active") && $("#keyword").val().length === 0){
			
			$("#basicSearchbtn").removeClass("active");
			
			
		}
		
		else{
			$(this).addClass("active");
			
			$("#basic-search").toggleClass("active");
			$("#keyword").toggleClass("active");
			$("#keyword[type='text']").focus();
			
			
		}
		
	});
	
});
