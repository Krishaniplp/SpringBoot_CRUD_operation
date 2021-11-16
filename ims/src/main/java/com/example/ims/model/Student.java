package com.example.ims.model;

public class Student {
    private int id;
    private String name;
    private String school;
    private int grade;
    private String contactNumber;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Student(int id, String name, String school, int grade, String contactNumber) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.contactNumber = contactNumber;
    }

    public Student(int id, String name, String school, String contactNumber) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.contactNumber = contactNumber;
    }

    public Student(String name, String school, int grade, String contactNumber) {
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.contactNumber = contactNumber;
    }
}
