function showCoords(event) 
{
    var x = event.clientX;
    var y = event.clientY;
    var coords = "X coords: " + x + ", Y coords: " + y;
    console.log(coords);
}
document.addEventListener("click", function(e)
{
	var yuvi=e.target.nodeName;
	
	if(yuvi=="A")
	{
		console.log(e.target.getAttribute("href"));
	}
    console.log(yuvi);
    console.log("x and y coordinates");
    console.log(e.clientX+"   "+e.clientY);
});

document.addEventListener("scroll",function(e)

{

var elmnt=document.body;
	var st=elmnt.scrollTop;
	var sl=elmnt.scrollLeft;
    var ww=window.innerWidth;
	var wh=window.innerHeight;
//	console.log(st+"  "+sl+ "width" +ww+"  "+wh);
    set();
    i=0;
}	);
var i=0;
myfunction();
function myfunction()
{
i++;
setTimeout(myfunction,1000);
}
function set()
{
console.log("time:");
console.log(i);
}
