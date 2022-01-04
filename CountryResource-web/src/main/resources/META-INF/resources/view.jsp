<%@ include file="init.jsp"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.serve.resource.service.ContinentLocalServiceUtil"%>
<%@page import="com.liferay.serve.resource.model.Continent"%>
<%@page import="java.util.List"%>

<!-- //Creating Resource URL for serverResource method(Ajax call) -->

<portlet:resourceURL id="/serveResource" var="resourceURL" ></portlet:resourceURL>
<!-- // to fetch list of continet from contient table -->


<aui:form>
		<aui:select id="continent" name="continent">
			<c:if test="${not empty continent}">

				<c:forEach items="${continent}" var="continent">

					<aui:option value="${continent.continentCode}">${continent.continentName}</aui:option>

				</c:forEach>
			</c:if>
		</aui:select>
		<aui:select id="country" name="country"/>
		<aui:select id="states" name="states"></aui:select>
</aui:form>
<!-- //Aui Script for Ajax Call -->
<aui:script>

AUI().ready('aui-base','io','aui-io-request', 
		function(A){
    	A.one("#<portlet:namespace />continent").on('change',function(){       
        		A.io.request("<portlet:resourceURL id="/serveResource"></portlet:resourceURL>",
                {
			 method: 'POST',
             data: { 
                         '<portlet:namespace />continentCode' : A.one("#<portlet:namespace />continent").val(),
                          '<portlet:namespace />continentSelected' :"continentSelected"
                    },
			 dataType: 'json',
             on: {
             		success: function() {
               				var countriesList =this.get('responseData');  
							console.log(countriesList);
             				A.one("#<portlet:namespace />country").empty();
             				A.one("#<portlet:namespace />states").empty();
      					    for(var i in countriesList){
               							A.one("#<portlet:namespace />country").append("<option value='"+ countriesList[i].countryCode +"'>"+countriesList[i].countryList+"</option> ");
             											}
           								}
                 }
           		 }				
                			);
            															}
            										);
    	A.one("#<portlet:namespace />country").on('change',function(){
       			A.io.request("<portlet:resourceURL id="/serveResource"></portlet:resourceURL>",
                  {
 			method :'POST',
            data: {			
            				'<portlet:namespace />countrySelectedCode' : A.one("#<portlet:namespace />country").val() ,
            	  		    '<portlet:namespace />countrySelected' : "countrySelected"
            	   },
            dataType: 'json',
            on:{
						 success: function(){
	 						 var statesList2 = this.get('responseData');
			                 console.log(statesList2);
			                 A.one("#<portlet:namespace />states").empty();
			                 for(var i in statesList2){
                       				    A.one("#<portlet:namespace />states").append("<option value='"+ statesList2[i].statesList3 +"'>"+statesList2[i].statesList3+"</option> ");
         
         											 }
     										}
     			}
 
         
				}           
							);

										                             } 
					                            );
			}
		);

</aui:script>

 