function validatePatForm() {
    var w = document.forms["PatientForm"]["pPatFirstN"].value;
    var x = document.forms["PatientForm"]["pPatLastN"].value;
    var y = document.forms["PatientForm"]["pPatAddress"].value;
    var z = document.forms["PatientForm"]["pPatEMail"].value;
    if (x == "" || x == null || y == "" || y == null || w == "" || w == null || z == "" || z == null) {
        alert("ALL Fields must be filled out");
        return false;
    }
}

function validatePatScheduleForm() {
    var a = document.forms["PatientScheduleForm"]["pAppDateTime"].value;
    var b = document.forms["PatientScheduleForm"]["ProcName"].value;
    var c = document.forms["PatientScheduleForm"]["dentId"].value;
    var d = document.forms["HiddenValueForm"]["pAccDtTime"].value;

    if (a == "" || a == null || b == "" || b == null || c == "" || c == null) {
        alert("ALL Fields must be filled out");
        return false;
    } else if (d != "") {
        alert("An appointment cannot be made until the initial appointment has been completed.");
        return false;
    }
}

/************************************************
 *DENTISTS FORM FILL CHECK
 *************************************************/

function validateDentistForm() {
    var x = document.forms["DentistForm"]["dFirstN"].value;
    var y = document.forms["DentistForm"]["dLastN"].value;
    var w = document.forms["DentistForm"]["deMail"].value;

    if (x == "" || x == null || y == "" || y == null || w == "" || w == null) {
        alert("ALL Fields must be filled out");
        return false;
    }
}