package org.se.lab;

import org.junit.Test;
import org.se.lab.builder.EntitiesBuilder;

public class BuilderTest {
    @Test
    public void test() {
        new EntitiesBuilder()
                .entity("User")
                    .attribute("username").string()
                    .attribute("password").string()
                .entity("Student")
                    .attribute("firstname").string()
                    .attribute("lastname").string()
                    .attribute("user").reference("User")
                .generate();
    }
}
