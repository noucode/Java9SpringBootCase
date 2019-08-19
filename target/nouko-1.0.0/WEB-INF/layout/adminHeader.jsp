<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

		<nav class="navbar navbar-inverse">
		  	<div class="container-fluid">
		
		       	<div class="navbar-header">	 
		        	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		           		<span class="sr-only">Toggle navigation</span>
		           		<span class="icon-bar"></span>
		           		<span class="icon-bar"></span>
		           		<span class="icon-bar"></span>
		         	</button>
		       	        	
					<c:url var="HomePage"  value="/forwardMainPage/executeForward" ></c:url>
		         	<a class="navbar-brand" href="${HomePage}"><span class="glyphicon glyphicon-home"></span> Home Page</a>
		       	</div>	   	       		       	    	
			   	
			   	
		       	<div id="navbar" class="collapse navbar-collapse">	
					<div class="adminHeaderText">
						<h2 class="text-center">Application Administration</h2>
					</div>				    			        			          			      						
			   	</div> 
		   	</div>  
		</nav>
		