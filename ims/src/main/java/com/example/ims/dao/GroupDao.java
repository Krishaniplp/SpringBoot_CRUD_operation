package com.example.ims.dao;

import com.example.ims.model.Group;
import com.example.ims.model.Student;

import java.util.List;

public interface GroupDao {
    int addClass(Group groupData);

    List<Group> getAllGroups();

    List<Student> getAllStudentsInClass(int classId);

    int deleteStudent(int classId, int studentId);

    int enrollStudent(int classId, int studentId);
}
