package com.casestudy.user.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.casestudy.user.entity.Course;
import com.casestudy.user.entity.Faculty;
import com.casestudy.user.entity.Role;
import com.casestudy.user.repositories.CourseRepository;
import com.casestudy.user.repositories.FacultyRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FacultyService.class})
@ExtendWith(SpringExtension.class)
class FacultyServiceTest {
    @MockBean
    private CourseRepository courseRepository;

    @MockBean
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyService facultyService;

    /**
     * Method under test: {@link FacultyService#registerFaculty(Faculty)}
     */
    @Test
    void testRegisterFaculty() {
        Faculty faculty = new Faculty();
        faculty.setContactNo("Contact No");
        faculty.setCourses(new HashSet<>());
        faculty.setEmail("jane.doe@example.org");
        faculty.setEmployeeId("42");
        faculty.setFacultyUuid(UUID.randomUUID());
        faculty.setName("Name");
        faculty.setPassword("hello");
        faculty.setRole(new Role());
        faculty.setUsername("janedoe");

        Faculty faculty1 = new Faculty();
        faculty1.setContactNo("Contact No");
        faculty1.setCourses(new HashSet<>());
        faculty1.setEmail("jane.doe@example.org");
        faculty1.setEmployeeId("42");
        faculty1.setFacultyUuid(UUID.randomUUID());
        faculty1.setName("Name");
        faculty1.setPassword("hello");
        faculty1.setRole(new Role());
        faculty1.setUsername("janedoe");
        Optional<Faculty> ofResult = Optional.of(faculty1);
        when(facultyRepository.save((Faculty) any())).thenReturn(faculty);
        when(facultyRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);

        Faculty faculty2 = new Faculty();
        faculty2.setContactNo("Contact No");
        faculty2.setCourses(new HashSet<>());
        faculty2.setEmail("jane.doe@example.org");
        faculty2.setEmployeeId("42");
        faculty2.setFacultyUuid(UUID.randomUUID());
        faculty2.setName("Name");
        faculty2.setPassword("hello");
        faculty2.setRole(new Role());
        faculty2.setUsername("janedoe");
        assertNull(facultyService.registerFaculty(faculty2));
        verify(facultyRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link FacultyService#registerFaculty(Faculty)}
     */
    @Test
    void testRegisterFaculty2() {
        Faculty faculty = new Faculty();
        faculty.setContactNo("Contact No");
        faculty.setCourses(new HashSet<>());
        faculty.setEmail("jane.doe@example.org");
        faculty.setEmployeeId("42");
        faculty.setFacultyUuid(UUID.randomUUID());
        faculty.setName("Name");
        faculty.setPassword("hello");
        faculty.setRole(new Role());
        faculty.setUsername("janedoe");
        when(facultyRepository.save((Faculty) any())).thenReturn(faculty);
        when(facultyRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(Optional.empty());

        Faculty faculty1 = new Faculty();
        faculty1.setContactNo("Contact No");
        faculty1.setCourses(new HashSet<>());
        faculty1.setEmail("jane.doe@example.org");
        faculty1.setEmployeeId("42");
        faculty1.setFacultyUuid(UUID.randomUUID());
        faculty1.setName("Name");
        faculty1.setPassword("hello");
        faculty1.setRole(new Role());
        faculty1.setUsername("janedoe");
        assertSame(faculty, facultyService.registerFaculty(faculty1));
        verify(facultyRepository).save((Faculty) any());
        verify(facultyRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link FacultyService#login(String, String)}
     */
    @Test
    void testLogin() {
        Faculty faculty = new Faculty();
        faculty.setContactNo("Contact No");
        faculty.setCourses(new HashSet<>());
        faculty.setEmail("jane.doe@example.org");
        faculty.setEmployeeId("42");
        faculty.setFacultyUuid(UUID.randomUUID());
        faculty.setName("Name");
        faculty.setPassword("hello");
        faculty.setRole(new Role());
        faculty.setUsername("janedoe");
        Optional<Faculty> ofResult = Optional.of(faculty);
        when(facultyRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);
        Optional<Faculty> actualLoginResult = facultyService.login("janedoe", "hello");
        assertSame(ofResult, actualLoginResult);
        assertTrue(actualLoginResult.isPresent());
        verify(facultyRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link FacultyService#updateFaculty(Faculty)}
     */
    @Test
    void testUpdateFaculty() {
        Faculty faculty = new Faculty();
        faculty.setContactNo("Contact No");
        faculty.setCourses(new HashSet<>());
        faculty.setEmail("jane.doe@example.org");
        faculty.setEmployeeId("42");
        faculty.setFacultyUuid(UUID.randomUUID());
        faculty.setName("Name");
        faculty.setPassword("hello");
        faculty.setRole(new Role());
        faculty.setUsername("janedoe");
        Optional<Faculty> ofResult = Optional.of(faculty);

        Faculty faculty1 = new Faculty();
        faculty1.setContactNo("Contact No");
        faculty1.setCourses(new HashSet<>());
        faculty1.setEmail("jane.doe@example.org");
        faculty1.setEmployeeId("42");
        faculty1.setFacultyUuid(UUID.randomUUID());
        faculty1.setName("Name");
        faculty1.setPassword("hello");
        faculty1.setRole(new Role());
        faculty1.setUsername("janedoe");
        when(facultyRepository.save((Faculty) any())).thenReturn(faculty1);
        when(facultyRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);

        Faculty faculty2 = new Faculty();
        faculty2.setContactNo("Contact No");
        faculty2.setCourses(new HashSet<>());
        faculty2.setEmail("jane.doe@example.org");
        faculty2.setEmployeeId("42");
        faculty2.setFacultyUuid(UUID.randomUUID());
        faculty2.setName("Name");
        faculty2.setPassword("hello");
        faculty2.setRole(new Role());
        faculty2.setUsername("janedoe");
        assertSame(faculty1, facultyService.updateFaculty(faculty2));
        verify(facultyRepository).save((Faculty) any());
        verify(facultyRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link FacultyService#updateFaculty(Faculty)}
     */
    @Test
    void testUpdateFaculty2() {
        Faculty faculty = new Faculty();
        faculty.setContactNo("Contact No");
        faculty.setCourses(new HashSet<>());
        faculty.setEmail("jane.doe@example.org");
        faculty.setEmployeeId("42");
        faculty.setFacultyUuid(UUID.randomUUID());
        faculty.setName("Name");
        faculty.setPassword("hello");
        faculty.setRole(new Role());
        faculty.setUsername("janedoe");
        when(facultyRepository.save((Faculty) any())).thenReturn(faculty);
        when(facultyRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(Optional.empty());

        Faculty faculty1 = new Faculty();
        faculty1.setContactNo("Contact No");
        faculty1.setCourses(new HashSet<>());
        faculty1.setEmail("jane.doe@example.org");
        faculty1.setEmployeeId("42");
        faculty1.setFacultyUuid(UUID.randomUUID());
        faculty1.setName("Name");
        faculty1.setPassword("hello");
        faculty1.setRole(new Role());
        faculty1.setUsername("janedoe");
        assertNull(facultyService.updateFaculty(faculty1));
        verify(facultyRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link FacultyService#updateFaculty(Faculty)}
     */
    @Test
    void testUpdateFaculty3() {
        when(courseRepository.findByCourseUuid((UUID) any())).thenReturn(new Course());

        Faculty faculty = new Faculty();
        faculty.setContactNo("Contact No");
        faculty.setCourses(new HashSet<>());
        faculty.setEmail("jane.doe@example.org");
        faculty.setEmployeeId("42");
        faculty.setFacultyUuid(UUID.randomUUID());
        faculty.setName("Name");
        faculty.setPassword("hello");
        faculty.setRole(new Role());
        faculty.setUsername("janedoe");
        Optional<Faculty> ofResult = Optional.of(faculty);

        Faculty faculty1 = new Faculty();
        faculty1.setContactNo("Contact No");
        faculty1.setCourses(new HashSet<>());
        faculty1.setEmail("jane.doe@example.org");
        faculty1.setEmployeeId("42");
        faculty1.setFacultyUuid(UUID.randomUUID());
        faculty1.setName("Name");
        faculty1.setPassword("hello");
        faculty1.setRole(new Role());
        faculty1.setUsername("janedoe");
        when(facultyRepository.save((Faculty) any())).thenReturn(faculty1);
        when(facultyRepository.findByUsernameAndPassword((String) any(), (String) any())).thenReturn(ofResult);

        HashSet<Course> courseSet = new HashSet<>();
        courseSet.add(new Course());

        Faculty faculty2 = new Faculty();
        faculty2.setContactNo("Contact No");
        faculty2.setCourses(courseSet);
        faculty2.setEmail("jane.doe@example.org");
        faculty2.setEmployeeId("42");
        faculty2.setFacultyUuid(UUID.randomUUID());
        faculty2.setName("Name");
        faculty2.setPassword("hello");
        faculty2.setRole(new Role());
        faculty2.setUsername("janedoe");
        assertSame(faculty1, facultyService.updateFaculty(faculty2));
        verify(courseRepository).findByCourseUuid((UUID) any());
        verify(facultyRepository).save((Faculty) any());
        verify(facultyRepository).findByUsernameAndPassword((String) any(), (String) any());
    }

}

