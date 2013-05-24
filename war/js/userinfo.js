$(document).ready(function(){
	$("#birthYear").append("<option value='1'>select</option>"); 
	for(var i=1950; i<2011;i++){
	 $("#birthYear").append("<option value='"+i+"'>"+i+"</option>"); 
	}

	$("#birthMonth").append("<option value='1'>select</option>"); 
	for(var i=1950; i<2011;i++){
	 $("#birthMonth").append("<option value='"+i+"'>"+i+"</option>"); 
	}

	$("#birthDay").append("<option value='1'>select</option>"); 
	for(var i=1950; i<2011;i++){
	 $("#birthDay").append("<option value='"+i+"'>"+i+"</option>"); 
	}
});

function deletePost(){
	$('#myapost').remove();
}

