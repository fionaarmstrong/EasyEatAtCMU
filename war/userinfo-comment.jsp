<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />

	<div class="container"> <!--begin of post-->
		 <jsp:include page="template-userinfo.jsp" />
		 <div class="row"><!--begin of sub tab--> 	
			<div class="span8 offset2">
			    <ul class="nav nav-tabs">
			       <li><a href="userinfo.jsp" >SUM</a></li>
			       <li><a href="userinfo-post.jsp">POST</a></li>
			       <li class="active"><a href="userinfo-comment.jsp">COMMENT</a></li>
			       <li><a href="userinfo-voteup.jsp">VOTE UP </a></li>
			       <li><a href="userinfo-votedown.jsp">VOTE DOWN</a></li>
			    </ul>
			 </div>
		</div>	<!--/.row -->
		<div class="row-content">
			<div class="span8 offset2" id="userinfotab"> <!--begin of summary -->
			 	<div class="row" id="userinfo" style="margin-top:20px">
			 		<div class="span2">
			 			<h4>10 Comments</h4>
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

					<div class="span8">
						<p></p>
					</div>

					<div class="row" id="myapost"><!--begin of a food item -->	 
						<div class="span1" id="postphoto"> <!--begin of photo -->
							<a href="#" id="postphoto" rel="popover">
								<img id="postphoto" src="img/IMG_0202.JPG" alt="">
							</a>
						</div><!--end of photo -->
						
						<div class="span3">
							<a id="myref" href="postdetail.jsp" >
								<h4>Milk Chinese cabbage</h4>	
							</a>
							<p>
								<i class="icon-comment">410</i> 
								<i class="icon-eye-open">820</i>
								<i class="icon-circle-arrow-up">410</i> 
								<i class="icon-circle-arrow-down">120</i>
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
						<div class="span1">
							<a id="love"><i class="icon-heart icon-2x"></i></a>
						</div>
					</div><!--end of a food item -->
					<hr>

					<div class="row" id="myapost"><!--begin of a food item -->	 
						<div class="span1" id="postphoto"> <!--begin of photo -->
							<a href="#" id="postphoto" rel="popover">
								<img id="postphoto" src="img/IMG_0202.JPG" alt="">
							</a>
						</div><!--end of photo -->
						
						<div class="span3">
							<a id="myref" href="postdetail.jsp" >
								<h4>Milk Chinese cabbage</h4>	
							</a>
							<p>
								<i class="icon-comment">410</i> 
								<i class="icon-eye-open">820</i>
								<i class="icon-circle-arrow-up">410</i> 
								<i class="icon-circle-arrow-down">120</i>
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
						<div class="span1">
							<a id="hate"><i class="icon-heart-empty icon-2x"></i></a>
						</div>
					</div><!--end of a food item -->
					<hr>

				</div><!--end of row-->
				<div class="pagination">
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