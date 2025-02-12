package org.se.lab;

import org.junit.Test;
import org.se.lab.model.Student;
import org.se.lab.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJpa {
    @Test
    public void test() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Example");
        EntityManager em = factory.createEntityManager();
        Student student = new Student()
                .setFirstname("Hansi")
                .setLastname("Hubertson")
                .setUser(new User()
                        .setUsername("hansi")
                        .setPassword("meipassword"));

        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(student);
            entityTransaction.commit();

            Student resolved = em.createQuery("from Student",Student.class).getSingleResult();
            System.out.println(resolved);
        }
        finally {
            em.close();
            factory.close();
        }
    }
}
