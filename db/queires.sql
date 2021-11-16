CREATE DATABASE IMS;

CREATE TABLE students(
                         id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         name varchar(25) NOT NULL,
                         grade int NOT NULL,
                         school varchar(50),
                         contact_number varchar(10)
);

CREATE TABLE classes(
                        id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        subject_name varchar(25) NOT NULL,
                        teacher_name varchar(25) NOT NULL,
                        grade int NOT NULL
);

CREATE TABLE enrollments(
                            class_id int NOT NULL,
                            student_id int NOT NULL,
                            PRIMARY KEY (class_id, student_id),
                            FOREIGN KEY (class_id) REFERENCES classes(id),
                            FOREIGN KEY (student_id) REFERENCES students(id)
);


INSERT INTO students(name, grade, school, contact_number) VALUES
                                                              ("john", 10, "ABC", "0751623655"),
                                                              ("Amala", 11, "ABC", "0751454655"),
                                                              ("Willian", 11, "EFC", "0751623655"),
                                                              ("James", 11, "QWE", "0751454655");

INSERT INTO classes (subject_name, teacher_name, grade) VALUES
                                                            ("English", "Bob", 10),
                                                            ("Maths", "Kumar", 11);


INSERT INTO enrollments (class_id, student_id) VALUES
                                                   (1, 1),
                                                   (2, 2),
                                                   (1,3),
                                                  (1,4);