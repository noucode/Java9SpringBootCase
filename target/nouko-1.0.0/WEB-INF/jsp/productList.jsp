<!-- productList.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="list">

		<c:if test="${CRUDerrorMsg != null  && CRUDerrorMsg != ''}">
		<div class="alert alert-danger">
			<label  style="color:red;text-shadow: 2px 2px 4px #000000;">${CRUDerrorMsg}</label>
		</div>
		</c:if>

   	<h3><spring:message code="prompt.product.list"/></h3>
   
   	<display:table name="${productList}" id="myProduct" class="dataTable" cellpadding="3"  style="width:100%; margin-left:0%; margin-right:0%; text-align:left;" 
                  export="false" requestURI="/${aPath}" pagesize="20" decorator="org.displaytag.decorator.TotalTableDecorator">
	   	<display:setProperty name="paging.banner.item_name"><spring:message  code="prompt.product"/></display:setProperty>
	   	<display:setProperty name="paging.banner.items_name"><spring:message  code="prompt.products"/></display:setProperty>
	   	<display:setProperty name="paging.banner.no_items_found"><span class="pagebanner">None {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.one_item_found"><span class="pagebanner">One {0}</span></display:setProperty>
	   	<display:setProperty name="paging.banner.all_items_found"><span class="pagebanner">{0} {1} found in the DB. Displaying all {2}.</span></display:setProperty>
	   	<display:setProperty name="paging.banner.some_items_found"><span class="pagebanner">{0} {1} found in the DB. Displaying {2} to {3}...</span></display:setProperty>
	                             	                             
	    <display:setProperty name="sort.amount">list</display:setProperty>
	   
	   	<display:column property="productId"  title="Product Id" sortable="true"/>
	   	<display:column property="categoryId"  title="Category Id" sortable="true"/>
	   	<display:column property="prodname"  title="Product Name" sortable="true" autolink="true"/>
	   	<display:column property="prodprice"  title="Price"/>
	   	<display:column property="stockQty"  title="Qty"/>
	   	<display:column property="size"  title="Size"/>
	   	
   	</display:table>
      
</div>


