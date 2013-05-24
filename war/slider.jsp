
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div id="myslider" class="carousel slide" style="width:500px;">
	  <ol class="carousel-indicators">
	  	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	  	<c:set var="count" value="0"/>
	  	<c:forEach var="slides" items="${sliderList}">
		    <li data-target="#myCarousel" data-slide-to=${count}></li>
		</c:forEach>
	  </ol>
	  <!-- Carousel items -->
	  <div class="carousel-inner">
	  	 <div class="item active">
	    	<div class="pan2"> 
	    		<a><img class="slider" src="img/firstphoto.jpg" alt=""></a>
	    	</div>
	    	<div class="pan2"style="margin-top:-200px; margin-left:250px; 
	    	background-color:#F2F2F2; width:250px; height:200px">
	    		<a><img class="slider" src="img/secondphoto.jpg" alt=""></a>
	    	</div>
	    	
	    </div>
	  	<c:forEach var="slides" items="${sliderList}">
	    <div class="item">
	    	<div class="pan2"> 
	    		<a href="fooddetail.jsp"><img class="slider" src="${slides.photolink}" alt=""></a>
	    	</div>
	    	<div class="pan2"style="margin-top:-200px; margin-left:250px; 
	    	background-color:#F2F2F2; width:250px; height:200px">
	    		<table align="center" style="width:200px" >
	    			<tr>
	    				<td colspan="2" ><a id="myref" href="fooddetail.jsp" >
							<h4>${slides.title}</h4></a>
						</td>
	    			</tr>
                   <tr>
                       <td><i class="icon-money"> Price:</i></td>
                       <td><a id="myref">$${slides.price}</a> </td>
                   </tr>
                   <tr>
                       <td><i class="icon-food"> Restaurant:</i> </td>
                       <td><a id="myref">${slides.restaurant}</a> </td>
                   </tr>
                   <tr>
                   		<td><i class="icon-user"> User:</i></td>
						<td><a id="font" href="userinfo.jsp">${slides.user.firstname} ${slides.user.lastname}</a></td>	
                   </tr>
                   <tr>
                       <td colspan="2" ><p id="postdescribe"> ${slides.description} <p></td>
                   </tr>
               </table>
	    	</div>
	    </div>
	    </c:forEach>
	   </div>
	  <!-- Carousel nav -->
	  <a class="carousel-control left" href="#myslider" data-slide="prev">&lsaquo;</a>
	  <a class="carousel-control right" href="#myslider" data-slide="next">&rsaquo;</a>
</div> 