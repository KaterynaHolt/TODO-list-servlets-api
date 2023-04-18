function validateForm() {
    var text = document.forms["form"]["text"].value;
    var date = document.forms["form"]["date"].value;
    var status = document.forms["form"]["status"].value;
    var priority = document.forms["form"]["priority"].value;
    var tags = document.forms["form"]["tags"].value;
    if ((status == "") || (priority == "") || (tags == "") || (text == "") || (text == "  ") || (date == "") ) {
        alert("You haven't filled all fields!");
        return false;
    }
}