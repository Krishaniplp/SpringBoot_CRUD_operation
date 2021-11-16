$(document).ready(function () { 
    $('#class-reg-form-submit').click( function(){
        registerClass();
    });
});

function registerClass(){

    let subject_name =  $("#class-reg-form-s-name").val();
    let teacher_name =  $("#class-reg-form-t-name").val();
    let grade = $("#class-reg-form-grade").val();

    event.preventDefault();
    $.ajax({
        url: "http://localhost:8080/classes?subject_name="+subject_name+"&teacher_name="+teacher_name+"&grade="+grade,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        success: function (res) {
            console.log(res);
            window.location.href = './index.html';
        },
        error: function(err){
            console.log(err);
        }
    });
}