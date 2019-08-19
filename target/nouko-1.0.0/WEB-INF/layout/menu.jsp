<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


   <table class="menu">

     <tr>

       <td> 
			<p>
			    Voici le menu par defaut (qui sera remplace dans chaque cas par le menu du module)
			</p>
			
			<c:url var="MainPage"  value="/toMainPage" ></c:url>   		 	
  			<a href="${MainPage}">Main Page (page de bienvenue)</a>  
			
       </td>
     </tr>

   </table>
