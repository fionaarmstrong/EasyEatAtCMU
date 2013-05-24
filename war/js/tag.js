
$(function(){
	$('#searchtag').keyup(function(){
		console.log('value changed');
		var prefix = $('#searchtag').val();
		//$('#initialtags').empty();
		$.ajax('/searchtagajax.action',{
			type: 'post',
			data: {
				prefix:prefix
			},
			cache: false,
			dataType: 'json',
			success: function(response){
				console.log('success return');
				var tagList = response.tagList;
				
				$('#initialtags').empty();
				if(tagList.length != null){
					console.log(tagList.length);
					for(var i=0;i<tagList.length;i++){
	                  $('#initialtags').append(" <div class='span2'> "+ 
	                            "<a href='searchtag.action?tagid="+tagList[i].tagid+"'"+" class='label label-important'>"+ tagList[i].tagname+"</a>"+
	                            "<i><i>"+
	                            "<p id='tagfont'>"+tagList[i].tagdesc+"<p>"+
	                             "<hr></div>");
	                   }
	                   $('#initialtags').append("</div>");
	            }
			},
			error: function(response){
				console.log('error return');
			}

		});
	});
})