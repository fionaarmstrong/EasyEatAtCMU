<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Easy Eat @CMU</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="css/myCss.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" href="css/font-awesome.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
     <script src="js/bootstrap-popover.js"></script>
    <script src="js/homepage.js"></script>
    <script src="js/userinfo.js"></script>
    <script src="js/tag.js"></script>
    <script src="js/fooddetail.js"></script>
  </head>
  <body>
    	<div class="navbar navbar-fixed-top"> <!--begin of fixed-top bar  -->
        <div class="navbar-inner">
            <div class="container">
            	<div class="row">
            		<div class="span6 offset1">	
	                	<a class="brand" id="brand" href="display.action" rel="home">Easy Eat @CMU</a>
	                	<form action="searchpost.action" class="navbar-form">
	                		<input type="search" name="searchkey" id="searchkey"/>
	                		<button type="submit" id="searchkeybutton">Search</button>		
	                	</form>	
	            	</div>
	            	<div class="span5">	
	                	<ul class="nav nav-pills" id="mainmenus">
						    <li ><a id="mainmenu" href="display.action">Home</a></li>
						    <li ><a id="mainmenu" href="entertags.action">Tags</a></li>	
						    <li ><a id="mainmenu" href="users.jsp">Users</a></li>
						    <li class="dropdown" style="margin-top:-20px; margin-left:90px">

	            				<a class="dropdown-toggle" data-toggle="dropdown" href="#userinfo">
		               				<img id="userphotoicon" src="img/yinxu.jpg" alt="">
		               				${user.firstname} ${user.lastname} 
			               		</a>
			               		<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
								  <li><a id="mainmenu" tabindex="-1" href="userinfo.jsp">Food information</a></li>
								  <li><a id="mainmenu" tabindex="-1" href="userinfo-personal.jsp">Personal information</a></li>
								  <li class="divider"></li>
								  <li><a id="mainmenu" tabindex="-1" href="signout.action">Log out</a></li>
								</ul>
	            			</li>	   
						</ul>
	            	</div>		
	            </div>  <!--end of row  --> 
            </div>
        </div>
    </div><!--end of fixed-top bar  -->