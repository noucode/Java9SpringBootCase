
var x, nx=0, rotXINT ;

$(document).ready(rotateXDIV);

function rotateXDIV(jQuery)
{
    x=document.getElementById("rotateX3D")
    clearInterval(rotXINT)
    rotXINT=setInterval("startXRotate()",10)
}

function startXRotate()
{
    nx=nx+1
    x.style.transform="rotateX(" + nx + "deg)"
    x.style.webkitTransform="rotateX(" + nx + "deg)"
    x.style.OTransform="rotateX(" + nx + "deg)"
    x.style.MozTransform="rotateX(" + nx + "deg)"
    if (nx==180 || nx>=360)
    {
	    // clearInterval(rotXINT)
	    // if (nx>=360){nx=0}
    }
}



var y, ny=0, rotYINT ;

$(document).ready(rotateYDIV);


function rotateYDIV(jQuery)
{
    y=document.getElementById("rotateY3D")
    clearInterval(rotYINT)
    rotYINT=setInterval("startYRotate()",10)
}

function startYRotate()
{
    ny=ny+1
    y.style.transform="rotateY(" + ny + "deg)"
    y.style.webkitTransform="rotateY(" + ny + "deg)"
    y.style.OTransform="rotateY(" + ny + "deg)"
    y.style.MozTransform="rotateY(" + ny + "deg)"
    if (ny==180 || ny>=360)
    {
	    // clearInterval(rotYINT)
	    // if (ny>=360){ny=0}
    }
}


