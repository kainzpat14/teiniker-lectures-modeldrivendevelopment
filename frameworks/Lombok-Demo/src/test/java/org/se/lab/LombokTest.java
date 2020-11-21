package org.se.lab;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.builder.MEntity;
import org.se.lab.builder.MProperty;
import org.se.lab.builder.MType;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import lombok.var;

public class LombokTest {
	@Test
	public void testVal() {
		val age = 27;
		// the following causes an error
		// age = 28;
		Object ageObj = age;
		System.out.println(ageObj.getClass().getSimpleName());
	}

	@Test
	public void testVar() {
		var age = 27;
		age = 28;

		Object ageObj = age;
		System.out.println(ageObj.getClass().getSimpleName());
	}

	@Test
	public void testNullable() {
		System.out.println(notNullMultiply(2, 3));
		try {
			notNullMultiply(null, 2);
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			notNullMultiply(2, null);
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Test
	public void testCleanup() throws IOException {
		StringWriter output = new StringWriter();
		{
			@Cleanup
			BufferedWriter writer = new BufferedWriter(output);
			writer.append("abc");
		}

		Assert.assertEquals("abc", output.toString());
	}

	@Test
	public void testGetterAndSetter() {
		User user = new User();
		user.setName("user");
		user.setPassword("password");
		System.out.println(user.getName());
	}

	@Test
	public void testToString() {
		User user = new User();
		user.setName("user");
		user.setPassword("secretpassword");
		System.out.println(user);
	}

	@Test
	public void testEquals() {
		User user1 = new User();
		user1.setName("user");
		user1.setPassword("password1");
		User user2 = new User();
		user2.setName("user");
		user2.setPassword("password2");

		Assert.assertEquals(user1, user2);
	}

	@Test
	public void testConstructor() {
		User user = new User("user", "password");
		System.out.println(user);
	}

	@Test
	public void testPerson() {
		Person person1 = new Person("Max", "Mustermann");
		System.out.println(person1.getFirstname());
		System.out.println(person1.getLastname());
		System.out.println(person1);

		Person person2 = new Person("Max", "Muster");
		Assert.assertNotEquals(person1, person2);

		person2.setLastname("Mustermann");
		Assert.assertEquals(person1, person2);
	}

	@Test
	public void testValue() {
		ReadonlyPerson person = new ReadonlyPerson("Max", "Mustermann");
		// person.setLastname() not present
		System.out.println(person);
	}

	@Test
	public void testWith() {
		ReadonlyPerson person1 = new ReadonlyPerson("Max", "Mustermann");
		ReadonlyPerson person2 = person1.withLastname("AnotherName");
		System.out.println(person1);
		System.out.println(person2);
	}

	@Test
	@SneakyThrows(IOException.class)
	public void testSneakyThrows() {
		Path tmp = Files.createTempFile("my", "file");
		PrintWriter writer = new PrintWriter(Files.newBufferedWriter(tmp));
		writer.println("abc");
		writer.close();
		System.out.println(Files.readString(tmp));
	}

	@Test
	public void testBuilder() {
		MEntity entity = MEntity.builder().name("User")
				.property(MProperty.builder().name("username").type(MType.INTEGER).build()).build();
		System.out.println(entity);
	}

	private int notNullMultiply(@NonNull Integer a, @NonNull Integer b) {
		return a.intValue() * b.intValue();
	}
}
