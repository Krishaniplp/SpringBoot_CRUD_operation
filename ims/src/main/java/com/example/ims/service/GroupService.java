package com.example.ims.service;

import com.example.ims.dao.GroupDao;
import com.example.ims.model.Group;
import com.example.ims.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private final GroupDao groupDao;

    public GroupService(GroupDao groupDao){
        this.groupDao = groupDao;
    }

    public int addClass(Group groupData) {
        return groupDao.addClass(groupData);
    }

    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    public List<Student> getAllStudentsInClass(int classId) {
        return groupDao.getAllStudentsInClass(classId);
    }

    public void deleteStudent(int classId, int studentId) {
        groupDao.deleteStudent(classId, studentId);
    }

    public int enrollStudent(int classId, int studentId) {
        return groupDao.enrollStudent(classId, studentId);
    }
}
