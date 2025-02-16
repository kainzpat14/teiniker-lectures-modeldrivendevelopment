package org.se.lab;

import org.junit.Test;
import org.se.lab.marshalling.CustomMarshaller;
import org.se.lab.model.Student;
import org.se.lab.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class TestCustom {
    @Test
    public void testMarshal() throws JAXBException {
        CustomMarshaller marshaller = new CustomMarshaller();
        String result = marshaller.marshal(new Student()
                .setFirstName("Hansi")
                .setLastName("Hubertson")
                .setUser(new User()
                        .setUsername("hansi")
                        .setPassword("meipassword")));
        System.out.println(result);

    }

    @Test
    public void testUnmarshal() throws JAXBException {
        String message = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student first-name=\"Hansi\" last-name=\"Hubertson\"><user username=\"hansi\" password=\"meipassword\"/></student>";
        CustomMarshaller unmarshaller = new CustomMarshaller();
        Student student = unmarshaller.unmarshal(message, Student.class);
        System.out.println(student);
    }
}
