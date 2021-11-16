$(document).ready(function () {
    $('#student-reg-form-submit').click( function(){
        registerStudent();
    });
});

function registerStudent(){

    let name =  $("#student-reg-form-name").val();
    let school = $("#student-reg-form-school").val();
    let grade = $("#student-reg-form-grade").val();
    let contactNumber = $("#student-reg-form-contact").val();

    event.preventDefault();
    $.ajax({
        url: "http://localhost:8080/student?name="+name+"&school="+school+"&grade="+grade+"&contactNumber="+contactNumber,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        success: function (res) {
            console.log(res);
            if (res === -1) {
                window.alert("User registration failed");
            } else {
                window.alert("User registration success\nStudent ID: " + res);
            }
            window.location.href = './index.html';
        },
        error: function(err){
            console.log(err);
        }
    });
}