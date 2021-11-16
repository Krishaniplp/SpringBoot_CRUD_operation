package com.example.ims.api;

import com.example.ims.model.Group;
import com.example.ims.model.Student;
import com.example.ims.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/classes")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public int addGroup(@RequestParam("subject_name") String subjectName,
                        @RequestParam("teacher_name") String teacher_name,
                        @RequestParam("grade") int grade){
        Group group = new Group(subjectName, teacher_name, grade);
        return groupService.addClass(group);
    }

    @PostMapping("/{classId}/enroll/student/{stdId}")
    public int enrollStudent(@PathVariable("classId") int classId,
                        @PathVariable("stdId") int studentId){
        return groupService.enrollStudent(classId, studentId);
    }

    @GetMapping
    public List<Group> getAllGroup(){
        return groupService.getAllGroups();
    }

    @GetMapping("/{classId}/students")
    public List<Student> getAllStudentsInClass(@PathVariable("classId") int classId){
        return groupService.getAllStudentsInClass(classId);
    }

    @DeleteMapping("/{classId}/students/{stdId}")
    public void deleteStudent(@PathVariable("classId") int classId,
                              @PathVariable("stdId") int studentId) {
        groupService.deleteStudent(classId, studentId);
    }
}
