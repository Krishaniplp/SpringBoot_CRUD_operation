$(document).ready(function () { // this waits until the document is fully loaded
    $.ajax({
        url: "http://localhost:8080/classes",
        type: 'GET',
        contentType: "application/json",
        cache: false,
        crossDomain: true,
        success: function (res) {
            console.log(res);
            var content = "";
            var count = Object.keys(res).length;
            for (let i = 0; i < count/4; i++) {
                content = content + '<div class="row" style="margin-top: 10px; margin-bottom: 10px">';
                for (let j=0; j<4 && j<count-i*4; j++) {
                    content = content + 
                    '<div class="col-md-3">' +
                        '<div id="class" class="card" onclick="classClicked('+ res[i+j].id + ',' + res[i+j].grade +')">' +
                            '<div class="card-body">' +
                                '<h5 class="card-title">' + res[i+j].subjectName +' - G' + res[i+j].grade + '</h5>' +
                                '<h6 class="card-subtitle mb-2 text-muted">Mr. ' + res[i+j].teacherName + '</h6>' +
                                '<p class="card-text"></p>' + 
                            '</div>'+
                        '</div>'+
                    '</div>'
                }
                content = content + '</div>';    
            }
            $("#content").replaceWith(content);
        },
        error: function(err){
            console.log(err);
        }
    });

    $('#studentRegisterBtn').on('click', function (event) {
        event.preventDefault(); // To prevent following the link (optional)
        window.location.href = './studentRegister.html';
    });

    $('#addClassBtn').on('click', function (event) {
        event.preventDefault(); // To prevent following the link (optional)
        window.location.href = './classRegister.html';
    });
});

function classClicked(i, grade) {
    console.log(i);
    sessionStorage.setItem("classId", JSON.stringify(i));
    // sessionStorage.setItem("subjectName", sName);
    // sessionStorage.setItem("teacherName", tName);
    // sessionStorage.setItem("grade", JSON.stringify(grade));
    window.location.href = './class.html';
}
