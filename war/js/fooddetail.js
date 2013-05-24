function newcomment(postid,firstname,lastname,userid){
	var keynode = event.which; //get the value of key that be pressed 
	//if press Enter
	if (keynode=="13") {
		var commentInput = $("#inputcomment").val();
		var d = new Date();
		var month = d.getMonth()+1;
		var day = d.getDate();
		var hour = d.getHours();
		var minute = d.getMinutes();
		var second = d.getSeconds();

		var output = d.getFullYear() + '-' +
		    ((''+month).length<2 ? '0' : '') + month + '-' +
		    ((''+day).length<2 ? '0' : '') + day + ' ' +
		    ((''+hour).length<2 ? '0' :'') + hour + ':' +
		    ((''+minute).length<2 ? '0' :'') + minute + ':' +
		    ((''+second).length<2 ? '0' :'') + second;
		 $("#inputcomment").val("");

		$("#newcomment").after("<div class='span5'> <a id='myref' href='userinfo.jsp' >"+firstname+" "+lastname+"</a>"+  
							"&nbsp;&nbsp;<i class='icon-time'>"+output+"</i>"+
            "<p>"+commentInput+"</p> </div>"
            +"<div class='span5' style='margin-top:-15px; margin-left:8px;''><hr> </div>");

		$.ajax('/comment.action',{
		type: 'post',
		data: {
			content:commentInput,
			postid:postid,
			userid:userid
		},
		cache: false,
		dataType: 'json',
		success: function(response){
			console.log('success return');
		}

	});

	}	
}

function detailvoteUpClick(thisObj,postid,userid){
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
			
			var voteup = parseInt($("#voteup").html());
			var votedown = parseInt($("#votedown").html());
			
			//change color 6E6E6E
			if(flag == -1){
				// flag == -1, cancel the vote up that already made
				thisObj.css("color","#6E6E6E");
				voteup = voteup-1;
			}
			else if(flag == 1){
				// flag==1, mark current post as vote up
				thisObj.css("color","#B40404");
				voteup = voteup+1;
			}
			else if(flag == 2){
				//falge=2, cancle the vote down, and mark post as vote up
				console.log(' down to up');
				thisObj.css("color","#B40404");
				thisObj.next().css("color","#6E6E6E");
				votedown= votedown-1;
				voteup=voteup+1;
			}
			else{
				console.log('error flag');
			}
			//ADD TEXT VALUE
			$("#voteup").html(voteup);
			$("#votedown").html(votedown);
		},
		error: function(response){
			console.log('error return');
		}

	});
	
}

function detailvoteDownClick(thisObj,postid,userid){
	console.log('vote up clicked');

	//var n = $('#n').val();
	$.ajax('/votedown.action',{
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
			
			var voteup = parseInt($("#voteup").html());
			var votedown = parseInt($("#votedown").html());
			
			//change color 6E6E6E
			if(flag == -1){
				// flag == -1, cancel the vote down that already made
				thisObj.css("color","#6E6E6E");
				votedown = votedown-1;
			}
			else if(flag == 1){
				// flag==1, mark current post as vote down
				thisObj.css("color","#3a87ad");
				votedown = votedown+1;
			}
			else if(flag == 2){
				//falge=2, cancle the vote down, and mark post as vote up
				thisObj.css("color","#3a87ad");
				thisObj.prev().css("color","#6E6E6E");
				console.log(' up to down');
				votedown = votedown +1;
				voteup= voteup-1;
			}
			else{
				console.log('error flag');
			}
			//ADD TEXT VALUE
			$("#voteup").html(voteup);
			$("#votedown").html(votedown);
		},
		error: function(response){
			console.log('error return');
		}

	});
	
}