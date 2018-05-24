var oldOpen1 = 0;
function OpenClose1(CID)
{
    if (document.getElementById('C1_'+CID).style.display=="none")
    {
        if(oldOpen1 != 0){
            document.getElementById('C1_'+oldOpen1).style.display = "none";
            document.getElementById('CC1_'+oldOpen1).className = "hoverclose";
        }
        oldOpen1 = CID;
        document.getElementById('C1_'+CID).style.display = "";
        document.getElementById('CC1_'+CID).className = "hover";
    }else{
        document.getElementById('C1_'+CID).style.display = "none";
        document.getElementById('CC1_'+CID).className = "hoverclose";
        oldOpen1 = 0;
    }

}
var oldOpen2 = 0;
function OpenClose2(CID)
{
    if (document.getElementById('C2_'+CID).style.display=="none")
    {
        if(oldOpen2 != 0){
            document.getElementById('C2_'+oldOpen2).style.display = "none";
            document.getElementById('CC2_'+oldOpen2).className = "hoverclose";
        }
        oldOpen2 = CID;
        document.getElementById('C2_'+CID).style.display = "";
        document.getElementById('CC2_'+CID).className = "hover";

    }else{
        document.getElementById('C2_'+CID).style.display = "none";
        document.getElementById('CC2_'+CID).className = "hoverclose";
        oldOpen2 = 0;
    }

}