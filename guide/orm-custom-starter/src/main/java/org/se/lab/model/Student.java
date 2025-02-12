package org.se.lab.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Student {
    @Id
    private int id;
    private String firstname;
    private String lastname;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private User user;

    public int getId() {
        return id;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Student setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Student setLastname(String lastname) {
        this.lastname = lastname;
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
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname) && Objects.equals(user, student.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, user);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", user=" + user +
                '}';
    }
}
