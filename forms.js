/************************************************
 *              ORDER FORM FILL CHECK
 *************************************************/
function validateOrderForm() {
    var w = document.forms["UpdateOrderForm"]["orderID"].value;
    var z = document.forms["UpdateOrderForm"]["orderStatus"].value;
    if (w === "" || w == null || z === "" || z == null) {
        alert("ALL Fields must be filled out");
        return false;
    } else {
        return true;
    }
}

/************************************************
*          CHECK FOR PROPER PROCESSOR ID NUM
 *          to LOCK OUT all other users!!!
 *************************************************/
function  validateUser() {
    const ID2 = "2";
    const  ID3 = "3";
    var processUserID = document.forms["ProcessorLoginForm"]["userID"].value;
    if(processUserID === ID2 ){
        return true
    } else if (processUserID === ID3){
        return true
    }else{
        alert("YOU ARE NOT ALLOWED TO ACCESS THIS PAGE")
        return false}
}

// ****************** This did not work for some reason ***************
//  function  validateUser() {
//     const ID2 = "2";
//     const  ID3 = "3";
//     var processUserID = document.forms["ProcessorLoginForm"]["userID"].value;
//     console.log(processUserID)
//     if(processUserID !== ID2 || processUserID !== ID3){
//         alert("YOU ARE NOT ALLOWED TO ACCESS THIS PAGE");
//         return false;
//         }
//     return true;
// }