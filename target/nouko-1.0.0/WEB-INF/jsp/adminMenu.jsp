<!-- adminMenu.jsp -->
<%@ page session="false"  isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


	         
    <div class="row">
		<div class="col-md-12">
		
	    	<br/>
  		    <div class="panel panel-default">
	    		<div class="panel-heading"><b>LIST</b></div>
				
	    		<br/>
			  	<!-- List group -->
				<c:url var="CategoryListPage"  value="/categoryListPage/executeList" ></c:url>
				<c:url var="ProductListPage"  value="/productListPage/executeList" ></c:url>
				
				<div class="panel-body">	
				    <a href="${CategoryListPage}" role="button"  class="btn btn-primary  btn-xs btn-block active">List All Categories</a>   
				    <a href="${ProductListPage}" role="button"  class="btn btn-primary  btn-xs btn-block active">List All Products</a>   
				</div>		
	    		<br/>
						
	    	</div>
	    	<br/>
	    	
    	</div>
    </div>
     
     
    <div class="row">
		<div class="col-md-12">
						
  		    <div class="panel panel-default">
	    		<div class="panel-heading"><b>EXIT</b></div>
				
	    		<br/>
				<c:url var="MainPage"  value="/forwardMainPage/executeForward" ></c:url>   		 	

				<div class="panel-body">	
					<a href="${MainPage}" role="button"  class="btn btn-danger btn-sm btn-block">Back to Home Page</a>		
				</div>	
	    		<br/>
				
	    	</div>
			
    	</div>
    </div>



