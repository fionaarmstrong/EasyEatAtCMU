<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />
   
    <div class="container"> <!--begin of post-->
        <div class="row-content"> 
            <div class="span4 offset1" style="margin-top:55px">
                <h3>${post.title}</h3>   
            </div> 
            <div class="span6" style="margin-top:70px">
                <c:choose>
                  <c:when test="${post.category=='Love'}">
                      <a id="love"><i class="icon-heart icon-2x"></i>(from Slurp)</a>&nbsp;
                  </c:when>
                  <c:otherwise>
                      <a id="hate"><i class="icon-heart-empty icon-2x"></i>(from Vomit)</a>&nbsp;
                  </c:otherwise>
                </c:choose>       
            </div>
            <div class="span9"><p></p></div>
            <div class="span5 offset1" id="fooddetail" style="margin-top:0px"><!--begin of post content -->   
                <img id="detailphoto" src="${post.photolink}" alt="###">   
                <div class="span3" style="margin-top:20px">
                    <i class="icon-circle-arrow-up" id="voteup">${numUpVote}</i>
                    <i class="icon-circle-arrow-down" id="votedown">${numDownVote}</i>
                    <i class="icon-comment" id="commentlist">${numComment}</i> 
                </div>
                <div class="span1 offset1" style="margin-top:20px">

                <c:choose>
                <c:when test="${(flag == 0)||(flag == 2)}">
                  <a class="icon" id="needtoVoteup" onClick="detailvoteUpClick($(this),${post.postid},${user.userid})">
                    <i class="icon-circle-arrow-up icon-2x"></i>
                  </a>
                </c:when>
                <c:otherwise>
                  <a class="icon" id="detaillove" onClick="detailvoteUpClick($(this),${post.postid},${user.userid})">
                    <i class="icon-circle-arrow-up icon-2x"></i>
                  </a>
                </c:otherwise>
              </c:choose>
                
              <c:choose>
                <c:when test="${(flag == 0)||(flag == 1)}">
                  <a class="icon" id="needtoVotedown" onClick="detailvoteDownClick($(this),${post.postid},${user.userid})">
                    <i class="icon-circle-arrow-down icon-2x"></i>
                  </a>
                </c:when>
                <c:otherwise>
                  <a class="icon" id="detailhate" onClick="detailvoteDownClick($(this),${post.postid},${user.userid})">
                    <i class="icon-circle-arrow-down icon-2x"></i>
                  </a>
                </c:otherwise>
              </c:choose>  
                </div>
             
                  <div class="span5" style="margin-top:20px">  <!--description from author-->
                    <p>${post.description}</p>
                </div>
               
                <div class="tabbable"> <!-- begi of comments  -->
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#comment" data-toggle="tab">Comment</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="comment">

                            <div class="span5"  name="newcomment" id="newcomment" style="margin-top:-20px;
                            margin-bottom:10px">
                                <a id="myref" href="userinfo.jsp" >${user.firstname} ${user.lastname}</a> <br>
                               <input type="text" name="inputcomment" id="inputcomment" style="width:350px;"
                                onkeyup="newcomment(${post.postid},'${user.firstname}','${user.lastname}',${user.userid});" 
                                placeholder="leave your comment here "/>
                            </div>
                            <!--end of one comment -->

                            <c:forEach var="Comment" items="${commentList}">
                                <div class="span5">  <!--begin of one comment -->
                                    <a id="myref" href="userinfo.jsp" >${Comment.user.firstname} ${Comment.user.lastname}</a>
                                    &nbsp;&nbsp;<i class="icon-time"></i>${Comment.createtime}
                                    <p>${Comment.content}</p>
                                </div>
                                <div class="span5" style="margin-top:-15px; margin-left:8px;">
                                    <hr>    
                                </div> <!--end of one comment -->
                            </c:forEach>
                            
                            <div class="pagination pagination-centered pagination-small">
                              <!--  -->
                            </div><!--end of pagination -->
                        </div>  
                    </div><!--end of table content --> 
                </div><!--end of tabbable -->      
            </div>

            <div class="span4" style="margin-left:-5px; margin-top:0px"><!--begin of subdetails -->
                <div class="span4" id="foodsubdetail">
                   <div class="row">
                        <div class="span1" style="margin-left:50px;">
                            <a href="userinfo.jsp">
                                <img id="userphotoicon" src="img/yinxu.jpg" alt="usrinfo.jsp">
                            </a>
                        </div>
                        <div class="span2" style="margin-left:-20px;margin-top:15px">
                            <a id="myref" href="userinfo.jsp">Yin Xu</a>
                        </div>
                       <table id="foodtable" style="margin-top:60px;margin-left:50px;">
                           <tr>
                               <td colspan="1"><i class="icon-money"> Price:</i></td>
                               <td><a id="myref">$${post.price}</a> </td>
                           </tr>
                           <tr>
                               <td colspan="1"><i class="icon-food"> Restaurant:</i> </td>
                               <td><a id="myref">${post.restaurant}</a> </td>
                           </tr>
                           <tr>
                               <td> <i class="icon-globe"> Location:</i></td>
                               <td><a id="myref">${post.location}</a> </td>
                           </tr>
                           <tr>
                                <td  colspan="2">
                                    <img src="${mapSrc}" style="width:200px;height:130px" /> 
                                </td>    
                           </tr>
                       </table>

                       <div class="span3" style="margin-left:50px;margin-top:15px">
                        <!-- <a href="tag.html" class="label label-important"></a> -->
                            <c:forEach var="Tag" items="${post.tags}">
                                <a href="searchtag.action?tagid=${Tag.tagid}" class="label label-important">${Tag.tagname}</a>
                            </c:forEach>
                        </div>    
                    </div> <!--end of row -->
                </div> <!--end of subdetail 1-->

                 <div class="span4" id="foodsubdetail" style="margin-top:15px">
                    <h5 id="font" style="margin-left:30px;margin-top:15px">Similar food</h5>
                    <c:choose>
                      <c:when test="${hasSimilar==1}">
                    <table id="foodtable" style="margin-top:20px;margin-left:20px;">
                           <tr>
                               <td colspan="2"><a id="myref" href="fooddetail.action?postid=${similarPost.postid}">${similarPost.title}</td>
                           </tr>
                            <tr>
                               <td><i class="icon-money"> Price:</i></td>
                               <td><a id="myref">$${similarPost.price}</a> </td>
                           </tr>
                           <tr>
                               <td><i class="icon-food"> Restaurant:</i> </td>
                               <td><a id="myref">${similarPost.restaurant}</a> </td>
                           </tr>
                           <tr>
                               <td> <i class="icon-globe"> Location:</i></td>
                               <td><a id="myref">${similarPost.location}</a> </td>
                           </tr>
                           <tr>
                              <td colspan="2">
                                  <img src="${similarPost.photolink}" style="width:200px;height:130px" /> 
                              </td>    
                           </tr>
                       </table> 
                       </c:when>
                       <c:otherwise>
                          <div class="alert alert-info">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>Opps!</strong> No similar food.
                          </div>
                       </c:otherwise>
                      </c:choose>  
                       <div class="span3" style="margin-left:20px;margin-top:15px">
                        <a href="tag.html" class="label label-important"></a>
                             <c:forEach var="Tag" items="${similarPost.tags}">
                                    <a href="tag.html" class="label label-important">${Tag.tagname}</a>
                              </c:forEach></td>
                        </div>   
                 </div>
            </div><!--subdetails -->
        </div><!--end of row-content -->
    </div>  <!--end of post container -->  
    <jsp:include page="template-bottom.jsp" />