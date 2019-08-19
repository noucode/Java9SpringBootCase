

function changeStyle(elnt) {
	figcaptionElnts = elnt.getElementsByTagName("figcaption") ;
	imgElnts = elnt.getElementsByTagName("img") ;
	backside = elnt.getElementsByTagName("div") ;
	frontside = elnt.getElementsByTagName("span") ;

	figcaptionElnts[0].style.transform = "rotateY(0deg)";	
	frontside[0].style.display = "none";
	backside[0].style.display = "block";
}

function normalStyle(elnt) {
	figcaptionElnts = elnt.getElementsByTagName("figcaption") ;
	imgElnts = elnt.getElementsByTagName("img") ;
	backside = elnt.getElementsByTagName("div") ;
	frontside = elnt.getElementsByTagName("span") ;

	figcaptionElnts[0].style.transform = "rotateY(0deg)";	
	backside[0].style.display = "none";
	frontside[0].style.display = "block";
}
