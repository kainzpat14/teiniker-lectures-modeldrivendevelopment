package org.se.lab;

import org.junit.Test;
import org.se.lab.model.Student;
import org.se.lab.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class TestJaxb {
    @Test
    public void testMarshal() throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = ctx.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(new Student()
                .setFirstName("Hansi")
                .setLastName("Hubertson")
                .setUser(new User()
                        .setUsername("hansi")
                        .setPassword("meipassword")),writer);
        System.out.println(writer.toString());

    }

    @Test
    public void testUnmarshal() throws JAXBException {
        String message = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student first-name=\"Hansi\" last-name=\"Hubertson\"><user username=\"hansi\" password=\"meipassword\"/></student>";
        JAXBContext ctx = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        Student student = (Student) unmarshaller.unmarshal(new StringReader(message));
        System.out.println(student);
    }
}
