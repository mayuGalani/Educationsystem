package com.casestudy.user.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class CourseRegisterTest {
    /**
     * Method under test: {@link CourseRegister#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new CourseRegister()).canEqual("Other"));
    }

    /**
     * Method under test: {@link CourseRegister#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        CourseRegister courseRegister = new CourseRegister();
        assertTrue(courseRegister.canEqual(new CourseRegister()));
    }


    @Test
    void testConstructor() {
        CourseRegister actualCourseRegister = new CourseRegister();
        UUID randomUUIDResult = UUID.randomUUID();
        actualCourseRegister.setCourseUuid(randomUUIDResult);
        actualCourseRegister.toString();
        assertSame(randomUUIDResult, actualCourseRegister.getCourseUuid());
    }


    @Test
    void testConstructor2() {
        CourseRegister actualCourseRegister = new CourseRegister(UUID.randomUUID());
        UUID randomUUIDResult = UUID.randomUUID();
        actualCourseRegister.setCourseUuid(randomUUIDResult);
        actualCourseRegister.toString();
        assertSame(randomUUIDResult, actualCourseRegister.getCourseUuid());
    }

    /**
     * Method under test: {@link CourseRegister#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new CourseRegister(), null);
        assertNotEquals(new CourseRegister(), "Different type to CourseRegister");
    }


    @Test
    void testEquals2() {
        CourseRegister courseRegister = new CourseRegister();
        assertEquals(courseRegister, courseRegister);
        int expectedHashCodeResult = courseRegister.hashCode();
        assertEquals(expectedHashCodeResult, courseRegister.hashCode());
    }


    @Test
    void testEquals3() {
        CourseRegister courseRegister = new CourseRegister();
        CourseRegister courseRegister1 = new CourseRegister();
        assertEquals(courseRegister, courseRegister1);
        int expectedHashCodeResult = courseRegister.hashCode();
        assertEquals(expectedHashCodeResult, courseRegister1.hashCode());
    }

    /**
     * Method under test: {@link CourseRegister#equals(Object)}
     */
    @Test
    void testEquals4() {
        CourseRegister courseRegister = new CourseRegister(UUID.randomUUID());
        assertNotEquals(courseRegister, new CourseRegister());
    }

    /**
     * Method under test: {@link CourseRegister#equals(Object)}
     */
    @Test
    void testEquals5() {
        CourseRegister courseRegister = new CourseRegister();
        assertNotEquals(courseRegister, new CourseRegister(UUID.randomUUID()));
    }
}

