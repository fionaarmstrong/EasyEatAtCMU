console.log('js loaded');

function handleClick(e){
	console.log('button clicked');
	var n = $('#n').val();
	var m = $('#m').val();
	console.log('user typed'+n);
	console.log('user typed'+m);
	$.ajax('/add.action',{
		type: 'post',
		data: {
			n:n,
			m:m
		},
		cache: false,
		dataType: 'json',
		success: function(response){
			console.log('success return');
			$('#result').append(response.result);
		}

	});
	
}

$(document).ready(function(){
	$('#doit').click(handleClick);
})
