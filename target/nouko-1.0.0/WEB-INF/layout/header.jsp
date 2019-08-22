<!-- header.jsp -->
<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  		   	
	<spring:url value="/resources/css/header.css"  var="headerCss" />
	<link href="${headerCss}" rel="stylesheet" />
	
	<nav class="navbar navbar-default"  style="background-color:lavender; width:100%; height:100%;">
	  	<div class="container-fluid">
	  		
	       	<div class="navbar-header">	 
	        	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	           		<span class="sr-only">Toggle navigation</span>
	           		<span class="icon-bar"></span>
	           		<span class="icon-bar"></span>
	           		<span class="icon-bar"></span>
	         	</button>   	
	       	</div>	   	       		       	    	
		   			   	
	       	<div id="navbar" class="collapse navbar-collapse">	
		      	<ul class="nav navbar-nav">
		        	<li><a href="#"> <span class="sr-only">(current)</span></a></li>
		        	<li><a href="#"> <span class="sr-only">(current)</span></a></li>
		        </ul>	  
			    <div  class="text-center">		
			    	<h1  id="rotateX3D"  style="color:white;text-shadow: 3px 3px 6px #000000;"><strong>WELCOME TO THE ONLINE STORE ...</strong></h1>	 	
			    </div>		             	       			        			        
		   	</div> 
		  
	   	</div>   	  	
	</nav>
	
	<spring:url value="/resources/javascript/header.js"  var="headerJs" />
	<script src="${headerJs}"></script>
