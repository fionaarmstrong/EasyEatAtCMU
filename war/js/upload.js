
// upload the image to imgur using imgur API, return the url of the img
function share(){
    try {
        var image = canvas.toDataURL('image/jpeg', 0.9).split(',')[1];
    } catch(e) {
        var image = canvas.toDataURL().split(',')[1];
    }
    // open the popup in the click handler so it will not be blocked

    console.log('Uploading')
    // upload the image to imgur using jquery
    $.ajax({
        url: 'http://api.imgur.com/2/upload.json',
        type: 'POST',
        data: {
            type: 'base64',
            key: '6528448c258cff474ca9701c5bab6927',
            image: image
        },
        dataType: 'json'
    }).success(function(data) {
        link = data['upload']['links']['imgur_page'];
        console.log(link);
        //use hidden filed pass the url to server.
         
        $("<input type='hidden' name='photolink' id='photolink'/>").val(link).appendTo('#imgSection');
    }).error(function() {
        alert('Could not reach api.imgur.com. Sorry :(');
    });
}

// upload a local img file to canvas

    var imageLoader = document.getElementById('imageLoader');
    console.log('entering listenner');
        imageLoader.addEventListener('change', handleImage, false);
    console.log('entering canvas');
    var canvas = document.getElementById('imageCanvas');
    var ctx = canvas.getContext('2d');
         
        function handleImage(e){
            var reader = new FileReader();
            reader.onload = function(event){
            var img = new Image();
            img.onload = function(){
                canvas.width = 300;
                canvas.height = 400; 
                ctx.drawImage(img,0,0,300,400);
                console.log('entering share');
                //after loading the image, send the image to imgur.
                share();
            }
            img.src = event.target.result;
            }
            reader.readAsDataURL(e.target.files[0]);  
        }

function showMap(){
    var location = $('#location').val();
    console.log('location');
    location = location.replace(" ","+");
    $('#map').attr('src', 'http://maps.googleapis.com/maps/api/staticmap?center='+location+',Pittsburgh,PA&zoom=16&size=280x220&maptype=roadmap&markers=color:blue%7Clabel:S%7C'+location+',Pittsburgh,PA&sensor=false');
}