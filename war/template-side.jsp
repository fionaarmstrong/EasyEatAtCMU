<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="span4"><!--begin of side -->
	<div class="span4" id="newpostdiv">
		<br>
		<i id="font" >
			<a id="myref" >${totalUsers}</a> users have posted
			<a id="myref" >${totalPosts}</a> items
		</i>
		<ul class="nav nav-pills">
	       <li>
	       		<a class="mymenu" id="newpost"  href="enternewpost.action" >+ New Post</a>
	       	</li>
	    </ul>
	</div> 
	<div class="span4" id="populartag">
		<div class="row" id="populartagcontent">
			<div class="span3">
				<h5 id="font">Top 10 tags</h5>
			</div>
			<c:set var="count" value="0"/>
			<c:forEach var="Tag" items="${popularTagList}">
			<c:set var="count" value="${count+1}"/> 
				<div class="span3">	
					<table width="200" style="border-bottom:dashed 1px #6E6E6E;">
						<tr>
							<td width="15%">${count}</td>
							<td width="85%">
							<a href="searchtag.action?tagid=${Tag.tagid}" class="label label-important">${Tag.tagname}</a>
							</td>
						</tr>
					</table>
				</div>	
			</c:forEach>
		</div>	
	</div>

	<div class="span4" id="foodfanatic">
		<div class="row" id="foodfanaticcontent">
			<div class="span3">
				<h5 id="font">Food fanatic</h5>
			</div>
			<div class="span3">	
				 <div class="span1" style="margin-left:10px;">
                    <a href="userinfo.jsp">
                        <img id="userphotoicon" src="img/yinxu.jpg" alt="usrinfo.jsp">
                    </a>
                </div>
                <div class="span1" style="margin-left:-20px;margin-top:15px">
                    <a id="myref" href="userinfo.jsp">Yin Xu</a>
                </div> 
            </div>
			</div>	
		</div>	
	</div>
</div><!--end of side -->