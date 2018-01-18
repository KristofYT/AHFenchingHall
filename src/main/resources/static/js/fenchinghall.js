// JavaScript Document
function menu(){
    console.log("menu");
    var li=document.getElementById("nav").getElementsByTagName("li");
    for(var i=0;i<li.length;i++){
        li[i].onmouseover=function(){
            this.className="navs";}
        li[i].onmouseout=function(){
            this.className="";}
    }
}