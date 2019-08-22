<!-- addImageToProduct.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url var="productValidationUrl" value="/ajaxvalidation/product?${_csrf.parameterName}=${_csrf.token}"/>

<div class="container"  style="margin-top:1%;border:4px solid #e5e5e5;border-radius:50px;box-sizing: border-box; background-color:GhostWhite;">

	<h3><spring:message code="prompt.product.add.image" text="Add Image to Product Page" /></h3>

	<c:url var="adminPageUrl"  value="/forwardAdminPage/executeForward" ></c:url>
	<form:form  modelAttribute="fileUploadForm"  action="${adminPageUrl}" enctype="multipart/form-data" method="POST"  class="form-horizontal">

	  	<div class="form-group form-group-md">
	  	    <form:label path="productId" class="col-sm-3 control-label"><spring:message code="prompt.product.id"/>:</form:label>
	    	<div class="col-sm-6">
	    		<form:input path="productId"  id="productId"  size="10" maxlength="10" class="form-control" placeholder="product ID"   min="1000"/>
	    	</div>
	    	<form:errors path="productId" />
	  	</div>
 	
	  	<div class="form-group form-group-md">
	  	    <form:label path="formfile" class="col-sm-3 control-label"><spring:message code="prompt.product.image"/>:</form:label>
	    	<div class="col-sm-6">
	    		<form:input path="formfile"  type="file" size="50" maxlength="100" class="form-control" placeholder="image file" />
	    	</div>
	    	<form:errors path="formfile" />
	  	</div>
 	
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-6">
				<input class="btn btn-success active" type="submit" id="Create" value="Create" formaction="${adminPageUrl}" disabled>
				<input class="btn btn-danger pull-right" type="submit" value="Cancel"  formaction="${adminPageUrl}" >
			</div>								
		</div>	      	   	    	    		    	   	             
    </form:form>
</div>  
 

<script>
	
	$(document).ready(function() {
		
	    // check productId availability on change
	    $("#productId").change(function() {
	    	var valeur = $("#productId").val() ;

	    	$.post("${productValidationUrl}",
	      		{
	    			productId: valeur
	      		},
	      		function(data,status){
	      			
	        		if(data != "success")
	        		{
	        			alert("product Id #" + valeur + " does not exist: Please enter a valid product Id");
	        		  	$("#productId").val("");
	        			$("#Create").attr( "disabled", true );
	        			return false ;
	        		}	
	        		else
	        		{
	        			$( "#Create" ).attr( "disabled", false );
	        			return true ;
	        		}
	      		}
	    	);
		});
	    
	});
	
</script>


