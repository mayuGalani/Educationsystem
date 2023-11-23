package com.casestudy.user.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.casestudy.user.entity.Course;
import com.casestudy.user.entity.Role;
import com.casestudy.user.entity.Student;
import com.casestudy.user.model.CourseEnroll;
import com.casestudy.user.repositories.CourseRepository;
import com.casestudy.user.repositories.StudentRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(SpringExtension.class)
class StudentServiceTest {
    @MockBean
    private CourseRepository courseRepository;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * Method under test: {@link StudentService#registerStudent(Student)}
     */
    @Test
    void testRegisterStudent() {
        Student student = new Student();
        student.setAddress("42 Main St");
        student.setContactNo("Contact No");
        student.setCountry("GB");
        student.setCourses(new HashSet<>());
        student.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student.setEmail("jane.doe@example.org");
        student.setName("Name");
        student.setPassword("hello");
        student.setRole(new Role());
        student.setState("MD");
        student.setStudentId("42");
        student.setStudentUuid(UUID.randomUUID());
        student.setUsername("janedoe");

        Student student1 = new Student();
        student1.setAddress("42 Main St");
        student1.setContactNo("Contact No");
        student1.setCountry("GB");
        student1.setCourses(new HashSet<>());
        student1.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student1.setEmail("jane.doe@example.org");
        student1.setName("Name");
        student1.setPassword("hello");
        student1.setRole(new Role());
        student1.setState("MD");
        student1.setStudentId("42");
        student1.setStudentUuid(UUID.randomUUID());
        student1.setUsername("janedoe");
        Optional<Student> ofResult = Optional.of(student1);
        when(studentRepository.save((Student) any())).thenReturn(student);
        when(studentRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);

        Student student2 = new Student();
        student2.setAddress("42 Main St");
        student2.setContactNo("Contact No");
        student2.setCountry("GB");
        student2.setCourses(new HashSet<>());
        student2.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student2.setEmail("jane.doe@example.org");
        student2.setName("Name");
        student2.setPassword("hello");
        student2.setRole(new Role());
        student2.setState("MD");
        student2.setStudentId("42");
        student2.setStudentUuid(UUID.randomUUID());
        student2.setUsername("janedoe");
        assertNull(studentService.registerStudent(student2));
        verify(studentRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link StudentService#registerStudent(Student)}
     */
    @Test
    void testRegisterStudent2() {
        Student student = new Student();
        student.setAddress("42 Main St");
        student.setContactNo("Contact No");
        student.setCountry("GB");
        student.setCourses(new HashSet<>());
        student.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student.setEmail("jane.doe@example.org");
        student.setName("Name");
        student.setPassword("hello");
        student.setRole(new Role());
        student.setState("MD");
        student.setStudentId("42");
        student.setStudentUuid(UUID.randomUUID());
        student.setUsername("janedoe");
        when(studentRepository.save((Student) any())).thenReturn(student);
        when(studentRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(Optional.empty());

        Student student1 = new Student();
        student1.setAddress("42 Main St");
        student1.setContactNo("Contact No");
        student1.setCountry("GB");
        student1.setCourses(new HashSet<>());
        student1.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student1.setEmail("jane.doe@example.org");
        student1.setName("Name");
        student1.setPassword("hello");
        student1.setRole(new Role());
        student1.setState("MD");
        student1.setStudentId("42");
        student1.setStudentUuid(UUID.randomUUID());
        student1.setUsername("janedoe");
        assertSame(student, studentService.registerStudent(student1));
        verify(studentRepository).save((Student) any());
        verify(studentRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link StudentService#login(String, String)}
     */
    @Test
    void testLogin() {
        Student student = new Student();
        student.setAddress("42 Main St");
        student.setContactNo("Contact No");
        student.setCountry("GB");
        student.setCourses(new HashSet<>());
        student.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student.setEmail("jane.doe@example.org");
        student.setName("Name");
        student.setPassword("hello");
        student.setRole(new Role());
        student.setState("MD");
        student.setStudentId("42");
        student.setStudentUuid(UUID.randomUUID());
        student.setUsername("janedoe");
        Optional<Student> ofResult = Optional.of(student);
        when(studentRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        Optional<Student> actualLoginResult = studentService.login("janedoe", "hello");
        assertSame(ofResult, actualLoginResult);
        assertTrue(actualLoginResult.isPresent());
        verify(studentRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link StudentService#enrollment(CourseEnroll)}
     */
    @Test
    void testEnrollment() {
        when(courseRepository.findByCourseUuid((UUID) any())).thenReturn(new Course());

        Student student = new Student();
        student.setAddress("42 Main St");
        student.setContactNo("Contact No");
        student.setCountry("GB");
        student.setCourses(new HashSet<>());
        student.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student.setEmail("jane.doe@example.org");
        student.setName("Name");
        student.setPassword("hello");
        student.setRole(new Role());
        student.setState("MD");
        student.setStudentId("42");
        student.setStudentUuid(UUID.randomUUID());
        student.setUsername("janedoe");

        Student student1 = new Student();
        student1.setAddress("42 Main St");
        student1.setContactNo("Contact No");
        student1.setCountry("GB");
        student1.setCourses(new HashSet<>());
        student1.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student1.setEmail("jane.doe@example.org");
        student1.setName("Name");
        student1.setPassword("hello");
        student1.setRole(new Role());
        student1.setState("MD");
        student1.setStudentId("42");
        student1.setStudentUuid(UUID.randomUUID());
        student1.setUsername("janedoe");
        when(studentRepository.save((Student) any())).thenReturn(student1);
        when(studentRepository.findByStudentUuid((UUID) any())).thenReturn(student);
        assertSame(student1, studentService.enrollment(new CourseEnroll()));
        verify(courseRepository).findByCourseUuid((UUID) any());
        verify(studentRepository).findByStudentUuid((UUID) any());
        verify(studentRepository).save((Student) any());
    }

    /**
     * Method under test: {@link StudentService#enrollment(CourseEnroll)}
     */
    @Test
    void testEnrollment2() {
        when(courseRepository.findByCourseUuid((UUID) any())).thenReturn(null);

        Student student = new Student();
        student.setAddress("42 Main St");
        student.setContactNo("Contact No");
        student.setCountry("GB");
        student.setCourses(new HashSet<>());
        student.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student.setEmail("jane.doe@example.org");
        student.setName("Name");
        student.setPassword("hello");
        student.setRole(new Role());
        student.setState("MD");
        student.setStudentId("42");
        student.setStudentUuid(UUID.randomUUID());
        student.setUsername("janedoe");

        Student student1 = new Student();
        student1.setAddress("42 Main St");
        student1.setContactNo("Contact No");
        student1.setCountry("GB");
        student1.setCourses(new HashSet<>());
        student1.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student1.setEmail("jane.doe@example.org");
        student1.setName("Name");
        student1.setPassword("hello");
        student1.setRole(new Role());
        student1.setState("MD");
        student1.setStudentId("42");
        student1.setStudentUuid(UUID.randomUUID());
        student1.setUsername("janedoe");
        when(studentRepository.save((Student) any())).thenReturn(student1);
        when(studentRepository.findByStudentUuid((UUID) any())).thenReturn(student);
        assertSame(student1, studentService.enrollment(new CourseEnroll()));
        verify(courseRepository).findByCourseUuid((UUID) any());
        verify(studentRepository).findByStudentUuid((UUID) any());
        verify(studentRepository).save((Student) any());
    }

    /**
     * Method under test: {@link StudentService#enrollment(CourseEnroll)}
     */
    @Test
    void testEnrollment3() {
        when(courseRepository.findByCourseUuid((UUID) any())).thenReturn(new Course());

        HashSet<Course> courseSet = new HashSet<>();
        courseSet.add(new Course());

        Student student = new Student();
        student.setAddress("42 Main St");
        student.setContactNo("Contact No");
        student.setCountry("GB");
        student.setCourses(courseSet);
        student.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student.setEmail("jane.doe@example.org");
        student.setName("Name");
        student.setPassword("hello");
        student.setRole(new Role());
        student.setState("MD");
        student.setStudentId("42");
        student.setStudentUuid(UUID.randomUUID());
        student.setUsername("janedoe");

        Student student1 = new Student();
        student1.setAddress("42 Main St");
        student1.setContactNo("Contact No");
        student1.setCountry("GB");
        student1.setCourses(new HashSet<>());
        student1.setDateOfBirth(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        student1.setEmail("jane.doe@example.org");
        student1.setName("Name");
        student1.setPassword("hello");
        student1.setRole(new Role());
        student1.setState("MD");
        student1.setStudentId("42");
        student1.setStudentUuid(UUID.randomUUID());
        student1.setUsername("janedoe");
        when(studentRepository.save((Student) any())).thenReturn(student1);
        when(studentRepository.findByStudentUuid((UUID) any())).thenReturn(student);
        assertSame(student1, studentService.enrollment(new CourseEnroll()));
        verify(courseRepository, atLeast(1)).findByCourseUuid((UUID) any());
        verify(studentRepository).findByStudentUuid((UUID) any());
        verify(studentRepository).save((Student) any());
    }
}

