<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template-top.jsp" />
   
<div class="container"> <!--begin of post-->
    <div class="row-content" style="margin-top:55px"> 
        <div class="span8"></div> 
    </div >
        <div class="row-content"> 
            <div class="span6 offset1" id="myposts" style="margin-top:35px" > <!--begin of post content -->
               <div class="span6" style="margin-top:30px"> 
                    <h4>${searchkey}</h4> 
                </div>
                <div class="span6" style="margin-top:9px;">
                    Related food list  
                </div> 
                <div class="span6" style="margin-top:-15px; margin-left:10px;">
                     <hr>  
                </div> 

                <c:set var="count" value="${0}"/>
                <c:forEach var="Post" items="${resultList}">              
                    <!-- start point -->
                    <div class="row"><!--begin of a food item -->    
                        <div class="span1" style="margin-left:35px; text-align:center"> <!--begin of vote -->
                            <c:choose>
                                <c:when test="${(resultFlagArray[count] == 0)||(resultFlagArray[count] == 2)}">
                                    <a class="icon" id="needtoVoteup" onClick="voteUpClick(${Post.postid})">
                                        <i class="icon-circle-arrow-up icon-2x"></i>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="icon" id="love" onClick="voteUpClick(${Post.postid})">
                                        <i class="icon-circle-arrow-up icon-2x"></i>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                                <h4 id="popularity">${Post.popularity}</h4>
                            <c:choose>
                                <c:when test="${(resultFlagArray[count] == 0)||(resultFlagArray[count] == 1)}">
                                    <a class="icon" id="needtoVotedown" onClick="voteDownClick(${Post.postid})">
                                        <i class="icon-circle-arrow-down icon-2x"></i>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="icon"  onClick="voteDownClick(${Post.postid})">
                                        <i class="icon-circle-arrow-down icon-2x"></i>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <c:set var="count" value="${count+1}"/>                   
                        </div><!--end of vote -->

                        <div class="span2" id="foodphoto" > <!--begin of photo -->
                            <a href="fooddetail.action?postid=${Post.postid}" id="foodphoto" rel="popover">
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
                            <a id="myref" href="fooddetail.action?postid=${Post.postid}">${Post.restaurant}</a>  <br>
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
                <c:choose>
                    <c:when test="${count==0}">
                        <div class="alert alert-error">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Opps</strong> no food has this key word.
                          </div> 
                    </c:when>
                </c:choose> 
    
                <div class="pagination pagination-centered pagination-small">
                 
                </div><!--end of pagination -->
            </div>
        
        <jsp:include page="template-side.jsp" />
    </div><!--end of row-content -->
</div>  <!--end of post container -->  
<jsp:include page="template-bottom.jsp" />