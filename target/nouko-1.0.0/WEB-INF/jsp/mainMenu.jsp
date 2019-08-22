<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



	<c:url var="departmentSelectionUrl" value="/departmentSelection/selectDepartments"/>
	<c:url var="categorySelectionUrl" value="/categorySelection/selectCategories"/>
     
 	    	<br/>
    <div class="row">
		<div class="col-md-12">		
	    	<br/>
			
  		    <div class="panel panel-default">
	    		<div class="panel-heading">
				    <b>Catalog Options</b>
				</div>
				<div class="panel-body">										
					<c:url var="displayCatalogUrl" value="/forwardMainPage/executeForward"/>
					<c:url var="selectCatalogUrl" value="/selectCatalog/listCatalog"/>
			   		<form:form modelAttribute="catalogForm"  action="${selectCatalogUrl}"  name="mainMenu" method="GET"	>
						    							    		    	        		    								        		
		        		<div class="form-group form-group-md">
		       				<label for="idDepartment"> List Catalog By Category:</label>
							<select name='idCategory' id='idCategory' class="form-control input-sm"  onchange='remplirChamps(this); clickButtonSelection();'>
								<option value='-1'>None</option>
							</select>
		        		</div>
		        					        					        			    
		           		<div style="text-align:center;">OR</div>
		           		<button type="submit" class="btn btn-success btn-xs btn-block active"  style="display: none;"  formaction="${selectCatalogUrl}" id="btnS" >Display Selection</button>
		           		<button type="submit" class="btn btn-success btn-xs btn-block active"  formaction="${displayCatalogUrl}" >Display All Catalog</button>
								    
						<!--  categId and are populated by the JavaScript function remplirChamps()  -->		
						<input type="hidden" name="categId" id="categId" /> 
						<input type="hidden" name="categname" id="categname"  />			 				
		       		</form:form>
				</div>
	    	</div>			
    	</div>
    </div>

     
    <div class="row">
		<div class="col-md-12">
		
  		    <div class="panel panel-default">
	    		<div class="panel-heading">
				    <b><span class="glyphicon glyphicon-shopping-cart"></span> Cart Summary</b>
				</div>
				<div class="panel-body">
													
			    	<span class="text-muted"><c:out value="${cartItemNumber} item(s) added to cart "/></span>  <br/>
			    	<span class="text-muted"><c:out value="Subtotal: $ ${cartSubtotal} "/></span>  <br/>
			    									  	
					<c:url var="urlShoppingCart"  value="/displayShoppingCart/displayCart" ></c:url>
			        <a href="${urlShoppingCart}"  role="button"  class="btn btn-primary btn-xs btn-block active" >View Shopping Cart </a>										
					
				</div>
				
	    	</div>
    	</div>
    </div>

     
    <div class="row">
		<div class="col-md-12">
		
  		    <div class="panel panel-default">
	    		<div class="panel-heading">
				    <b>Admin Menu</b>
				</div>
				<div class="panel-body">
														
					<c:url var="adminPageUrl"  value="/forwardAdminPage/executeForward" ></c:url>
					<a href="${adminPageUrl}" role="button"  class="btn btn-warning btn-sm btn-block active">Admin Page</a>	
		
				</div>
	    	</div>
    	</div>
    </div>


	
	<script type='text/javascript'>

	 	ajaxRequest() ;
	 	
		function ajaxRequest()
		{	
			var url="${categorySelectionUrl}";
			var pars = 'q=' + 'any' + '&sid=' + Math.random();
				
			var ajaxRequestObject = new Ajax.Request(
				url, 
				{
					method: 'get', 
					parameters: pars,
					onComplete: showResponse
				}
			);
		}
		
		function showResponse(xhr)
		{
			// reception de JSON deja parsee
			var jsonData = xhr.responseText.evalJSON();	 				
			populateJSON(jsonData); 
		}

		
		function populateJSON(jsonData)
		{
			var mySelectCategory = document.getElementById('idCategory') ;  
			var myJSONObject = jsonData ;  
	
			// purger la liste deroulante
			RemoveAllChildren();
	
			// CREATION DE LA 1ere OPTION DE LA LISTE DEROULANTE
			var myOption0 = document.createElement('option');
							
			// creation du text node de la 1ere option 
			var myTextNode0 = document.createTextNode("Select a Category ");  			
				
			// La 1ere option a la valeur 0  			
			myOption0.value = "0" ;
			
			// Ajout text node dans 1ere option  			
			myOption0.appendChild(myTextNode0);
			
			//Ajout 1ere option dans le select
			mySelectCategory.appendChild(myOption0); 
	
			// parcourir tous les Objets Category, extraire les proprietes categId et categname et les inserer dans la liste deroulante.	
			for (i=0; i<myJSONObject.category.length; i++)
			{				
				// CREATION DES AUTRES OPTIONS DE LA LISTE DEROULANTE
				var myOption = document.createElement('option');
	
				if (i%2==0)  myOption.className = "EvenRow";
				else		 myOption.className = "OddRow";
				
				// creation des text nodes avec leur valeurs
				var myTextNode = document.createTextNode(myJSONObject.category[i].categname);  			
					
				// ajout des valeurs aux options 			
				myOption.value = myJSONObject.category[i].categId ;
	
				// ajout des text nodes aux options 			
				myOption.appendChild(myTextNode);
	
				//Ajout des options dans le select
				mySelectCategory.appendChild(myOption); 
			}
		}

		//  ====================================================================================	
		function RemoveAllChildren()
		{ 
			var mySelectCategory = document.getElementById('idCategory') ;  
			
		 	// qd on supprime childNodes[0], un autre childNodes[0] prend sa place. Il faut donc supprimer jusqu'a ce qu'il n'y en ait plus
			while (mySelectCategory.hasChildNodes())
				mySelectCategory.removeChild(mySelectCategory.childNodes[0]);
		}


		//  ====================================================================================	
		function remplirChamps(elnt)
		{			
			var myCategId    = document.getElementById('categId') ;  
			var myCategname = document.getElementById('categname') ;  
			var mySelectCategory = document.getElementById('idCategory') ;  			
			var categIdChosen = mySelectCategory.options[mySelectCategory.selectedIndex].value;
			var categnameChosen = mySelectCategory.options[mySelectCategory.selectedIndex].innerHTML;

			myCategId.value = categIdChosen ;
			myCategname.value = categnameChosen ;
		}
		
		
		//  ====================================================================================	
		function clickButtonSelection()
		{
			document.getElementById('btnS').click() ;
		}
		

	</script>
   
   
   
   
   
   
