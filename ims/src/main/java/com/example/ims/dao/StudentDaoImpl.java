package com.example.ims.dao;

import com.example.ims.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class StudentDaoImpl implements StudentDao{
    @Override
    public int addStudent(Student student) {
        String sqlSelectAllPersons = "INSERT INTO students(name, grade, school, contact_number) VALUES \n" +
                "('"+ student.getName() +"',"+ student.getGrade() +",'" + student.getSchool() + "','" + student.getContactNumber() + "'),";
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
    public int updateStudent(Student student) {
        String sqlSelectAllPersons = "UPDATE students SET name='"+ student.getName() +"', school='" + student.getSchool() + "', contact_number='" + student.getContactNumber() + "' WHERE id = " + student.getId();
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
