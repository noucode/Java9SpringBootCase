	/** Retourne le formulaire de la page*/
	function getPageForm()
	{
	    try
	    {
	    	// Obtenir la page qui se trouve dans le body du tile (pageBody est l'id du body du tile dans mainBaseLayout.jsp)
		    var page = document.getElementById('pageBody') ;
		    
		    // Obtenir le form qui se trouve dans cette page
		    var myForm = page.getElementsByTagName('form')[0] ;
		    return myForm ;
	    }
	    catch(e)
	    {
		    return documents.forms[documents.forms.length-1] ;
	    }
	}  
	
	

	//  ====================================================================================	
	function fillCountry(elnt)
	{			
		var myCountryCode = document.getElementById('countryCode') ;  			
		var myCountry = document.getElementById('country') ;  
		
		var countryName = myCountryCode.options[myCountryCode.selectedIndex].innerHTML;		
		var countryCode = myCountryCode.options[myCountryCode.selectedIndex].value;

		var selectProvince = document.getElementById('canada') ;  	
		var selectState = document.getElementById('usa') ;
		
		myCountry.value = countryName;
		
		if(countryCode == "CA")
		{
			selectProvince.style.display = "inline";
			selectState.style.display = "none";
			selectProvince.value = "0" ;
			$('province').value = "";
		}	
		else if(countryCode == "US")
		{
			selectState.style.display = "inline";
			selectProvince.style.display = "none";		
			selectState.value = "0" ;
			$('province').value = "";
		}	
		else 
		{
			selectState.style.display = "none";
			selectProvince.style.display = "none";		
			$('province').value = "";
		}	
			
	}


	//  ====================================================================================	
	function fillProvince(elnt)
	{			
		var myProvince = document.getElementById('province') ;  
//		var myProvinceCode = document.getElementById('provinceCode') ;  
		
		var myCountryCode = document.getElementById('countryCode') ;  			
		var countryCodeValue = myCountryCode.value ;	
		var myProvinceCode ;  	
		// var countryValue = $F('countryCode') ;	
		
		
		if(countryCodeValue == "CA")
		{
			myProvinceCode = document.getElementById('canada') ;  
		}	
		else if(countryCodeValue == "US")
		{
			myProvinceCode = document.getElementById('usa') ;  
		}	
			
		var provinceName = myProvinceCode.options[myProvinceCode.selectedIndex].innerHTML;	
		
		// $('province').value = provinceName;
		myProvince.value = provinceName;
//		myProvinceCode.value = myProvinceCode.value ;  
	}
	
	

	//  ====================================================================================	
	function initSelectLists(countryCodeValue, provinceCodeValue)
	{			
		alert("countryCodeValue = " + countryCodeValue) ;
		alert("provinceCodeValue = " + provinceCodeValue) ;

		var myCountryCode = document.getElementById('countryCode') ;  			
		var myProvinceCode = document.getElementById('provinceCode') ;  
		myCountryCode.value = countryCodeValue ;  
		myProvinceCode.value = provinceCodeValue ;  
		
	}
	
	
	//  ====================================================================================	
 
	
	//  ====================================================================================	
	function fillCategoryId(elnt)
	{			
		var myCategory = document.getElementById('categIdcreateProduct') ;  
		
		myCategory.value = elnt.value;
	}
	
	
	//  ====================================================================================	
	function validDigit(elnt) 
	{
		var texte = elnt.value ;
		var dernierCaractere = texte.substr(texte.length-1,1) ;
				
		// Remplacer tous les caracteres qui ne sont pas des chiffres par un vide.			
	    if (isNaN(dernierCaractere)) 
	    {
	    	elnt.value=texte.substr(0,texte.length-1)+ "" ;
	    }
	} 
	
	
