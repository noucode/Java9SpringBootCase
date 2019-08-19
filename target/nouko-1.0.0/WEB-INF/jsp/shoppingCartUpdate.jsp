<!-- shoppingCartUpdate.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


   	<h3>Shopping Cart Item to Change.</h3>
   			
   	<c:set var="TotalAmount" value="0"/>

	<display:table name="${singleShoppingCartLineItem}"  id="cartItem"  class="dataTable"  cellpadding="3" style="width: 100%;"  export="false"
		requestURI="/${aPath}"  pagesize="10">
	   	<display:setProperty name="paging.banner.item_name"><spring:message code="prompt.product"/></display:setProperty>
	   	<display:setProperty name="paging.banner.items_name"><spring:message code="prompt.products"/></display:setProperty>
	   	<display:setProperty name="paging.banner.no_items_found"><span class="pagebanner">None {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.one_item_found"><span class="pagebanner">One {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner">{0} {1} found in the Shopping Cart. Displaying all {2}.</span></display:setProperty>
	   	<display:setProperty name="paging.banner.some_items_found"><span class="pagebanner">{0} {1} found in the Shopping Cart. Displaying {2} to {3}...</span></display:setProperty>
	                             	                             
	    <display:setProperty name="sort.amount">list</display:setProperty>
	   	
	   	<display:column title=""  ><img src="${pageContext.request.contextPath}/${cartItem.product.imageLocations[0]}" alt="WMD" width="100" height="70" /></display:column>
	   	<display:column title="Product Name" href="/showProductDetail/showDetail" paramId="productId" paramProperty="product.productId" ><c:out value="${cartItem.product.prodname}"/></display:column>
	   	<display:column title="Unit Price">$<c:out value="${cartItem.product.prodprice}"/></display:column>
	   	<display:column title="Qty"><c:out value="${cartItem.quantity}"/></display:column>
	   	<display:column title="Total Amt">$<c:out value="${cartItem.product.prodprice * cartItem.quantity}"/> <c:set var="TotalAmount" value="${(cartItem.product.prodprice * cartItem.quantity) + TotalAmount}"/></display:column>   	
   	</display:table>
   	
   	
	<c:url var="urlShoppingCart"  value="/displayShoppingCart/displayCart" ></c:url>
	<c:url var="updateShoppingCartUrl" value="/updateCart/update"/>
	<form:form modelAttribute="productForm" action="${updateShoppingCartUrl}" name="shoppingCartUpdate"  method="POST"  class="form-horizontal" >
	    <form:hidden path="productId"  value="${productId}"/>
	    <form:hidden path="prodname"/>

	  	<div class="form-group form-group-md">
	  	    <form:label path="quantity" class="col-sm-3 control-label">New Quantity:</form:label>
	    	<div class="col-sm-4">
	    		<form:input path="quantity"  type="number" pattern="[0-9]{1,6}"  size="10" maxlength="12" class="form-control" placeholder="quantity"   min="0" max="999999" />

	    	</div>
	    	<form:errors path="quantity" />
	  	</div>
	     
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-4">
				<input class="btn btn-success active" type="submit" formaction="${updateShoppingCartUrl}"  value="<spring:message code='button.changeqty'/>">
				<input class="btn btn-warning pull-right" type="submit" value="Cancel"  formaction="${urlShoppingCart}" >
			</div>								
		</div>	      	   	    	    	    
      	      
   	</form:form>
   	
   	
   	
   	
      
   	
