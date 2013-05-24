<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template-top.jsp" />
    <div class="container" style="margin-top:60px"> <!--begin of post-->
         <div class="row"><!--begin of sub tab--> 
            <div class="span9 offset1">
                <div class="span1"> <h4>Tags</h4> </div>
                <div class="span6" style="margin-top:9px; margin-left:2px;">
                 (list by popularity)   
                </div> 
            </div> 
            <div class="span9 offset1" style="margin-top:-15px;">
                 <hr>  
            </div>

            <div class="span8 offset2">
                <p>A tag is a keyword or label that categorizes your question with other, similar questions. Using
                the right tags makes it easier for others to indentify your post.</p>
            </div>
            <div class="span8 offset2">
                <p></p>
            </div>
            <div class="span8 offset2">
                Type to find tags:
                <input type="search" name="searchtag" id="searchtag"/>
            </div>
            <div class="span8 offset2">
                <p></p> 
            </div>
            <div class="span8 offset2">
                <p></p> 
            </div>
        </div>  <!--/.row -->
        <div class="row-content">
            <div class="span8 offset2" id="tags"> <!--begin of tags -->
                <div class="row" id="initialtags">
                    <c:forEach var="Tag" items="${allTagList}">
                        <div class="span2"> <!--begin of a tag  --> 
                            <a href="searchtag.action?tagid=${Tag.tagid}" class="label label-important"> ${Tag.tagname} </a>
                            <p id="tagfont">${Tag.tagdesc}<p>
                             <hr>
                        </div><!--end of a tag -->
                    </c:forEach>
                </div><!--end of row-->
              
            </div><!--end of tags-->
            <div class="pagination pagination-centered pagination-small">
 
            </div><!--end of pagination -->
        </div><!--end of row-content -->
    </div>  <!--end of post container -->  
 
 <jsp:include page="template-bottom.jsp" />