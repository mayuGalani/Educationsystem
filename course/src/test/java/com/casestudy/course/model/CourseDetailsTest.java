package com.casestudy.course.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CourseDetailsTest {
    /**
     * Method under test: {@link CourseDetails#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"))
                .canEqual("Other"));
    }

    /**
     * Method under test: {@link CourseDetails#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        CourseDetails courseDetails = new CourseDetails("Course Name", "Schedule",
                "The characteristics of someone or something");
        assertTrue(courseDetails
                .canEqual(new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#CourseDetails()}
     *   <li>{@link CourseDetails#setCourseName(String)}
     *   <li>{@link CourseDetails#setDescription(String)}
     *   <li>{@link CourseDetails#setSchedule(String)}
     *   <li>{@link CourseDetails#toString()}
     *   <li>{@link CourseDetails#getCourseName()}
     *   <li>{@link CourseDetails#getDescription()}
     *   <li>{@link CourseDetails#getSchedule()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CourseDetails actualCourseDetails = new CourseDetails();
        actualCourseDetails.setCourseName("Course Name");
        actualCourseDetails.setDescription("The characteristics of someone or something");
        actualCourseDetails.setSchedule("Schedule");
        String actualToStringResult = actualCourseDetails.toString();
        assertEquals("Course Name", actualCourseDetails.getCourseName());
        assertEquals("The characteristics of someone or something", actualCourseDetails.getDescription());
        assertEquals("Schedule", actualCourseDetails.getSchedule());
        assertEquals("CourseDetails(courseName=Course Name, schedule=Schedule, description=The characteristics of someone"
                + " or something)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#CourseDetails(String, String, String)}
     *   <li>{@link CourseDetails#setCourseName(String)}
     *   <li>{@link CourseDetails#setDescription(String)}
     *   <li>{@link CourseDetails#setSchedule(String)}
     *   <li>{@link CourseDetails#toString()}
     *   <li>{@link CourseDetails#getCourseName()}
     *   <li>{@link CourseDetails#getDescription()}
     *   <li>{@link CourseDetails#getSchedule()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        CourseDetails actualCourseDetails = new CourseDetails("Course Name", "Schedule",
                "The characteristics of someone or something");
        actualCourseDetails.setCourseName("Course Name");
        actualCourseDetails.setDescription("The characteristics of someone or something");
        actualCourseDetails.setSchedule("Schedule");
        String actualToStringResult = actualCourseDetails.toString();
        assertEquals("Course Name", actualCourseDetails.getCourseName());
        assertEquals("The characteristics of someone or something", actualCourseDetails.getDescription());
        assertEquals("Schedule", actualCourseDetails.getSchedule());
        assertEquals("CourseDetails(courseName=Course Name, schedule=Schedule, description=The characteristics of someone"
                + " or something)", actualToStringResult);
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"),
                null);
        assertNotEquals(new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"),
                "Different type to CourseDetails");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        CourseDetails courseDetails = new CourseDetails("Course Name", "Schedule",
                "The characteristics of someone or something");
        assertEquals(courseDetails, courseDetails);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CourseDetails courseDetails = new CourseDetails("Course Name", "Schedule",
                "The characteristics of someone or something");
        CourseDetails courseDetails1 = new CourseDetails("Course Name", "Schedule",
                "The characteristics of someone or something");

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals4() {
        CourseDetails courseDetails = new CourseDetails("Schedule", "Schedule",
                "The characteristics of someone or something");
        assertNotEquals(courseDetails,
                new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals5() {
        CourseDetails courseDetails = new CourseDetails(null, "Schedule", "The characteristics of someone or something");
        assertNotEquals(courseDetails,
                new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals6() {
        CourseDetails courseDetails = new CourseDetails("Course Name", "Course Name",
                "The characteristics of someone or something");
        assertNotEquals(courseDetails,
                new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals7() {
        CourseDetails courseDetails = new CourseDetails("Course Name", null,
                "The characteristics of someone or something");
        assertNotEquals(courseDetails,
                new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals8() {
        CourseDetails courseDetails = new CourseDetails("Course Name", "Schedule", "Course Name");
        assertNotEquals(courseDetails,
                new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"));
    }

    /**
     * Method under test: {@link CourseDetails#equals(Object)}
     */
    @Test
    void testEquals9() {
        CourseDetails courseDetails = new CourseDetails("Course Name", "Schedule", null);
        assertNotEquals(courseDetails,
                new CourseDetails("Course Name", "Schedule", "The characteristics of someone or something"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        CourseDetails courseDetails = new CourseDetails(null, "Schedule", "The characteristics of someone or something");
        CourseDetails courseDetails1 = new CourseDetails(null, "Schedule", "The characteristics of someone or something");

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        CourseDetails courseDetails = new CourseDetails("Course Name", null,
                "The characteristics of someone or something");
        CourseDetails courseDetails1 = new CourseDetails("Course Name", null,
                "The characteristics of someone or something");

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CourseDetails#equals(Object)}
     *   <li>{@link CourseDetails#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        CourseDetails courseDetails = new CourseDetails("Course Name", "Schedule", null);
        CourseDetails courseDetails1 = new CourseDetails("Course Name", "Schedule", null);

        assertEquals(courseDetails, courseDetails1);
        int expectedHashCodeResult = courseDetails.hashCode();
        assertEquals(expectedHashCodeResult, courseDetails1.hashCode());
    }
}

