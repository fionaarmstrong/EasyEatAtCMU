<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Easy Eat @CMU</title>
  <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
  <link href="css/bootstrap.css" rel="stylesheet" media="screen">
  <link href="css/myCss.css" rel="stylesheet" media="screen">
  <link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
  <link rel="stylesheet" href="css/default/default.css" type="text/css" media="screen" />
  <script src="js/jquery.nivo.slider.pack.js" type="text/javascript"></script>
  <script src="js/bootstrap.js"></script>

</head>

<body bgcolor="#F2F2F2">
  <div class="span2 offset2" style="margin-top:40px">
      <a class="brand" id="brand"  rel="home">Easy Eat @CMU</a>
  </div>
  <div class="span6" style="margin-top:40px; margin-left:280px">
      <form name="loginForm" id="loginForm" method="post" action="login.action">    
          <input type="text" id="emailSignIn" name="emailSignIn" style="width:150px;" placeholder="email adress"> 
          <input type="password" id="pwdSignIn" name="pwdSignIn" style="width:150px" placeholder="password">  
          <input type="submit" id="login" value="Login" 
          style="background-color:#B40404; color:#ffffff; margin-top:-10px">
      </form>
  </div>
  <div class="row" >
    <div class="span5" style="margin-top:40px;margin-left:265px" id="slides"><!--begin of slider-->
      <div id="wrapper">
        <div class="slider-wrapper theme-default" style="width:500px">
            <div id="slider" class="nivoSlider">
                <img src="img/toystory.jpg" data-thumb="img/toystory.jpg" alt="" title="#first"/>    
                <img src="img/walle.jpg" data-thumb="img/walle.jpg" alt="" title="#second"/>
                <img src="img/nemo.jpg" data-thumb="img/nemo.jpg" alt="" title="#third"/>
                <img src="img/up.jpg" data-thumb="images/up.jpg" alt="" data-transition="slideInLeft"  title="#last" />
            </div>
            <div id="first" class="nivo-html-caption">
                <strong>Toy</strong> does not <strong> Eat </strong> anything.
            </div>
            <div id="second" class="nivo-html-caption">
                <strong>Walle</strong> <strong> Eats </strong> rubbish.
            </div>
            <div id="third" class="nivo-html-caption">
                <strong>Cormorant</strong> only <strong> Eats </strong> aquatic animal.
            </div>
            <div id="last" class="nivo-html-caption">
               <em>What about you?</em> Let's start your own <strong> Food Adventure </strong> from here.
            </div>
        </div>
      </div>
    </div> <!--end of slider-->
      <script type="text/javascript">
      $(window).load(function() {
          $('#slider').nivoSlider();
      });

      </script>
      <div class="span3" style="margin-top:20px; margin-left:60px">
        <c:forEach var="error" items="${errorList}">
           <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <p>${error}</p>
          </div> 
        </c:forEach>
      </div>

   <!-- begin of sign up -->
   <div class="span5" style="margin-top:40px;">
     <div class="span5" style="border: 1px solid gray; width:270px;"> 
        <form name="signupForm" id="signupForm" method="post" action="signup.action">
           
          <table align="center">
            <tr>
              <td><h3 style="color: #610B0B;">Sign Up</h3></td>
            </tr>
            <tr>
              <td > <input type="text" id="firstName" name="firstName" placeholder="first name"></td>
            </tr>
            <tr>
              <td><input type="text" id="lastName" name="lastName" placeholder="last name"></td>
            </tr>
            <tr>
              <td><input type="email" type="email" id="emailSignUp" name="emailSignUp" placeholder="email adress"></td>
            </tr>
            <tr>
              <td><input type="password" id="pwdSignUp" name="pwdSignUp" placeholder="password"></td>
            </tr>
            <tr>
              <td><input type="submit" id="signUp" value="Get Started!" 
                style="background-color:#B40404; color:#ffffff; 
                width:210px;text-algin:center"></td>
            </tr>
          </table>   
        </form>
        <div id="errorList"></div>
    </div>
    <!-- end of sign up -->
    <!-- facebook login API -->  
    <div id="fb-root" class="span3" style="margin-top:10px; margin-left:60px">
        <input type="button" id="facebook" value="login with facebook" onClick="loginWithFB();"
         style="background-color:#3B5999;width:210px;color:#ffffff">
    </div>     
   </div>
   
</div><!--end of row-->
 

<script>
  // Additional JS functions here
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '232586250216354', // App ID
      channelUrl : '//easyeatatcmu.appspot.com/channel.html', // Channel File
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the session
      xfbml      : true  // parse XFBML
    });

    // Additional init code here
    
	//
    FB.getLoginStatus(function(response) {
        
        if (response.status === 'connected') {
            // connected
           console.log('connected');
           fbstatus = 'connected'; 
        	 //testAPI();
        	//document.getElementById('fb-logout').style.display = 'block';
        	//get user name ....
        } else if (response.status === 'not_authorized') {
            // not_authorized
            console.log('not_authorized');
            fbstatus = 'not_authorized';
            //login();
        } else {
            // not_logged_in
            console.log('status: else');
            fbstatus = 'else';
            //login();
        	//document.getElementById('fb-logout').style.display = 'block';
        }
    });
  };
  
  function login() {
	    FB.login(function(response) {
	        if (response.authResponse) {
	            // connected
              console.log('authorized and connceted');
              //direct to the main page
	        	  createUser();
	        } else {
	            // cancelled
              console.log('cancelled'); 
	        }
	    }, {scope: 'email'});
	}
  
 //  function logout() {
	//     FB.logout(function(response) {
	//         console.log('User is now logged out');
	//     });
	// }
  
  function testAPI() {
	    console.log('Welcome!  Fetching your information.... ');
	    FB.api('/me', function(response) {
	        console.log('Good to see you, ' + response.name + '.');
	        console.log('I got your email:' + response.email);
          console.log('userid: ' + response.id);
          var email = response.email;
          var fbid = response.id;
          $('#emailSignIn').val(email);
          $('#pwdSignIn').val(fbid);
          $('#loginForm').submit();
	    });
	}

  function createUser() {
      console.log('Welcome!  Fetching your information.... ');
      FB.api('/me', function(response) {
          console.log('Good to see you, ' + response.name + '.');
          console.log('I got your email:' + response.email);
          console.log('userid: ' + response.id);
          var email = response.email;
          var fbid = response.id;
          var name = response.name;
          $('#emailSignUp').val(email);
          $('#pwdSignUp').val(fbid);
          $('#firstName').val(name);

          $('#signupForm').submit();
      });
  }

  function loginWithFB(){
    if(fbstatus == 'connected'){
      testAPI();
    }
    else if(fbstatus == 'not_authorized'){
      login();
    }
    else{
      //do nothing.
    }
  }

  // Load the SDK Asynchronously
  (function(d){
     var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement('script'); js.id = id; js.async = true;
     js.src = "//connect.facebook.net/en_US/all.js";
     ref.parentNode.insertBefore(js, ref);
   }(document));
</script>
<!-- <button id="fb-logout" onclick="logout()" >Log out</button> -->
<footer>
    <div class="containter">
      <div class="span9 offset2" style="margin-top:20px">
        <hr>
        <p class="pull-left">Esay Eat c.2013.</p>&nbsp; &nbsp; &nbsp;
        Term Project for 15-637 Web Application Development, Carnegie Mellon University.
        <p class="pull-right btt">
          <a href="#">
            <i class="icon-caret-right"></i>
            Back to top
          </a>
        </p>    
      </div>
    </div>  
  </footer>
</body>
</html>