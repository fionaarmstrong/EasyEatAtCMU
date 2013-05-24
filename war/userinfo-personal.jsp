<!DOCTYPE html>
<html>
  <head>
    <title>Easy Eat @CMU</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="css/myCss.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/userinfo.js"></script>

  </head>
  <body class="mybody">
  	<div class="navbar navbar-fixed-top"> <!--begin of fixed-top bar  -->
        <div class="navbar-inner">
            <div class="container">
            	<div class="row">
            		<div class="span6 offset1">	
	                	<a class="brand" id="brand" href="home-best.jsp" rel="home">Easy Eat @CMU</a>
	                	<input type="search" name="searchkey" id="searchkey"/>
	                	<button id="searchkeybutton">Search</button>
	            	</div>
	            	<div class="span2">	
	                	<ul class="nav nav-pills" id="mainmenus">
						    <li ><a id="mainmenu" href="home-best.jsp">Home</a></li>
						    <li ><a id="mainmenu" href="/category/">Tags</a></li>	
						    <li ><a id="mainmenu" href="/category/">Users</a></li>		   
						</ul>
	            	</div>
	            	<div class="span1">
	            		<ul class="nav-userbar">
		               		<a href="userinfo.jsp">
		               			<img id="userphotoicon" src="img/yinxu.jpg" alt="usrinfo.jsp">
		               		</a>
		                </ul>
	            	</div>  		
	            </div>  <!--end of row  --> 
            </div>
        </div>
    </div><!--end of fixed-top bar  -->
	<div class="container"> <!--began of sub bar  -->
		<div class="raw" style="margin-top:80px">
			<div class="span6 offset2">
				<h3>Set Personal Information</h3>
				<div class="tabbable">
				    <ul class="nav nav-tabs">
				       <li class="active"><a href="#information" data-toggle="tab">Information</a></li>
				       <li><a class="mytab" href="#profile" data-toggle="tab">Profile</a></li>
				       <li><a class="mytab" href="#passward" data-toggle="tab">Passward</a></li>
				    </ul>
					<div class="tab-content" id="myinfo">
						<div class="tab-pane active" id="information">
							<div class="span1" style="margin-top:30px">
								<p>Username: </p>
								<p style="margin-top:25px">Email: </p>
								<p style="margin-top:25px">Gender: </p>
								<p style="margin-top:20px">Birthday: </p>
							</div>
							<div class="span3" style="margin-top:30px">
								<input type="text" name="username" id="username"/> <br>
								<input type="email" name="email" id="email"/> <br>
								<div style="margin-top:10px">
									<input type="radio" name="gender" value="male" checked>Male&nbsp;
									<input type="radio" name="gender" value="female" >Female &nbsp;
									<input type="radio" name="gender" value="other" >Other 
								</div>
								<div  style="margin-top:20px">
									<select id="birthYear" style="width:80px;height:20px" onload="birthYear();">	
							        </select>
							        <select id="birthMonth" style="width:80px;height:20px" onload="birthMonth();">
							        </select>
							        <select id="birthDay" style="width:80px;height:20px" onload="birthDay();">
							        </select>
						        </div>
						        <button id="button" style="margin-top:20px">Update</button>
							</div>
						</div>

						<div class="tab-pane" id="profile">
							<div class="span1" style="margin-top:25px;margin-left:60px">
								<p>Profile: </p>
								<p style="margin-top:165px">Preference: </p>
							</div>
							<div class="span3" style="margin-top:25px; margin-left:10px">
								<div class="span3">
									<img src="img/00.jpg" style="width:130px;height:130px" /> 
								</div>	
								<div class="span3" style="margin-top:10px;">
									<input type="file" name="file" value=""/>
								</div>
								<div class="span3" style="margin-top:10px; ">
									<input type="text" name="preference" id="preference"/> <br>
								</div>
								<div class="span3" style="margin-top:10px;">
									<button id="button" >Update</button>
								</div>	
							</div> 
						</div>

						<div class="tab-pane" id="passward">
							<div class="span2" style="margin-top:30px; margin-left:150px">
								<p>Current Password: </p>
								<input type="password" name="password" id="password"/> <br>
								<p style="margin-top:0px">New Password: </p>
								<input type="password" name="passnew" id="passnew"/> <br>
								<p style="margin-top:0px">Verify Password: </p>
								<input type="password" name="passverify" id="passverify"/> <br>

						        <button id="button" style="margin-top:20px">Update</button>
							</div>
						</div>
					</div>
				</div>		
			</div>
		</div>
		
	</div>
	<footer>
		<div class="containter">

		</div>
		<p class="pull-left">Esay Eat 2013.</p>
		<p class="pull-right btt">
			<a href="#">
				<i class="icon-caret-right"></i>
				Back to top
			</a>
		</p>
	</footer>

  </body>
</html>