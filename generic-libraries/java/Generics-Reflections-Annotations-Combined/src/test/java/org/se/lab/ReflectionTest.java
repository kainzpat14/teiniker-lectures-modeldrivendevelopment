package org.se.lab;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.se.lab.annotation.JsonSequence;
import org.se.lab.model.Grade;
import org.se.lab.model.Lecture;
import org.se.lab.model.Student;

public class ReflectionTest {

	@Test
	public void testReflectOnStudent()
			throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		Object student = createStudent();

		Class<?> clazz = student.getClass();
		System.out.println(clazz.getName());

		for (Field field : clazz.getDeclaredFields()) {
			System.out.println(field.getName());
			field.setAccessible(true);
			System.out.println(field.get(student));
			System.out.println(field.getAnnotation(JsonSequence.class));
		}

		for (Method method : clazz.getDeclaredMethods()) {
			System.out.println(method.getName());
			method.setAccessible(true);
			if (method.getParameterCount() == 0) {
				method.invoke(student);
			}
		}

		// Console.log(JSON.stringify(student))
		System.out.println(JSON.stringify(student));
	}

	private Student createStudent() {
		Lecture mdd = new Lecture("MDD");
		Lecture english = new Lecture("English");

		Grade mddGrade = new Grade(mdd, 1);
		Grade englishGrade = new Grade(english, 5);

		Student student = new Student("Patrick", "Kainz");
		student.getGrades().add(mddGrade);
		student.getGrades().add(englishGrade);

		return student;
	}

}
