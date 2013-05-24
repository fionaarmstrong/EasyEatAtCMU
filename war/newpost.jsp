<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Easy Eat @CMU</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" href="css/font-awesome.min.css">
    <link href="css/homepage.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="css/jquery.tagit.css" type="text/css">
  	<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.2/themes/blitzer/jquery-ui.css">
  	<link rel="stylesheet" href="css/myCss.css" type="text/css">

    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-button.js" type="text/javascript" charset="utf-8"></script>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <script src="js/tag-it.js" type="text/javascript" charset="utf-8"></script>
    

  </head>
   <body class="mybody">
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

	<div class="container"> <!--begin of post-->
		<div class="row-content" style="margin-top:60px">
			<div class="span8 offset2"> <!--begin of tags -->
				<div class="span8">
					<h4>Record and Share your daily food life!</h4>
					<!-- yin add: show error -->
					
				<div class="span7" id="newpost" style="margin-left:0px">
					<div class="well">
						Every time you sharing food, you will have a chance to gain more reputation.
					</div>
					
                    <c:forEach var="error" items="${errorList}">
						<div class="alert alert-error">
			            <button type="button" class="close" data-dismiss="alert">&times;</button>
			            <p>${error}</p>
			          </div> 
					</c:forEach>
             
				
					<form action="newpost.action" name="postform" id="postform">
					<div class="span1">
				 		<strong>*</strong>Food title:
				 	</div>
				 	<div class="span5">
				 		<input type="text" name="title" id="title" autocomplete="off"/>
				 	</div>
	
				 	<div class="row">
				 		<div class="span3" style="margin-top:20px"> <!--begin of a group of detail  -->
				 			<div class="span2">
						 		<strong>*</strong>Category:
						 	</div>
						 	<div class="span1" style="margin-top:5px;margin-bottom:5px;margin-left:45px">	
							   	<input type="radio" name="category" value="Love" checked autocomplete="off">
							   	<a id="love"><i class="icon-heart "></i>Slurp</a>
							 </div>
							 <div class="span1" style="margin-top:5px;margin-bottom:5px">	
							  	<input type="radio" name="category" value="Hate" autocomplete="off">
							  	<a id="hate"><i class="icon-heart-empty"></i>Vomit</a> 	
						 	</div>
				 			<div class="span1">
						 		<strong>*</strong>Price $:
						 	</div>
						 	<div class="span2">
						 		<input type="text" name="price" id="price" autocomplete="off"/>
						 	</div>
						 	<script type="text/javascript">
							 	$("#price").keyup(function(){  
	                               $(this).val($(this).val().replace(/[^0-9.]/g,''));  
	                               }).bind("paste",function(){  //CTR+V事件处理  
	                               $(this).val($(this).val().replace(/[^0-9.]/g,''));   
	                                }).css("ime-mode", "disabled"); //CSS设置输入法不可用 
						 	</script>
						 	<div class="span1">
						 		<strong>*</strong>Restaurant:
						 	</div>
						 	<div class="span2">
						 		<input type="text" name="restaurant" id="restaurant" autocomplete="off"/>
						 	</div>
						</div><!--end of a group of detail -->	
						<div class="span4" style="margin-top:20px">
					 		<strong>*</strong> Description:
					 	</div>
					 	<div class="span4" >
					 		<textarea type="text" name="description" id="description" rows="7" cols="10"/></textarea>
					 	</div>
					</div><!--end of row-->

					<div class="span1" style="margin-top:20px">
				 		Food tags:
				 	</div>
				 	<div class="span5" style="margin-top:20px">
				 		<input type="text" name="tags" id="tags" autocomplete="off" 
				 		value=""/>
				 	</div>
				 	
				 	<!-- food photo -->
				 	<div class="span1 " style="margin-top:20px">
				 		Upload Image:
				 	</div>
			 		<div class="span5" id="imgSection" style="margin-top:20px">
						<input type="file" id="imageLoader" name="imageLoader"/> 
						<canvas id="imageCanvas" style="height:220px; width:280px; border:1px solid #d3d3d3;"></canvas>
					 </div>
				 
			 		<!-- location -->
		 			<div class="span1" style="margin-top:20px">
				 		Location:
				 	</div>
				 	<div class="span2" style="margin-top:20px">
				 		<input type="text" name="location" id="location" autocomplete="off" style="width:200px"/>
				 	</div>
				 	<!-- <div class="span2" style="margin-top:20px;margin-left:50px">
				 		<button id="button" onClick="showMap()">Add to map</button>
				 	</div> -->
				 	<div class="span4 offset1">
		 				<img id="map" src="" style="height:220px; width:280px;">
		 			</div>
					
					 	<div class="span4 offset1" style="margin-bottom:20px; margin-top:20px">
					 		<button id="button">Post your food</button>
					 	</div>
					</form>	
					<!-- yin added: button -->
					<div class="span2" style="margin-top:-330px;margin-left:350px">
				 		<button id="button" onClick="showMap()">Add to map</button>
				 	</div>
				 	
				</div>
		</div><!--end of row-content -->
	</div> 	<!--end of post container -->  
	<script type="text/javascript">
		// initialize taglist from database
		var taglist = [];
		<c:forEach var="Tag" items="${tagList}">
			taglist.push('${Tag.tagname}');
		</c:forEach>

  		$(document).ready(function() {
	 		$("#tags").tagit({
    			availableTags: taglist
			});
		});
	</script>

	<footer>
		<div class="containter">
			<div class="span9 offset1" style="margin-top:20px">
				<hr>
				<p class="pull-left">Esay Eat 2013.</p>
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
 <script src="js/upload.js"></script>
</html>