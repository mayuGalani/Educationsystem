package com.casestudy.user.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FacultyRegisterTest {

    @Test
    void testConstructor() {
        FacultyRegister actualFacultyRegister = new FacultyRegister();
        actualFacultyRegister.setContactNo("Contact No");
        ArrayList<CourseRegister> courseRegisterList = new ArrayList<>();
        actualFacultyRegister.setCourses(courseRegisterList);
        actualFacultyRegister.setEmail("jane.doe@example.org");
        actualFacultyRegister.setEmployeeId("42");
        actualFacultyRegister.setName("Name");
        actualFacultyRegister.setPassword("iloveyou");
        actualFacultyRegister.setUsername("janedoe");
        String actualToStringResult = actualFacultyRegister.toString();
        assertEquals("Contact No", actualFacultyRegister.getContactNo());
        assertSame(courseRegisterList, actualFacultyRegister.getCourses());
        assertEquals("jane.doe@example.org", actualFacultyRegister.getEmail());
        assertEquals("42", actualFacultyRegister.getEmployeeId());
        assertEquals("Name", actualFacultyRegister.getName());
        assertEquals("iloveyou", actualFacultyRegister.getPassword());
        assertEquals("janedoe", actualFacultyRegister.getUsername());
        assertEquals(
                "FacultyRegister(name=Name, username=janedoe, password=iloveyou, email=jane.doe@example.org, employeeId=42,"
                        + " contactNo=Contact No, courses=[])",
                actualToStringResult);
    }


    @Test
    void testConstructor2() {
        ArrayList<CourseRegister> courseRegisterList = new ArrayList<>();
        FacultyRegister actualFacultyRegister = new FacultyRegister("Name", "janedoe", "iloveyou", "jane.doe@example.org",
                "42", "Contact No", courseRegisterList);
        actualFacultyRegister.setContactNo("Contact No");
        ArrayList<CourseRegister> courseRegisterList1 = new ArrayList<>();
        actualFacultyRegister.setCourses(courseRegisterList1);
        actualFacultyRegister.setEmail("jane.doe@example.org");
        actualFacultyRegister.setEmployeeId("42");
        actualFacultyRegister.setName("Name");
        actualFacultyRegister.setPassword("iloveyou");
        actualFacultyRegister.setUsername("janedoe");
        String actualToStringResult = actualFacultyRegister.toString();
        assertEquals("Contact No", actualFacultyRegister.getContactNo());
        ArrayList<CourseRegister> courses = actualFacultyRegister.getCourses();
        assertSame(courseRegisterList1, courses);
        assertEquals(courseRegisterList, courses);
        assertEquals("jane.doe@example.org", actualFacultyRegister.getEmail());
        assertEquals("42", actualFacultyRegister.getEmployeeId());
        assertEquals("Name", actualFacultyRegister.getName());
        assertEquals("iloveyou", actualFacultyRegister.getPassword());
        assertEquals("janedoe", actualFacultyRegister.getUsername());
        assertEquals(
                "FacultyRegister(name=Name, username=janedoe, password=iloveyou, email=jane.doe@example.org, employeeId=42,"
                        + " contactNo=Contact No, courses=[])",
                actualToStringResult);
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new FacultyRegister(), null);
        assertNotEquals(new FacultyRegister(), "Different type to FacultyRegister");
    }

    @Test
    void testEquals2() {
        FacultyRegister facultyRegister = new FacultyRegister();
        assertEquals(facultyRegister, facultyRegister);
        int expectedHashCodeResult = facultyRegister.hashCode();
        assertEquals(expectedHashCodeResult, facultyRegister.hashCode());
    }


    @Test
    void testEquals3() {
        FacultyRegister facultyRegister = new FacultyRegister();
        FacultyRegister facultyRegister1 = new FacultyRegister();
        assertEquals(facultyRegister, facultyRegister1);
        int expectedHashCodeResult = facultyRegister.hashCode();
        assertEquals(expectedHashCodeResult, facultyRegister1.hashCode());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals4() {
        FacultyRegister facultyRegister = new FacultyRegister("Name", "janedoe", "iloveyou", "jane.doe@example.org", "42",
                "Contact No", new ArrayList<>());
        assertNotEquals(facultyRegister, new FacultyRegister());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals5() {
        FacultyRegister facultyRegister = new FacultyRegister();
        assertNotEquals(facultyRegister, new FacultyRegister("Name", "janedoe", "iloveyou", "jane.doe@example.org", "42",
                "Contact No", new ArrayList<>()));
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals6() {
        FacultyRegister facultyRegister = new FacultyRegister();
        facultyRegister.setUsername("janedoe");
        assertNotEquals(facultyRegister, new FacultyRegister());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals7() {
        FacultyRegister facultyRegister = new FacultyRegister();
        facultyRegister.setPassword("iloveyou");
        assertNotEquals(facultyRegister, new FacultyRegister());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals8() {
        FacultyRegister facultyRegister = new FacultyRegister();
        facultyRegister.setEmail("jane.doe@example.org");
        assertNotEquals(facultyRegister, new FacultyRegister());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals9() {
        FacultyRegister facultyRegister = new FacultyRegister();
        facultyRegister.setEmployeeId("42");
        assertNotEquals(facultyRegister, new FacultyRegister());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals10() {
        FacultyRegister facultyRegister = new FacultyRegister();
        facultyRegister.setContactNo("Contact No");
        assertNotEquals(facultyRegister, new FacultyRegister());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals11() {
        FacultyRegister facultyRegister = new FacultyRegister();
        facultyRegister.setCourses(new ArrayList<>());
        assertNotEquals(facultyRegister, new FacultyRegister());
    }


    @Test
    void testEquals12() {
        FacultyRegister facultyRegister = new FacultyRegister("Name", "janedoe", "iloveyou", "jane.doe@example.org", "42",
                "Contact No", new ArrayList<>());
        FacultyRegister facultyRegister1 = new FacultyRegister("Name", "janedoe", "iloveyou", "jane.doe@example.org",
                "42", "Contact No", new ArrayList<>());

        assertEquals(facultyRegister, facultyRegister1);
        int expectedHashCodeResult = facultyRegister.hashCode();
        assertEquals(expectedHashCodeResult, facultyRegister1.hashCode());
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals13() {
        FacultyRegister facultyRegister = new FacultyRegister();

        FacultyRegister facultyRegister1 = new FacultyRegister();
        facultyRegister1.setUsername("janedoe");
        assertNotEquals(facultyRegister, facultyRegister1);
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals14() {
        FacultyRegister facultyRegister = new FacultyRegister();

        FacultyRegister facultyRegister1 = new FacultyRegister();
        facultyRegister1.setPassword("iloveyou");
        assertNotEquals(facultyRegister, facultyRegister1);
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals15() {
        FacultyRegister facultyRegister = new FacultyRegister();

        FacultyRegister facultyRegister1 = new FacultyRegister();
        facultyRegister1.setEmail("jane.doe@example.org");
        assertNotEquals(facultyRegister, facultyRegister1);
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals16() {
        FacultyRegister facultyRegister = new FacultyRegister();

        FacultyRegister facultyRegister1 = new FacultyRegister();
        facultyRegister1.setEmployeeId("42");
        assertNotEquals(facultyRegister, facultyRegister1);
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals17() {
        FacultyRegister facultyRegister = new FacultyRegister();

        FacultyRegister facultyRegister1 = new FacultyRegister();
        facultyRegister1.setContactNo("Contact No");
        assertNotEquals(facultyRegister, facultyRegister1);
    }

    /**
     * Method under test: {@link FacultyRegister#equals(Object)}
     */
    @Test
    void testEquals18() {
        FacultyRegister facultyRegister = new FacultyRegister();

        FacultyRegister facultyRegister1 = new FacultyRegister();
        facultyRegister1.setCourses(new ArrayList<>());
        assertNotEquals(facultyRegister, facultyRegister1);
    }
}

