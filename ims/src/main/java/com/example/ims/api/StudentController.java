package com.example.ims.api;

import com.example.ims.model.Student;
import com.example.ims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public int addStudent(@RequestParam("name") String name,
                          @RequestParam("school") String school,
                          @RequestParam("grade") int grade,
                          @RequestParam("contactNumber") String contactNumber){
        Student student = new Student(name, school, grade, contactNumber);
        return studentService.addStudent(student);
    }

    @PutMapping("/{stdId}")
    public int updateStudent(@PathVariable("stdId") int studentId,
                             @RequestParam("name") String name,
                             @RequestParam("school") String school,
                             @RequestParam("contactNumber") String contactNumber){
        Student student = new Student(studentId, name, school, contactNumber);
        return studentService.updateStudent(student);
    }
}
