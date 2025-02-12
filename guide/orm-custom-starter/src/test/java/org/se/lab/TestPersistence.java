package org.se.lab;

import org.junit.Test;
import org.se.lab.model.Student;
import org.se.lab.model.User;
import org.se.lab.persistence.GenericPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestPersistence {
    @Test
    public void testPersistence() throws SQLException {
        try(Connection h2 = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "")) {
            GenericPersistence persistence = new GenericPersistence(h2);
            persistence.createTable(Student.class);
            persistence.createTable(User.class);
            Student student = new Student()
                    .setId(1)
                    .setFirstname("Hansi")
                    .setLastname("Hubertson")
                    .setUser(new User()
                            .setId(2)
                            .setUsername("hansi")
                            .setPassword("meipassword"));
            persistence.insert(student.getUser());
            persistence.insert(student);
            System.out.println(persistence.findById(Student.class, 1));

            student.setFirstname("Georg");
            persistence.update(student);
            System.out.println(persistence.findById(Student.class, 1));

            persistence.delete(student);
            System.out.println(persistence.findById(Student.class, 1));
        }
    }
}
