<!-- createProduct.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url var="categoryValidationUrl" value="/ajaxvalidation/category?${_csrf.parameterName}=${_csrf.token}"/>

<div class="container"  style="margin-top:1%;border:4px solid #e5e5e5;border-radius:50px;box-sizing: border-box; background-color:GhostWhite;">

		<c:if test="${CRUDerrorMsg != null  && CRUDerrorMsg != ''}">
		<div class="alert alert-danger">
			<label  style="color:red;text-shadow: 2px 2px 4px #000000;">${CRUDerrorMsg}</label>
		</div>
		</c:if>

	<h3><spring:message code="prompt.product.creation"/></h3>

	<c:url var="adminPageUrl"  value="/forwardAdminPage/executeForward" ></c:url>
	<form:form modelAttribute="productForm" action="${adminPageUrl}" name="createProduct" method="POST" class="form-horizontal" >
   	    <form:hidden path="sourceview"  value="createProduct"/>

	  	<div class="form-group form-group-md">
	  	    <form:label path="categId" class="col-sm-3 control-label"><spring:message code="prompt.category.id"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="categId"  id="categIdcreateProduct"  size="10" maxlength="10" class="form-control" placeholder="category ID" required="required" min="100"/>
	    	</div>
	    	<form:errors path="categId" />
   	       	    	 	
	    	<div class="col-sm-3">
				<form:select path="categId" class="form-control"  onchange="fillCategoryId(this)"  >
					<form:option value="00">Select Category</form:option>
					<c:forEach items="${categoryList}" var="myCategory">
						<form:option value="${myCategory.categId}">${myCategory.categname}</form:option>
					</c:forEach>
				</form:select>	            		    	
	    	</div>
	  	</div>


	  	<div class="form-group form-group-md">
	  	    <form:label path="serialNumber" class="col-sm-3 control-label"><spring:message code="prompt.product.serialNumber"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="serialNumber"  size="18" maxlength="18" class="form-control" placeholder="serial number"  />
	    	</div>
	    	<form:errors path="serialNumber" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="prodname" class="col-sm-3 control-label"><spring:message code="prompt.product.name"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="prodname"  size="40" maxlength="50" class="form-control" placeholder="product name" required="required" />
	    	</div>
	    	<form:errors path="prodname" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="prodprice" class="col-sm-3 control-label"><spring:message code="prompt.product.price"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="prodprice"  size="10" maxlength="12" class="form-control" placeholder="product price" required="required" />
	    	</div>
	    	<form:errors path="prodprice" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="discountprice" class="col-sm-3 control-label"><spring:message code="prompt.product.discountprice"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="discountprice"  size="10" maxlength="12" class="form-control" placeholder="discount price"  />
	    	</div>
	    	<form:errors path="discountprice" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="stockQty" class="col-sm-3 control-label"><spring:message code="prompt.product.stockQty"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="stockQty"  size="6" maxlength="6" class="form-control" placeholder="stock qty"  />
	    	</div>
	    	<form:errors path="stockQty" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="type" class="col-sm-3 control-label"><spring:message code="prompt.product.type"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="type"  size="18" maxlength="18" class="form-control" placeholder="type"  />
	    	</div>
	    	<form:errors path="type" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="size" class="col-sm-3 control-label"><spring:message code="prompt.product.size"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="size"  size="12" maxlength="12" class="form-control" placeholder="size"  />
	    	</div>
	    	<form:errors path="size" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="color" class="col-sm-3 control-label"><spring:message code="prompt.product.color"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="color"  size="15" maxlength="15" class="form-control" placeholder="color"  />
	    	</div>
	    	<form:errors path="color" />
	  	</div>

	  	<div class="form-group form-group-md">
	  	    <form:label path="description" class="col-sm-3 control-label"><spring:message code="prompt.product.description"/>:</form:label>
	    	<div class="col-sm-4">
	    		<form:textarea path="description"   class="form-control"  />
	    	</div>
	    	<form:errors path="description" />
	  	</div>

		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-4">
				<input class="btn btn-success active" type="submit"  id="Create" value="Create" disabled>
				<input class="btn btn-default active pull-right" type="reset" value="Reset">
			</div>
		</div>	      	   
    </form:form>
</div>  



<script>
	
	$(document).ready(function() {
		
	    $("#categIdcreateProduct").change(function() {
	    	var valeur = $("#categIdcreateProduct").val() ;

	    	$.post("${categoryValidationUrl}",
	      		{
	    			categId: valeur
	      		},
	      		function(data,status){
	      				        		
	        		if(data != "success")
	        		{
	        			alert("catogory #" + valeur + " does not exist: Please enter a valid category Id");
	        		  	$("#categIdcreateProduct").val("");
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


