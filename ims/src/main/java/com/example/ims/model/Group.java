package com.example.ims.model;

public class Group {
    private int id;
    private String subjectName;
    private String teacherName;
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Group(int id, String subjectName, String teacherName, int grade) {
        this.id = id;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.grade = grade;
    }

    public Group(String subjectName,
                 String teacherName,
                 int grade) {
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.grade = grade;
    }
}
