package com.casestudy.user.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.casestudy.user.entity.Course;
import com.casestudy.user.repositories.CourseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CourseService.class})
@ExtendWith(SpringExtension.class)
class CourseServiceTest {
    @MockBean
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @MockBean
    private ObjectMapper objectMapper;

    /**
     * Method under test: {@link CourseService#listenToTopics(String)}
     */
    @Test
    void testListenToTopics() throws JsonProcessingException {
        when(courseRepository.save((Course) any())).thenReturn(new Course());
        when(objectMapper.readValue((String) any(), (Class<Course>) any())).thenReturn(new Course());
        courseService.listenToTopics("Course");
        verify(courseRepository).save((Course) any());
        verify(objectMapper).readValue((String) any(), (Class<Course>) any());
    }

    /**
     * Method under test: {@link CourseService#allCourse()}
     */
    @Test
    void testAllCourse() {
        when(courseRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(courseService.allCourse().isEmpty());
        verify(courseRepository).findAll();
    }
}

