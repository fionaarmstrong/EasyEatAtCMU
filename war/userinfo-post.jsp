<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />

	<div class="container"> <!--begin of post-->
		<jsp:include page="template-userinfo.jsp" />
		 <div class="row"><!--begin of sub tab--> 	
			<div class="span8 offset2">
			    <ul class="nav nav-tabs">
			       <li><a href="userinfo.jsp" >SUM</a></li>
			       <li class="active"><a href="userinfo-post.jsp">POST</a></li>
			       <li><a href="userinfo-comment.jsp">COMMENT</a></li>
			       <li><a href="userinfo-voteup.jsp">VOTE UP </a></li>
			       <li><a href="userinfo-votedown.jsp">VOTE DOWN</a></li>
			    </ul>
			 </div>
		</div>	<!--/.row -->
		<div class="row-content">
			<div class="span8 offset2" id="userinfotab"> <!--begin of summary -->
			 	<div class="row" id="userinfo" style="margin-top:20px">
			 		<div class="span2">
			 			<h4>20 Posts</h4>
			 		</div>
			 		<div class="span4 offset1"> 
					   	<ul class="nav nav-pills">
					       <li>
						       	<a class="mymenu" id="love" href="#" >
						       		newst <i class="icon-arrow-down"></i>
						       	</a>
					       </li>
					       <li><a class="mymenu" id="love" href="#">
					       		view <i class="icon-arrow-down"></i>
					       		</a>
					       	</li>
					       <li><a  class="mymenu" id="love" href="#">
					       		vote <i class="icon-arrow-down"></i>
					       		</a>
					       	</li>
					       <li><a class="mymenu" id="love" href="#">
					       		comment <i class="icon-arrow-down"></i>
					       		</a>	
					       </li>
					    </ul>
					</div>

					<div class="span8"><p></p></div>

					<div class="row" id="myapost" style ="margin-left:-50px"><!--begin of a food post -->	
						 <div class="span1" style ="margin-top:20px">
							<a id="love"><i class="icon-heart icon-2x"></i></a>
						</div>		 
						<div class="span1" id="postphoto" style="margin-left:-20px; margin-top: 5px;"> <!--begin of photo -->
							<a href="#" id="postphoto">
								<img id="postphoto" src="img/IMG_0202.JPG" alt="">
							</a>
						</div><!--end of photo -->

						<div class="span3">
							<a id="myref" href="postdetail.jsp" >
								<h4>Milk Chinese cabbage</h4>	
							</a>
							<p>
								<i class="icon-eye-open">820</i>
								<i class="icon-circle-arrow-up">410</i> 
								<i class="icon-circle-arrow-down">120</i>
								<i class="icon-comment">410</i> 
								<i class="icon-time">Sunday, April 7th</i>
							</p>
						</div>
						
						<div class="span2">
							<a href="tag.html" class="label label-important">Chinese</a>
							<a href="tag.html" class="label label-important">Vegetarian</a>
							<a href="tag.html" class="label label-important">dry</a>
							<a href="tag.html" class="label label-important">Vegetarian</a>
							<a href="tag.html" class="label label-important">dry</a>		
						</div>
						<button id="button" value ="X" style ="margin-left:30px; margin-top:10px; width:25px;height:25px" 
						onclick="deletePost();">X</button>	
						<div class="span7">
							<hr style =" margin-left:-20px;">
						</div>	
					</div><!--end of a food item -->
					

					<div class="row" style ="margin-left:-50px"><!--begin of a food item -->		
						<div class="span1" style ="margin-top:20px">
							<a id="hate"><i class="icon-heart-empty icon-2x"></i></a>
						</div>	 
						<div class="span1" id="postphoto" style="margin-left:-20px; margin-top: 5px;"> <!--begin of photo -->
							<a href="#" id="postphoto">
								<img id="postphoto" src="img/IMG_0202.JPG" alt="">
							</a>
						</div><!--end of photo -->

						<div class="span3">
							<a id="myref" href="postdetail.jsp" >
								<h4>Milk Chinese cabbage</h4>	
							</a>
							<p>
								<i class="icon-eye-open">820</i>
								<i class="icon-circle-arrow-up">410</i> 
								<i class="icon-circle-arrow-down">120</i>
								<i class="icon-comment">410</i> 
								<i class="icon-time">Sunday, April 7th</i>
							</p>
						</div>
						
						<div class="span2">
							<a href="tag.html" class="label label-important">Chinese</a>
							<a href="tag.html" class="label label-important">Vegetarian</a>
							<a href="tag.html" class="label label-important">dry</a>
							<a href="tag.html" class="label label-important">Vegetarian</a>
							<a href="tag.html" class="label label-important">dry</a>		
						</div>
						<button id="button" value ="X" style ="margin-left:30px; margin-top:10px; width:25px;height:25px">X</button>		
					</div><!--end of a food post -->
					<hr style =" margin-left:-60px;">

				</div><!--end of row-->
				<div class="pagination pagination-centered pagination-small">
					<ul>
						<li class="active"><a href="">1</a></li>
						<li><a href="###">2</a></li>
						<li><a href="###">3</a></li>
						<li><a href="###">4</a></li>
						<li><a href="###">5</a></li>
						<li class="next"><a href="###" title="older items">Next</a></li>
					</ul>
				</div><!--end of pagination -->
			</div><!--end of posts-->
		</div><!--end of row-content -->
	</div> 	<!--end of post container -->  
	<jsp:include page="template-bottom.jsp" />