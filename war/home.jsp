<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />
	<div class="container"> <!--began of sub bar  -->
	  	<div class="row" style="margin-top:60px">
	  		<div class="span5 offset5"> 
			   	<ul class="nav nav-pills">
			   		<c:choose>
						<c:when test="${category=='Love'}">
					       <li><a  class="mymenu" id="love"  href="display.action?category=Love&currTab=Top" rel="tooltip" >
					       			<i class="icon-heart icon-2x"></i>Slurp</a></li>
					       <li>
						       <a class="active" id="hate" href="display.action?category=Hate&currTab=Top">
						       		<i class="icon-heart-empty icon-2x"></i>Vomit
						       </a>
					       </li>
					   	</c:when>
						<c:otherwise>
							<li><a class="active"  id="love"  href="display.action?category=Love&currTab=Top" rel="tooltip" >
					       			<i class="icon-heart icon-2x"></i>Slurp</a></li>
					       <li>
						       <a class="mymenu" id="hate" href="display.action?category=Hate&currTab=Top">
						       		<i class="icon-heart-empty icon-2x"></i>Vomit
						       </a>
					       </li>
				       </c:otherwise>
					</c:choose>
			    </ul>
			</div>
		</div>	
	</div><!--end of sub bar  -->
	<div class="container"> <!--begin of post-->
		<div class="row-content">	
			<div class="span6 offset1"> <!--begin of post content -->
				<ul class="nav nav-tabs">
					<c:choose>
						<c:when test="${currTab=='Top'}">
			        		<li class="active" ><a href="display.action?category=${category}&currTab=Top">Top</a></li>
			        		<li><a class="mytab" href="display.action?category=${category}&currTab=New">New</a></li>
			        		<li><a class="mytab" href="display.action?category=${category}&currTab=Contro" >Controversial</a></li>
						</c:when>
						<c:when test="${currTab=='New'}">
			        		<li><a class="mytab" href="display.action?category=${category}&currTab=Top">Top</a></li>
			        		<li class="active"><a  href="display.action?category=${category}&currTab=New">New</a></li>
			        		<li><a class="mytab" href="display.action?category=${category}&currTab=Contro" >Controversial</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="mytab" href="display.action?category=${category}&currTab=Top">Top</a></li>
			        		<li><a class="mytab" href="display.action?category=${category}&currTab=New">New</a></li>
			        		<li class="active"><a  href="display.action?category=${category}&currTab=Contro" >Controversial</a></li>
						</c:otherwise>
					</c:choose>
			        
			    </ul>
	
			    <div id="myposts"> <!--begin of tab content-->
				    <div class="span5" style="margin-left:50px"><!--begin of slider-->
				    		<c:choose>
								<c:when test="${(category=='Love')&&(currTab=='Top')}">
									<jsp:include page="slider.jsp" />
								</c:when>
								<c:otherwise>
									<br><br>
								</c:otherwise>
							</c:choose>
					</div> <!--end of slider-->

					<div class="span5"><p></p> </div>
						
					<c:set var="count" value="${0}"/>
					<c:forEach var="Post" items="${postList}">
			 		<!-- start point -->
			 		<div class="row"><!--begin of a food item -->	 
				 		<div class="span1" style="margin-left:35px; text-align:center"> <!--begin of vote -->
				 			<c:choose>
					 			<c:when test="${(flagArray[count] == 0)||(flagArray[count] == 2)}">
									<a class="icon"  id="needtoVoteup" onClick="voteUpClick($(this),${Post.postid},${user.userid})">
										<i class="icon-circle-arrow-up icon-2x"></i>
									</a>
								</c:when>
								<c:otherwise>
									<a class="icon" id="votelove" onClick="voteUpClick($(this),${Post.postid},${user.userid})">
										<i class="icon-circle-arrow-up icon-2x"></i>
									</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
					 			<c:when test="${(flagArray[count] == 0)}">
									<h4 id="popularity" style="color:#6E6E6E">${Post.popularity}</h4>
								</c:when>
								<c:when test="${(flagArray[count] == 1)}">
									<h4 id="popularity" style="color:#B40404">${Post.popularity}</h4>
								</c:when>
								<c:otherwise>
									<h4 id="popularity" style="color:#3a87ad">${Post.popularity}</h4>
								</c:otherwise>
							</c:choose>
								
							<c:choose>
					 			<c:when test="${(flagArray[count] == 0)||(flagArray[count] == 1)}">
									<a class="icon"  id="needtoVotedown" onClick="voteDownClick($(this),${Post.postid},${user.userid})">
										<i class="icon-circle-arrow-down icon-2x"></i>
									</a>
								</c:when>
								<c:otherwise>
									<a class="icon" id="votehate" onClick="voteDownClick($(this),${Post.postid},${user.userid})">
										<i class="icon-circle-arrow-down icon-2x"></i>
									</a>
								</c:otherwise>
							</c:choose>
							<c:set var="count" value="${count+1}"/> 
							
				 			
						</div><!--end of vote -->
						<div class="span2" id="foodphoto" > <!--begin of photo -->
							<a href="fooddetail.action?postid=${Post.postid}" id="foodphoto">
								<img id="foodphoto" src="${Post.photolink}" alt="">
							</a>
						</div><!--end of photo -->
						<div class="span4" id="fooddescribe"> <!--begin of food description -->
							<div class="caption">
								<a id="myref" href="fooddetail.action?postid=${Post.postid}" >
									<h4>${Post.title}</h4>
								</a>
							</div>
						
							<div class="foodcontent">
								<p id="postdescribe">${Post.description}</p>
							</div>	
							<i class="icon-money"></i>
							<a id="myref" href="fooddetail.action?postid=${Post.postid}">$${Post.price}</a>	
							<i class="icon-food"></i>
							<a id="myref" href="fooddetail.action?postid=${Post.postid}">${Post.restaurant}</a>	<br>
							<i class="icon-user"></i>
							<a id="font" href="userinfo.jsp">${Post.user.firstname} ${Post.user.lastname}</a>			
							<i class="icon-time"></i>
							<a id="font" href="fooddetail.action?postid=${Post.postid}">${Post.createtime}</a>
						
							<p></p>
							<c:forEach var="Tag" items="${Post.tags}">
								<a href="searchtag.action?tagid=${Tag.tagid}" class="label label-important">${Tag.tagname}</a>
							</c:forEach>
						</div><!--end of food description -->
					</div><!--end of a food item -->
					<hr>
					</c:forEach>
					<div class="pagination pagination-centered pagination-small">
					 <c:choose>
						<c:when test="${category=='Love'}">
					        <% int postCount = (Integer)request.getAttribute("totalLovePosts");%>
						<ul>
						  <% 
					  		int pages = (int)java.lang.Math.ceil(((double)postCount)/15); 
					  		for(int i = 0; i < pages; i++ ){ 
					  		%>
					  		<li ><a href="display.action?category=${category}&currTab=${currTab}&page=<%=i%>"> <%= i+1 %> </a></li> 
					  	
						  <% }%>
						</ul>
					   	</c:when>
						<c:otherwise>
							 <% int postCount = (Integer)request.getAttribute("totalHatePosts");%>
						<ul>
						  <% 
					  		int pages = (int)java.lang.Math.ceil(((double)postCount)/15); 
					  		for(int i = 0; i < pages; i++ ){ 
					  		%>
					  		<li ><a href="display.action?category=${category}&currTab=${currTab}&page=<%=i%>"> <%= i+1 %> </a></li> 
					  	
						  <% }%>
						</ul>
				       </c:otherwise>
					</c:choose>
						
					</div><!--end of pagination -->
	    		</div><!--end of tab content-->	
			</div><!--end of post content-->

			<jsp:include page="template-side.jsp" />
		</div><!--end of row-content -->
	</div> 	<!--end of post container -->  
	<jsp:include page="template-bottom.jsp" />