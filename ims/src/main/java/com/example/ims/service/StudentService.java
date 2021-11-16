package com.example.ims.service;

import com.example.ims.dao.StudentDao;
import com.example.ims.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
