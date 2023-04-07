import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;
class StudentTest {

    private Student student;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        student = new Student();
    }
    @Test
    public void testAgeExists() {
        try {
            Field field = Student.class.getDeclaredField("age");
            assertFalse(Modifier.isPrivate(field.getModifiers()));
            assertEquals("int", field.getType().getSimpleName());
        } catch (NoSuchFieldException e) {
            fail("Field age does not exist");
        }
    }
    
    @Test
    public void testDefaultConstructorExists() {
        try {
            Constructor<?> constructor = Student.class.getDeclaredConstructor();
            assertNotNull(constructor);
            assertEquals(0, constructor.getParameterCount());
        } catch (NoSuchMethodException e) {
            fail("Default constructor does not exist");
        }
    }

    @Test
    public void testConstructorWithIntParameterExists() {
        try {
            Constructor<?> constructor = Student.class.getDeclaredConstructor(int.class);
            assertNotNull(constructor);
            assertEquals(1, constructor.getParameterCount());
            assertEquals("int", constructor.getParameterTypes()[0].getSimpleName());
        } catch (NoSuchMethodException e) {
            fail("Constructor with int parameter does not exist");
        }
    }

    @Test
    public void testConstructorWithStringParameterExists() {
        try {
            Constructor<?> constructor = Student.class.getDeclaredConstructor(String.class);
            assertNotNull(constructor);
            assertEquals(1, constructor.getParameterCount());
            assertEquals("String", constructor.getParameterTypes()[0].getSimpleName());
        } catch (NoSuchMethodException e) {
            fail("Constructor with String parameter does not exist");
        }
    }

    @Test
    public void testConstructorWithIntAndStringParametersExists() {
        try {
            Constructor<?> constructor = Student.class.getDeclaredConstructor(int.class, String.class);
            assertNotNull(constructor);
            assertEquals(2, constructor.getParameterCount());
            assertEquals("int", constructor.getParameterTypes()[0].getSimpleName());
            assertEquals("String", constructor.getParameterTypes()[1].getSimpleName());
        } catch (NoSuchMethodException e) {
            fail("Constructor with int and String parameters does not exist");
        }
    }
    @Test
    public void testDefaultConstructor() {
        Student student = new Student();
        assertEquals(0, student.age);
        assertNull(student.name);
    }

    @Test
    public void testConstructorWithIntParameter() {
        int age = 21;
        Student student = new Student(age);
        assertEquals(age, student.age);
        assertNull(student.name);
    }

    @Test
    public void testConstructorWithStringParameter() {
        String name = "John";
        Student student = new Student(name);
        assertEquals(0, student.age);
        assertEquals(name, student.name);
    }

    @Test
    public void testConstructorWithIntAndStringParameters() {
        int age = 21;
        String name = "John";
        Student student = new Student(age, name);
        assertEquals(age, student.age);
        assertEquals(name, student.name);
    }
    @Test
    public void testNullName() {
        Student student = new Student(21, null);
        assertEquals(21, student.age);
        assertNull(student.name);
    }


}