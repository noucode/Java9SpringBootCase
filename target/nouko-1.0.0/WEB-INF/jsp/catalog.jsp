<!-- catalog.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="list">

   	<h3>List of Products in the Catalog.</h3>
   	
	<c:if test="${searchedProduct != '' && searchedProduct != null}">       				
	   <c:set var="searchedProduct" value="${searchedProduct}"/>
	</c:if>
   	 	
   	<display:table name="${productList}" id="myProduct" class="dataTable" cellpadding="3"  style="width:100%; margin-left:0%; margin-right:0%; text-align:left;" 
                  export="false" requestURI="/${aPath}" pagesize="10" decorator="org.displaytag.decorator.TotalTableDecorator">
	   	<display:setProperty name="paging.banner.item_name"><spring:message    code="prompt.product"/></display:setProperty>
	   	<display:setProperty name="paging.banner.items_name"><spring:message   code="prompt.products"/></display:setProperty>
	   	<display:setProperty name="paging.banner.no_items_found"><span class="pagebanner">None {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.one_item_found"><span class="pagebanner">One {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner">{0} {1} found in the Catalog. Displaying all {2}.</span></display:setProperty>
	   	<display:setProperty name="paging.banner.some_items_found"><span class="pagebanner">{0} {1} found in the Catalog. Displaying {2} to {3}...</span></display:setProperty>                             	                             
	    <display:setProperty name="sort.amount">list</display:setProperty>
	   
	   	<display:column title=""  href="/Spring4MavenEcommerce/showProductDetail/showDetail" paramId="productId" paramProperty="productId" ><img src="${pageContext.request.contextPath}/${myProduct.imageLocations[0]}" alt="WMD" width="100" height="70" /></display:column>
	   	<display:column property="productId"  title="Product Id" sortable="true" href="/Spring4MavenEcommerce/showProductDetail/showDetail" paramId="productId" paramProperty="productId" />
	   	<display:column property="prodname"  title="Product Name" sortable="true" href="/Spring4MavenEcommerce/showProductDetail/showDetail" paramId="productId" paramProperty="productId" />
	   	<display:column property="prodprice"  title="Price ($)" sortable="true"/>
	   	<display:column property="stockQty"  title="Stock Qty"/>

	   	<display:column>
			<c:url var="addtocartUrl" value="/addtocart/executeAdd">
	         	<c:param name="productId" value="${myProduct.productId}"></c:param>
				<c:param name="prodname" value="${myProduct.prodname}"></c:param>    
	      	</c:url>

      		<%-- SOLUTION 1: This link is programmed to add to my own shopping cart --%>
	   	  	<a href="${addtocartUrl}" role="button"  class="btn btn-info btn-xs active"><c:out value="Add to Cart"/></a>
	   	  	
	   	</display:column>	   	   
   	</display:table>
</div>
      


