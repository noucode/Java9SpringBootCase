<!-- productDetails.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Exposing some Java and Web Development skills">
	<meta name="author" content="Jean-Claude Nouko">     		
    <meta name="keywords"    content="Front-End Development with JavaScript frameworks (Ajax, Prototype, jQuery, Bootstrap, AngularJS, Node.js) and Web specific APIs (JSP, JSTL, EL),
    								  Back-End Development with Java EE, MVC frameworks (Struts, Hibernate and Spring) and web services (RESTful and SOAP-based),
                                    	  Database programming with SQL, Triggers and Stored Procedures.">                                     	  
	<title>Amazing Online Store</title>	
	

	<spring:url value="/resources/css/bootstrap.min.css" 	var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	
	<spring:url value="/resources/css/mainstylesheet.css"  var="mainstylesheetCss" />
	<link href="${mainstylesheetCss}" rel="stylesheet" />		
		    	
	<spring:url value="/resources/javascript/jquery-1.11.1.min.js"  var="jqueryJs" />
	<script src="${jqueryJs}"></script>
	
	<spring:url value="/resources/javascript/bootstrap.min.js"  var="bootstrapJs" />
	<script src="${bootstrapJs}"></script>

   	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
   	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
   	<!--[if lt IE 9]>
     	    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
     	    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
   	<![endif]-->
   	
</head>

<body>
	<div class="container">
		<h3><spring:message code="prompt.product.detail"/></h3>
	
	 	<div id="myCarousel" class="carousel slide" data-ride="carousel">
	   		<!-- Indicators -->
	   		<ol class="carousel-indicators"> 
	   		   		
				<c:forEach items="${imageList}" var="image" varStatus="status">					
					<c:choose>
						<c:when test="${status.index==0}"> 
							<li data-target="#myCarousel" data-slide-to="0" class="active" ></li>						
						</c:when>
						<c:otherwise>
							<li data-target="#myCarousel" data-slide-to="${status.index}"></li>
						</c:otherwise>
					</c:choose>		
				</c:forEach>		    		
	   		</ol>
	
	   		<!-- Wrapper for slides -->
	   		<div class="carousel-inner" role="listbox">
	   		
				<c:forEach items="${imageList}" var="image" varStatus="status">					
					<c:choose>
						<c:when test="${status.index==0}"> 
			      		    <div class="item active">
				     			<img src="${pageContext.request.contextPath}/${image}" alt="WMD" width="300" height="200"  align="middle"/>   
			      		    
				        		<div class="carousel-caption">
				          		    <h3>$ ${aProduct.prodprice}</h3>
				          		    <p>${aProduct.prodname}.</p>
				        		</div>
			      		    </div>													
						</c:when>
						<c:otherwise>
			      		    <div class="item">
				     			<img src="${pageContext.request.contextPath}/${image}" alt="WMD" width="300" height="200" />   
				        		<div class="carousel-caption">
				          		    <h3>$ ${aProduct.prodprice}</h3>
				          		    <p>${aProduct.prodname}.</p>
				        		</div>
			      		    </div>						
						</c:otherwise>
					</c:choose>										
				</c:forEach>		      		          		    
	   		</div>
	
			<%-- Left and right controls --%>	
	   		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	     		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	     		<span class="sr-only">Previous</span>
	   		</a>
	   		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	     		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	     		<span class="sr-only">Next</span>
	   		</a>
	 	</div>
	 		 	
 		<br>
 	 	
      	<div class="well" id="well">
	        <b><spring:message code="prompt.product.description"/>:</b>
	        <p class="text-muted">
	          	${aProduct.description}.  <br>
	          	(Only ${aProduct.stockQty} items left in our stock.)
	        </p>	        	        
      	</div>
 	 	 	
		<hr/> 	 	
	 	
	   	<%-- <c:url var="searchCatalogUrl" value="/searchCatalog/executeSearch"/> --%>
		<c:url var="continueshoppingUrl" value="/continueshopping/executeShopping"/>
		<c:url var="addtocartUrl" value="/addtocart/executeAdd"/>
		<form:form modelAttribute="productForm" action="${addtocartUrl}" name="productDetails" >
		    <form:hidden path="productId"/>
		    <form:hidden path="prodname"/>
		
			<input type="submit" formaction="${addtocartUrl}" name="addtocart"   class="btn btn-primary active " value="<spring:message code='button.addtocart'/>" />
			<%-- <input type="submit" formaction="${searchCatalogUrl}" name="findsimilar"  class="btn btn-default active" value="Find Similar Products" /> --%>
			<input type="submit" formaction="${continueshoppingUrl}" name="continueshopping"   class="btn btn-success pull-right" value="<spring:message code='button.continueshopping'/>" />		      	
	    </form:form>
					      	 	
		<hr/> 			
	</div>

</body>   
</html>
