package com.casestudy.course.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.casestudy.course.entity.Course;
import com.casestudy.course.repositories.CourseRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
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
    private KafkaTemplate<String, Course> kafkaTemplate;

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

