<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template-top.jsp" />
    <div class="container" style="margin-top:60px"> <!--begin of post-->
         <div class="row"><!--begin of sub tab--> 
            <div class="span8 offset1">
                <div class="span1"> <h4>Users</h4> </div>
                <div class="span6" style="margin-top:9px; margin-left:2px;">
                 (list by reputation)   
                </div> 
            </div> 
            <div class="span9 offset1" style="margin-top:-15px;">
                 <hr>  
            </div>
            <div class="span8 offset2">
                Type to find user:
                <input type="search" name="searchuser" id="searchuser" autocomplete="off"/>
            </div>
            <div class="span8 offset2">
                <p></p> 
            </div>
            <div class="span8 offset2">
                <p></p> 
            </div>
        </div>  <!--/.row -->
        <div class="row-content">
            <div class="span8 offset2"> <!--begin of users -->
                <div class="row">
                    <div class="span2"> <!--begin of a user  -->
                        <div class="row">
                            <div class="span1">
                                <a href="userinfo.jsp"><img id="userphoto" src="img/yinxu.jpg" alt="###"></a>
                            </div>
                            <div class="span1" style="margin-left:5px;">
                                <a id="myref" href="userinfo.jsp">Yin Xu</a>
                                <h5 id="font" style="margin-top:3px;">2,130<h5>
                                <p id="tagfont" style="margin-top:-7px;">Chinese,dry,spicy</p>
                            </div>
                        </div>    
                    </div><!--end of a user -->

                    
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
            </div><!--end of users-->
        </div><!--end of row-content -->
    </div>  <!--end of post container -->  
    <jsp:include page="template-bottom.jsp" />