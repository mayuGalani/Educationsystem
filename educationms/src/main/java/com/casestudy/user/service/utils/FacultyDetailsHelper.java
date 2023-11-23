package com.casestudy.user.service.utils;

import com.casestudy.user.model.FacultyRegister;
import com.casestudy.user.repositories.CourseRepository;
import com.casestudy.user.entity.Course;
import com.casestudy.user.entity.Faculty;
import com.casestudy.user.entity.Role;
import com.casestudy.user.model.CourseRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

@Component
public class FacultyDetailsHelper {


    @Autowired
    private CourseRepository courseRepository;
    public Faculty mapToEntityModel(FacultyRegister facultyRegister) {
        Faculty faculty = new Faculty();

        if (Objects.nonNull(facultyRegister.getName())) {
            faculty.setName(facultyRegister.getName());
        }
        if (Objects.nonNull(facultyRegister.getUsername())) {
            faculty.setUsername(facultyRegister.getUsername());
        }
        if (Objects.nonNull(facultyRegister.getPassword())) {
            faculty.setPassword(facultyRegister.getPassword());
        }
        if (Objects.nonNull(facultyRegister.getEmail())) {
            faculty.setEmail(facultyRegister.getEmail());
        }
        if (Objects.nonNull(facultyRegister.getEmployeeId())) {
            faculty.setEmployeeId(facultyRegister.getEmployeeId());
        }
        if (Objects.nonNull(facultyRegister.getContactNo())) {
            faculty.setContactNo(facultyRegister.getContactNo());
        }
        if (Objects.nonNull(facultyRegister.getCourses())) {
            ArrayList<Course> courses = new ArrayList<>();
            for(CourseRegister courseRegister: facultyRegister.getCourses()) {
                System.out.println(courseRegister);
                Course repoCourse = courseRepository.findByCourseUuid(courseRegister.getCourseUuid());
                courses.add(repoCourse);
            }
            faculty.setCourses(new HashSet<>(courses.stream().toList()));
        }
        Role role = new Role(RoleEnum.USER);
        faculty.setRole(role);
        return faculty;
    }
}
