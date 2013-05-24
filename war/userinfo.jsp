<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />

	<div class="container"> <!--begin of post-->
		 <jsp:include page="template-userinfo.jsp" />
		 <div class="row"><!--begin of sub tab--> 	
			<div class="span8 offset2">
			    <ul class="nav nav-tabs">
			       <li class="active"><a href="#SUM" >SUM</a></li>
			       <li><a href="userinfo-post.jsp">POST</a></li>
			       <li><a href="userinfo-comment.jsp">COMMENT</a></li>
			       <li><a href="userinfo-voteup.jsp">VOTE UP </a></li>
			       <li><a href="userinfo-votedown.jsp">VOTE DOWN</a></li>
			    </ul>
			 </div>
		</div>	<!--/.row -->
		<div class="row-content">
			<div class="span8 offset2" id="userinfotab"> <!--begin of summary -->
			 	<div class="row" id="userinfo">
			 		<div  class="span3"> <!--begin of post summary -->
			 			<h4>12 POST</h4>
			 			<hr>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<a id="myref">view more</a>
					</div><!--end of post summary -->
					<div  class="span3"> <!--begin of comment summary -->
			 			<h4>20 COMMENT</h4>
			 			<hr>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<a id="myref">view more</a>
					</div><!--end of comment summary -->
					<div class="span3" style="margin-top:30px"> <!--begin of vote up summary -->
			 			<h4>40 VOTE UP</h4>
			 			<hr>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<a id="myref">view more</a>
					</div><!--end of vote up summary -->
					<div class="span3" style="margin-top:30px"> <!--begin of vote down summary -->
			 			<h4>30 VOTE DOWN</h4>
			 			<hr>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<p><a id="mypostref" href="#">1. Wonderful fish</a></p>
			 			<a id="myref">view more</a>
					</div><!--end of vote down summary -->
				</div><!--end of row-->
			</div><!--end of summary-->
		</div><!--end of row-content -->
	</div> 	<!--end of post container -->  
	<jsp:include page="template-bottom.jsp" />