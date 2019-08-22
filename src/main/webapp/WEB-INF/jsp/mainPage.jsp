<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<spring:url value="/resources/css/bootstrap.min.css"  var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	
	<spring:url value="/resources/css/mainstylesheet.css"  var="mainstylesheetCss" />
	<link href="${mainstylesheetCss}" rel="stylesheet" />

	<spring:url value="/resources/css/mainPage.css"  var="mainPageCss" />
	<link href="${mainPageCss}" rel="stylesheet" />

   	
	<c:if test="${searchedProduct != '' && searchedProduct != null}">       				
	   <c:set var="searchedProduct" value="${searchedProduct}"/>
	</c:if>
	
	<div class="list">
   		<h3>List of Products in the Catalog.</h3>
	</div>

	<div class="jumbotron text-center">		
		<div class="container">		
		<div id="complex3D">
	
		  	          	           			    
			<c:forEach var="myProduct" items="${productList}" varStatus="status">
			    <c:url var="addtocartUrl" value="/addtocart/executeAdd">
		    		<c:param name="productId" value="${myProduct.productId}"></c:param>
		    		<c:param name="prodname" value="${myProduct.prodname}"></c:param>    
	      		</c:url>
				<c:url var="showProductDetailUrl" value="/showProductDetail/showDetail">
		         	<c:param name="productId" value="${myProduct.productId}"></c:param>
					<c:param name="prodname" value="${myProduct.prodname}"></c:param>    
		      	</c:url>			    
			    <spring:url value="/${myProduct.imageLocations[0]}"  var="productImageUrl" />
			    <figure onmouseover="changeStyle(this)" onmouseout="normalStyle(this)">
			   	  	<a href="${showProductDetailUrl}" ><img src="${productImageUrl}" alt="${myProduct.prodname}"  align="left" /></a>
					<figcaption>
		   				<a href="${addtocartUrl}" role="button"  class="btn btn-success btn-xs active pull-left">Add to Cart</a>
						<a href="${showProductDetailUrl}" role="button"  class="btn btn-info btn-xs pull-right">View Details</a>
					    <c:out value="${myProduct.prodname} for $${myProduct.prodprice}"/>					    					    
					</figcaption>
			    </figure>
			</c:forEach>	
	        	  				  
		</div>
		</div>
	</div>
	
					
	<spring:url value="/resources/javascript/prototype.js"  var="prototypeJs" />
	<script src="${prototypeJs}"></script>	
			    	
	<spring:url value="/resources/javascript/jquery-1.11.1.min.js"  var="jqueryJs" />
	<script src="${jqueryJs}"></script>
	
	<spring:url value="/resources/javascript/bootstrap.min.js"  var="bootstrapJs" />
	<script src="${bootstrapJs}"></script>

	<spring:url value="/resources/javascript/mainPage.js"  var="mainPageJs" />
	<script src="${mainPageJs}"></script>
	