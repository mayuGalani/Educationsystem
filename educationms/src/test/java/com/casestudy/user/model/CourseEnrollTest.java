package com.casestudy.user.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class CourseEnrollTest {
    /**
     * Method under test: {@link CourseEnroll#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new CourseEnroll()).canEqual("Other"));
    }

    /**
     * Method under test: {@link CourseEnroll#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        CourseEnroll courseEnroll = new CourseEnroll();
        assertTrue(courseEnroll.canEqual(new CourseEnroll()));
    }

    @Test
    void testConstructor() {
        CourseEnroll actualCourseEnroll = new CourseEnroll();
        UUID randomUUIDResult = UUID.randomUUID();
        actualCourseEnroll.setCourseUuid(randomUUIDResult);
        UUID randomUUIDResult1 = UUID.randomUUID();
        actualCourseEnroll.setStudentUuid(randomUUIDResult1);
        actualCourseEnroll.toString();
        assertSame(randomUUIDResult, actualCourseEnroll.getCourseUuid());
        assertSame(randomUUIDResult1, actualCourseEnroll.getStudentUuid());
    }

    @Test
    void testConstructor2() {
        UUID courseUuid = UUID.randomUUID();
        CourseEnroll actualCourseEnroll = new CourseEnroll(courseUuid, UUID.randomUUID());
        UUID randomUUIDResult = UUID.randomUUID();
        actualCourseEnroll.setCourseUuid(randomUUIDResult);
        UUID randomUUIDResult1 = UUID.randomUUID();
        actualCourseEnroll.setStudentUuid(randomUUIDResult1);
        actualCourseEnroll.toString();
        assertSame(randomUUIDResult, actualCourseEnroll.getCourseUuid());
        assertSame(randomUUIDResult1, actualCourseEnroll.getStudentUuid());
    }

    /**
     * Method under test: {@link CourseEnroll#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new CourseEnroll(), null);
        assertNotEquals(new CourseEnroll(), "Different type to CourseEnroll");
    }

    @Test
    void testEquals2() {
        CourseEnroll courseEnroll = new CourseEnroll();
        assertEquals(courseEnroll, courseEnroll);
        int expectedHashCodeResult = courseEnroll.hashCode();
        assertEquals(expectedHashCodeResult, courseEnroll.hashCode());
    }

    @Test
    void testEquals3() {
        CourseEnroll courseEnroll = new CourseEnroll();
        CourseEnroll courseEnroll1 = new CourseEnroll();
        assertEquals(courseEnroll, courseEnroll1);
        int expectedHashCodeResult = courseEnroll.hashCode();
        assertEquals(expectedHashCodeResult, courseEnroll1.hashCode());
    }

    @Test
    void testEquals4() {
        UUID courseUuid = UUID.randomUUID();
        CourseEnroll courseEnroll = new CourseEnroll(courseUuid, UUID.randomUUID());
        assertNotEquals(courseEnroll, new CourseEnroll());
    }

    /**
     * Method under test: {@link CourseEnroll#equals(Object)}
     */
    @Test
    void testEquals5() {
        CourseEnroll courseEnroll = new CourseEnroll();
        UUID courseUuid = UUID.randomUUID();
        assertNotEquals(courseEnroll, new CourseEnroll(courseUuid, UUID.randomUUID()));
    }

    /**
     * Method under test: {@link CourseEnroll#equals(Object)}
     */
    @Test
    void testEquals6() {
        CourseEnroll courseEnroll = new CourseEnroll();
        courseEnroll.setStudentUuid(UUID.randomUUID());
        assertNotEquals(courseEnroll, new CourseEnroll());
    }

    /**
     * Method under test: {@link CourseEnroll#equals(Object)}
     */
    @Test
    void testEquals7() {
        CourseEnroll courseEnroll = new CourseEnroll();

        CourseEnroll courseEnroll1 = new CourseEnroll();
        courseEnroll1.setStudentUuid(UUID.randomUUID());
        assertNotEquals(courseEnroll, courseEnroll1);
    }
}

