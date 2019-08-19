<!-- shoppingCart.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="list">
   	<h3>List of items in the Shopping Cart.</h3>

    <form:errors path="*" cssClass="errorBox" />
   	<c:set var="TotalAmount" value="0"/>

	<display:table name="${shoppingCartLineItems}"  id="cartItem"  class="dataTable"  cellpadding="3" style="width: 100%;"  export="false"
		requestURI="/${aPath}"  pagesize="10">
	   	<display:setProperty name="paging.banner.item_name"><spring:message code="prompt.product"/></display:setProperty>
	   	<display:setProperty name="paging.banner.items_name"><spring:message code="prompt.products"/></display:setProperty>
	   	<display:setProperty name="paging.banner.no_items_found"><span class="pagebanner">None {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.one_item_found"><span class="pagebanner">One {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner">{0} {1} found in the Shopping Cart. Displaying all {2}.</span></display:setProperty>
	   	<display:setProperty name="paging.banner.some_items_found"><span class="pagebanner">{0} {1} found in the Shopping Cart. Displaying {2} to {3}...</span></display:setProperty>              	                             
	    <display:setProperty name="sort.amount">list</display:setProperty>
	   	
	   	<display:column title=""  href="${pageContext.request.contextPath}/showProductDetail/showDetail" paramId="productId" paramProperty="product.productId" ><img src="${pageContext.request.contextPath}/${cartItem.product.imageLocations[0]}" alt="WMD" width="100" height="70" /></display:column>
	   	<display:column title="Product Name" href="${pageContext.request.contextPath}/showProductDetail/showDetail" paramId="productId" paramProperty="product.productId" ><c:out value="${cartItem.product.prodname}"/></display:column>
	   	<display:column title="Unit Price">$<c:out value="${cartItem.product.prodprice}"/></display:column>
	   	<display:column title="Qty"><c:out value="${cartItem.quantity}"/></display:column>
	   	<display:column title="Total Amt">$<c:out value="${cartItem.product.prodprice * cartItem.quantity}"/> <c:set var="TotalAmount" value="${(cartItem.product.prodprice * cartItem.quantity) + TotalAmount}"/></display:column>
	   	
	   	<display:column>
	      	<c:url var="suppression" value="/removeFromCart/executeRemove">
	         	<c:param name="productId" value="${cartItem.product.productId}"></c:param>
				<c:param name="origineAction" value="categoryListPage"></c:param>    
	      	</c:url>
	   	  	<a href="${suppression}" role="button"  class="btn btn-danger btn-xs"><c:out value="Remove"/></a>
	   	</display:column>
	   
	   	<display:column>
	      	<c:url var="modification" value="/changeQuantity/executeChange">
	         	<c:param name="productId" value="${cartItem.product.productId}"></c:param>
				<c:param name="quantity" value="${cartItem.quantity}"></c:param>    
	        </c:url>
	   	    <a href="${modification}" role="button"  class="btn btn-info btn-xs"><c:out value="Change Qty"/></a>
	   	</display:column>
   	</display:table>
	   	
	<c:if test="${!empty shoppingCartLineItems}">
	   	
	   	<hr/>
		Total Before Shipping and Tax:<span  style="color:purple;"> $<c:out value="${TotalAmount}"/> </span>     
	</c:if>
	     	 
	<hr/>
	  

	<c:url var="continueshoppingUrl" value="/continueshopping/executeShopping"/>
	<form:form modelAttribute="productForm" action="${continueshoppingUrl}" name="shoppingCart" >
	    <form:hidden path="productId"/>
	    <form:hidden path="prodname"/>
	    <input type="hidden" name="cartSubTotal"  value="${TotalAmount}"/>

		<input type="submit" formaction="${continueshoppingUrl}" name="continueshopping"  class="btn btn-success active"  value="<spring:message code='button.continueshopping'/>" />
    </form:form>
	
	<hr/>
	
		  
</div>  
	 

