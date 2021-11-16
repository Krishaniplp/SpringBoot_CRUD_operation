$(document).ready(function () { // this waits until the document is fully loaded
    let classId = JSON.parse(sessionStorage.getItem("classId"));
    // let subjectName = JSON.parse(sessionStorage.getItem("subjectName"));
    // let teacherName = JSON.parse(sessionStorage.getItem("teacherName"));
    // let grade = JSON.parse(sessionStorage.getItem("grade"));

    // $("#teacherName").html(teacherName);
    // $("#classDet").html(subjectName + ' - G' + grade);

    $.ajax({
        url: "http://localhost:8080/classes/" + classId + "/students",
        type: 'GET',
        contentType: "application/json",
        success: function (res) {
            console.log(res);
            var content = "";
            for (let j = 0; j < Object.keys(res).length; j++) {
                content = content +
                    '<tr>' +
                    '<th scope="row">' + res[j].id + '</th>' +
                    '<td>' + res[j].name + '</td>' +
                    '<td>' + res[j].school + '</td>' +
                    '<td>' + res[j].contactNumber + '</td>' +
                    '<td> <button type="button" class="btn btn-secondary btn-sm" onclick="updateStudent('+ res[j].id + ')">Edit</button></td>' + 
                    '<td> <button type="button" class="btn btn-danger btn-sm" onclick="deleteStudent('+ res[j].id + ')">Delete</button></td>' + 
                    '</tr>'
            }
            $("#students").html(content);
        },
        error: function (err) {
            console.log(err);
        }
    });

    $('#enroll-std-form-submit').click( function(){
        let classId = JSON.parse(sessionStorage.getItem("classId"));
        let stdId = $("#enrollStdId").val();

        $.ajax({
            url: "http://localhost:8080/classes/" + classId + "/enroll/" + "/student/" + stdId,
            type: 'POST',
            contentType: "application/json",
            success: function (res) {
                console.log(res);
                location.reload();
            },
            error: function (err) {
                console.log(err);
            }
        });
    });
});

function deleteStudent(id) {
    let classId = JSON.parse(sessionStorage.getItem("classId"));
    $.ajax({
        url: "http://localhost:8080/classes/" + classId + "/students/" + id,
        type: 'DELETE',
        contentType: "application/json",
        success: function (res) {
            console.log(res);
            location.reload();
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function updateStudent(id) {
    event.preventDefault(); // To prevent following the link (optional)
    sessionStorage.setItem("stdId", JSON.stringify(id));
    window.location.href = './studentUpdate.html';
}