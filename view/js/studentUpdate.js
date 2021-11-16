$(document).ready(function () { 
    $('#student-reg-form-submit').click( function(){
        updateStudent();
    });
});

function updateStudent(){

    let name =  $("#student-reg-form-name").val();
    let school = $("#student-reg-form-school").val();
    // let grade = JSON.parse(sessionStorage.getItem("grade"));
    let contactNumber = $("#student-reg-form-contact").val();
    let stdId = JSON.parse(sessionStorage.getItem("stdId"));

    event.preventDefault();
    $.ajax({
        url: "http://localhost:8080/student/"+ stdId +"?name="+name+"&school="+school+"&contactNumber="+contactNumber,
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        success: function (res) {
            console.log(res);
            window.location.href = './class.html';
        },
        error: function(err){
            console.log(err);
        }
    });
}