package com.casestudy.user.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class StudentRegisterTest {

    @Test
    void testConstructor() {
        StudentRegister actualStudentRegister = new StudentRegister();
        actualStudentRegister.setAddress("42 Main St");
        actualStudentRegister.setContactNo("Contact No");
        actualStudentRegister.setCountry("GB");
        ArrayList<CourseRegister> courseRegisterList = new ArrayList<>();
        actualStudentRegister.setCourses(courseRegisterList);
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualStudentRegister.setDateOfBirth(fromResult);
        actualStudentRegister.setEmail("jane.doe@example.org");
        actualStudentRegister.setName("Name");
        actualStudentRegister.setPassword("iloveyou");
        actualStudentRegister.setState("MD");
        actualStudentRegister.setStudentId("42");
        actualStudentRegister.setUsername("janedoe");
        actualStudentRegister.toString();
        assertEquals("42 Main St", actualStudentRegister.getAddress());
        assertEquals("Contact No", actualStudentRegister.getContactNo());
        assertEquals("GB", actualStudentRegister.getCountry());
        assertSame(courseRegisterList, actualStudentRegister.getCourses());
        assertSame(fromResult, actualStudentRegister.getDateOfBirth());
        assertEquals("jane.doe@example.org", actualStudentRegister.getEmail());
        assertEquals("Name", actualStudentRegister.getName());
        assertEquals("iloveyou", actualStudentRegister.getPassword());
        assertEquals("MD", actualStudentRegister.getState());
        assertEquals("42", actualStudentRegister.getStudentId());
        assertEquals("janedoe", actualStudentRegister.getUsername());
    }

    @Test
    void testConstructor2() {
        Date dateOfBirth = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        ArrayList<CourseRegister> courseRegisterList = new ArrayList<>();
        StudentRegister actualStudentRegister = new StudentRegister("Name", "janedoe", "iloveyou", "42 Main St", "MD",
                "GB", "jane.doe@example.org", "42", "Contact No", dateOfBirth, courseRegisterList);
        actualStudentRegister.setAddress("42 Main St");
        actualStudentRegister.setContactNo("Contact No");
        actualStudentRegister.setCountry("GB");
        ArrayList<CourseRegister> courseRegisterList1 = new ArrayList<>();
        actualStudentRegister.setCourses(courseRegisterList1);
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualStudentRegister.setDateOfBirth(fromResult);
        actualStudentRegister.setEmail("jane.doe@example.org");
        actualStudentRegister.setName("Name");
        actualStudentRegister.setPassword("iloveyou");
        actualStudentRegister.setState("MD");
        actualStudentRegister.setStudentId("42");
        actualStudentRegister.setUsername("janedoe");
        actualStudentRegister.toString();
        assertEquals("42 Main St", actualStudentRegister.getAddress());
        assertEquals("Contact No", actualStudentRegister.getContactNo());
        assertEquals("GB", actualStudentRegister.getCountry());
        ArrayList<CourseRegister> courses = actualStudentRegister.getCourses();
        assertSame(courseRegisterList1, courses);
        assertEquals(courseRegisterList, courses);
        assertSame(fromResult, actualStudentRegister.getDateOfBirth());
        assertEquals("jane.doe@example.org", actualStudentRegister.getEmail());
        assertEquals("Name", actualStudentRegister.getName());
        assertEquals("iloveyou", actualStudentRegister.getPassword());
        assertEquals("MD", actualStudentRegister.getState());
        assertEquals("42", actualStudentRegister.getStudentId());
        assertEquals("janedoe", actualStudentRegister.getUsername());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new StudentRegister(), null);
        assertNotEquals(new StudentRegister(), "Different type to StudentRegister");
    }

    @Test
    void testEquals2() {
        StudentRegister studentRegister = new StudentRegister();
        assertEquals(studentRegister, studentRegister);
        int expectedHashCodeResult = studentRegister.hashCode();
        assertEquals(expectedHashCodeResult, studentRegister.hashCode());
    }

    @Test
    void testEquals3() {
        StudentRegister studentRegister = new StudentRegister();
        StudentRegister studentRegister1 = new StudentRegister();
        assertEquals(studentRegister, studentRegister1);
        int expectedHashCodeResult = studentRegister.hashCode();
        assertEquals(expectedHashCodeResult, studentRegister1.hashCode());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals4() {
        Date dateOfBirth = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        StudentRegister studentRegister = new StudentRegister("Name", "janedoe", "iloveyou", "42 Main St", "MD", "GB",
                "jane.doe@example.org", "42", "Contact No", dateOfBirth, new ArrayList<>());
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals5() {
        StudentRegister studentRegister = new StudentRegister();
        Date dateOfBirth = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        assertNotEquals(studentRegister, new StudentRegister("Name", "janedoe", "iloveyou", "42 Main St", "MD", "GB",
                "jane.doe@example.org", "42", "Contact No", dateOfBirth, new ArrayList<>()));
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals6() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setUsername("janedoe");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals7() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setPassword("iloveyou");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals8() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setAddress("42 Main St");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals9() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setState("MD");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals10() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setCountry("GB");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals11() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setEmail("jane.doe@example.org");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals12() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setStudentId("42");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals13() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setContactNo("Contact No");
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals14() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister
                .setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        assertNotEquals(studentRegister, new StudentRegister());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals15() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.setCourses(new ArrayList<>());
        assertNotEquals(studentRegister, new StudentRegister());
    }

    @Test
    void testEquals16() {
        Date dateOfBirth = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        StudentRegister studentRegister = new StudentRegister("Name", "janedoe", "iloveyou", "42 Main St", "MD", "GB",
                "jane.doe@example.org", "42", "Contact No", dateOfBirth, new ArrayList<>());
        Date dateOfBirth1 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        StudentRegister studentRegister1 = new StudentRegister("Name", "janedoe", "iloveyou", "42 Main St", "MD", "GB",
                "jane.doe@example.org", "42", "Contact No", dateOfBirth1, new ArrayList<>());

        assertEquals(studentRegister, studentRegister1);
        int expectedHashCodeResult = studentRegister.hashCode();
        assertEquals(expectedHashCodeResult, studentRegister1.hashCode());
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals17() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setUsername("janedoe");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals18() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setPassword("iloveyou");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals19() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setAddress("42 Main St");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals20() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setState("MD");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals21() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setCountry("GB");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals22() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setEmail("jane.doe@example.org");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals23() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setStudentId("42");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals24() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setContactNo("Contact No");
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals25() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1
                .setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        assertNotEquals(studentRegister, studentRegister1);
    }

    /**
     * Method under test: {@link StudentRegister#equals(Object)}
     */
    @Test
    void testEquals26() {
        StudentRegister studentRegister = new StudentRegister();

        StudentRegister studentRegister1 = new StudentRegister();
        studentRegister1.setCourses(new ArrayList<>());
        assertNotEquals(studentRegister, studentRegister1);
    }
}

