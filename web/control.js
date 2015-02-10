/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function Chiffres(name) {
    var nn = name.value;
    // alert(nn);
    if (nn != "" && !/^[0-9]+(.[0-9])?$/.test(name.value)) {
        name.style.borderColor = "red";
        name.focus();
        return false;
    }
    return true;

}

function verif(name) {
    var ok = true;
    ok = ok && Chiffres(document.getElementById(name).value);
    return ok;
}
function PerdFocus(name) {
    name.style.borderColor = "lightgrey";
}

 