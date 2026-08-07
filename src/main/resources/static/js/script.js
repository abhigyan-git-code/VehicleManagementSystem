function validateForm(){

let owner=document.getElementById("ownerName").value;

let number=document.getElementById("vehicleNumber").value;

if(owner===""){

alert("Owner Name Required");

return false;

}

if(number===""){

alert("Vehicle Number Required");

return false;

}

return true;

}