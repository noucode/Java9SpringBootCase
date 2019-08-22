<%@ page session="false" isELIgnored="false"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">     
	    <meta name="description" content="Exposing some Java and Web Development skills">
		<meta name="author" content="Jean-Claude Nouko"> 		  		
    	<meta name="keywords"    
	  	  	  content="Front-End Development with JavaScript frameworks (Ajax, Prototype, jQuery, Bootstrap, AngularJS, Node.js), 
    		   		Back-End Development with Java EE, MVC frameworks (Spring Struts, Grails and Django),
		   			Web Services (RESTful and SOAP-based) and DAO Layer with JDBC, Hibernate, SQL, Triggers and Stored Procedures.">                                     	  
		<title><tiles:getAsString name="title" /></title>	
		
		
		<spring:url value="/resources/css/mainstylesheet.css"  var="menuCss" />
		<link href="${menuCss}" rel="stylesheet" />
						
		<spring:url value="/resources/css/displaytagex.css"  var="displaytagexCss" />
		<link href="${displaytagexCss}" rel="stylesheet" />

		<spring:url value="/resources/css/mainPage.css"  var="mainPageCss" />
		<link href="${mainPageCss}" rel="stylesheet" />
			
		<spring:url value="/resources/css/bootstrap.min.css"  var="bootstrapCss" />
		<link href="${bootstrapCss}" rel="stylesheet" />

  		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">


		<spring:url value="/resources/javascript/myScript.js"  var="myScriptJs" />
		<script src="${myScriptJs}"></script>
			
		<spring:url value="/resources/javascript/prototype.js"  var="prototypeJs" />
		<script src="${prototypeJs}"></script>
		
		<spring:url value="/resources/javascript/RowHandlers.js"  var="RowHandlersJs" />
		<script src="${RowHandlersJs}"></script>

		<spring:url value="/resources/javascript/mainPage.js"  var="mainPageJs" />
		<script src="${mainPageJs}"></script>

		<spring:url value="/resources/javascript/prototype.js"  var="prototypeJs" />
		<script src="${prototypeJs}"></script>	

		<spring:url value="/resources/javascript/jquery-1.11.1.min.js"  var="jqueryJs" />
		<script src="${jqueryJs}"></script>
		
		<spring:url value="/resources/javascript/bootstrap.min.js"  var="bootstrapJs" />
		<script src="${bootstrapJs}"></script>
		
  		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

	
	   	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	   	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	   	<!--[if lt IE 9]>
	     	    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	     	    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	   	<![endif]-->	
	</head>

	<body>	
		<div class="container-fluid">
		
	  	    <div class="row" id="header">
	    		<div class="col-sm-12" style="background-color:lavender;"><tiles:insertAttribute name="header" /></div>
	  	    </div>
			  	    
	  	    <div class="row"  id="menuandbody">
	    		<div class="col-sm-2" style="background-color:silver;"><tiles:insertAttribute name="menu" /></div>
	    		<div class="col-sm-10" ><tiles:insertAttribute name="body" /></div>
	  	    </div>
	  	    			  	    	  	    
	  	    <div class="row" id="footer">
	    		<div class="col-sm-12" ><tiles:insertAttribute name="footer" /></div>
	  	    </div>	  	    
		</div>
	
	</body>
</html>
