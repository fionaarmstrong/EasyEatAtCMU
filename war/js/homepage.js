$(document).ready(function(){
	$(".carousel").carousel();
	$('.dropdown-toggle').dropdown();
	// limit description to 50 
	$("#postdescribe").each(function(){
		if ($(this).text().length > 50) {
			$(this).text($(this).text().substr(0, 47));
			$(this).append("<a href='fooddetail.jsp'><i class='icon-double-angle-right'></i></a>");
		}
	});
});

$(function(){
	$('#love').tooltip({
		placement:'left',
		title:'The category of food that people like ',
	});

	$('#hate').tooltip({
		placement:'right',
		title:'The category of food that people dislike',
	});
})



function voteUpClick(thisobj,postid,userid){
	console.log('vote up clicked');
	//var n = $('#n').val();
	$.ajax('/voteup.action',{
		type: 'post',
		data: {
			postid:postid,
			userid:userid
		},
		cache: false,
		dataType: 'json',
		success: function(response){
			console.log('success return');
			var flag = response.flag;
			console.log(flag);
			var popular = parseInt(thisobj.next("#popularity").html());
			
			//change color 6E6E6E
			if(flag == -1){
				// flag == -1, cancel the vote up that already made
				thisobj.css("color","#6E6E6E");
				thisobj.next("#popularity").css("color","#6E6E6E");
				popular = popular+flag;
			}
			else if(flag == 1){
				// flag==1, mark current post as vote up
				thisobj.css("color","#B40404");
				thisobj.next("#popularity").css("color","#B40404");
				popular = popular+flag;
			}
			else if(flag == 2){
				//falge=2, cancle the vote down, and mark post as vote up
				thisobj.css("color","#B40404");
				thisobj.next("#popularity").css("color","#B40404");
				thisobj.next("#popularity").next().css("color","#6E6E6E");
				popular = popular+flag;
			}
			else{
				console.log('error flag');
			}
			//ADD TEXT VALUE
			thisobj.next("#popularity").html(popular);
		},
		error: function(response){
			console.log('error return');
		}

	});
	
}

function voteDownClick(thisobj,postid,userid){
	console.log('vote down clicked');
	//var n = $('#n').val(); 
		// $.ajax('/votedown.action',{
		// 	type: 'post',
		// 	data: {
		// 		postid:postid
		// 	},
		// 	cache: false,
		// 	dataType: 'json',
		// 	success: function(response){
		// 		console.log('success return');
			
		// 	}

		// });
	
	$.ajax('/votedown.action',{
		type: 'post',
		data: {
			postid:postid,
			userid:userid
		},
		cache: false,
		dataType: 'json',
		success: function(response){
			console.log('success');
			var flag = response.flag;
			console.log(flag);
			var popular = parseInt(thisobj.prev("#popularity").html());
			//change color 6E6E6E
			if(flag == -1){
				// flag == -1, cancel the vote down that already made
				thisobj.css("color","#6E6E6E");
				thisobj.prev("#popularity").css("color","#6E6E6E");
				popular = popular-flag;
			}
			else if(flag == 1){
				// flag==1, mark current post as vote down
				thisobj.css("color","#3a87ad");
				thisobj.prev("#popularity").css("color","#3a87ad");
				popular = popular-flag;
			}
			else if(flag == 2){
				thisobj.css("color","#3a87ad");
				thisobj.prev("#popularity").css("color","#3a87ad");
				thisobj.prev("#popularity").prev().css("color","#6E6E6E");
				popular = popular-flag;
			}
			else{
				console.log('error flag');
			}
			//ADD TEXT VALUE
			thisobj.prev("#popularity").html(popular);
		},
		error: function(response){
			console.log('error return');
		}

	});
	
}

