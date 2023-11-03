/**
 * 
 */

/* tắt mở cái more bên phải */

var profileRightElement = document.getElementsByClassName("profile-right")[0];
console.log(profileRightElement)
function showDiv(divClassName) {
    var x = document.getElementsByClassName(divClassName)[0];
    if(x.style.visibility=="visible") {
        x.style.visibility = "hidden";
    } else {
        x.style.visibility = "visible";
    }
}