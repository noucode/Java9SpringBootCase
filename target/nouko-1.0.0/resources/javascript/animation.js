
   // HOW TO PRELOAD IMAGES 

	var firstPic  = new Image();
	var secondPic = new Image();
	firstPic.src = "images/Epic22.jpg" ;
	secondPic.src = "images/Epic5.jpg" ;
	

	// SWAPPING ONE IMAGE FOR ANOTHER IMAGE IN JSP DEPENDING WHEN MOUSE OVER OR OUT
	/**
	   <table border="0" width=100%>
	      <tr bgcolor="gray">
	          <td align="center" width=50%> 
	              <a href="EnglishSite.html"  
		              onMouseOver="document.imageElement.src='images/Epic5.jpg'"
		              onMouseOut="document.imageElement.src='images/Epic22.jpg'"> 
	
		              <img name="imageElement"  src="images/Epic22.jpg" width="135" 
		              		height="180" border="0" alt="VISIT MY WEB SITE">        
	              </a>
	          </td>
	      <tr bgcolor="gray">
	   </table>
	*/