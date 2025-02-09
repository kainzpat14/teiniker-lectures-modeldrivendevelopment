package org.se.lab.model;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute
    private String firstName;
    @XmlAttribute
    private String lastName;
    @XmlElement(name = "user")
    private User user;

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Student setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(user, student.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, user);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", user=" + user +
                '}';
    }
}
