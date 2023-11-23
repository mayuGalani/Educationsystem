package com.casestudy.user.service.utils;

import com.casestudy.user.model.StudentRegister;
import com.casestudy.user.repositories.CourseRepository;
import com.casestudy.user.entity.Course;
import com.casestudy.user.entity.Role;
import com.casestudy.user.entity.Student;
import com.casestudy.user.model.CourseRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentDetailsHelper {


    @Autowired
    private CourseRepository courseRepository;
    public Student mapToEntityModel(StudentRegister student) {
        Student studentDetails = new Student();

        if (Objects.nonNull(student.getName())) {
            studentDetails.setName(student.getName());
        }
        if (Objects.nonNull(student.getUsername())) {
            studentDetails.setUsername(student.getUsername());
        }
        if (Objects.nonNull(student.getPassword())) {
            studentDetails.setPassword(student.getPassword());
        }
        if (Objects.nonNull(student.getAddress())) {
            studentDetails.setAddress(student.getAddress());
        }
        if (Objects.nonNull(student.getState())) {
            studentDetails.setState(student.getState());
        }
        if (Objects.nonNull(student.getCountry())) {
            studentDetails.setCountry(student.getCountry());
        }
        if (Objects.nonNull(student.getEmail())) {
            studentDetails.setEmail(student.getEmail());
        }
        if (Objects.nonNull(student.getStudentId())) {
            studentDetails.setStudentId(student.getStudentId());
        }
        if (Objects.nonNull(student.getContactNo())) {
            studentDetails.setContactNo(student.getContactNo());
        }
        if (Objects.nonNull(student.getDateOfBirth())) {
            studentDetails.setDateOfBirth(student.getDateOfBirth());
        }
        if (Objects.nonNull(student.getCourses())) {
            ArrayList<Course> courses = new ArrayList<>();
            for(CourseRegister courseRegister: student.getCourses()) {
                System.out.println(courseRegister);
                Course repoCourse = courseRepository.findByCourseUuid(courseRegister.getCourseUuid());
                courses.add(repoCourse);
            }
            studentDetails.setCourses(new HashSet<>(courses.stream().toList()));
        }
        Role role = new Role(RoleEnum.USER);
        studentDetails.setRole(role);
        return studentDetails;
    }
}
