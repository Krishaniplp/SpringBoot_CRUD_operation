package com.example.ims.dao;

import com.example.ims.model.Group;
import com.example.ims.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao {

    @Override
    public int addClass(Group groupData) {
        String sqlSelectAllPersons = "INSERT INTO classes(subject_name, teacher_name, grade) VALUES \n" +
                "('"+ groupData.getSubjectName() +"','"+ groupData.getTeacherName() +"'," + groupData.getGrade() + ")";
        String connectionUrl = "jdbc:mysql://localhost:3306/IMS?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "kplX@997");
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons)) {
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Group> getAllGroups() {
        String sqlSelectAllPersons = "SELECT * FROM classes";
        String connectionUrl = "jdbc:mysql://localhost:3306/IMS?serverTimezone=UTC";

        List<Group> groups = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "kplX@997");
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Group group = new Group(
                        rs.getInt("id"),
                        rs.getString("subject_name"),
                        rs.getString("teacher_name"),
                        rs.getInt("grade"));

                groups.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return groups;
    }

    @Override
    public List<Student> getAllStudentsInClass(int classId) {
        String sqlSelectAllPersons = "SELECT * FROM students\n" +
                "INNER JOIN enrollments\n" +
                "ON students.id = enrollments.student_id\n" +
                "WHERE enrollments.class_id = " + classId;

        String connectionUrl = "jdbc:mysql://localhost:3306/IMS?serverTimezone=UTC";

        List<Student> studentList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "kplX@997");
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("school"),
                        rs.getString("contact_number"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return studentList;
    }

    @Override
    public int deleteStudent(int classId, int studentId) {
        String sqlSelectAllPersons = "DELETE FROM enrollments WHERE class_id = " + classId + " AND student_id= " + studentId;
        String connectionUrl = "jdbc:mysql://localhost:3306/IMS?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "kplX@997");
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons)) {
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int enrollStudent(int classId, int studentId) {
        String sqlSelectAllPersons = "INSERT INTO enrollments VALUES("+ classId + "," + studentId + ")";
        String connectionUrl = "jdbc:mysql://localhost:3306/IMS?serverTimezone=UTC";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "kplX@997");
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons)) {
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
