package com.example.ims.dao;

import com.example.ims.model.Student;

public interface StudentDao {
    int addStudent(Student student);

    int updateStudent(Student student);
}
