package com.casestudy.user.controller;

import com.casestudy.user.model.StudentRegister;
import com.casestudy.user.repositories.StudentRepository;
import com.casestudy.user.entity.Student;
import com.casestudy.user.entity.UserDetails;
import com.casestudy.user.model.CourseEnroll;
import com.casestudy.user.repositories.UserDetailsRepository;
import com.casestudy.user.service.EducationService;
import com.casestudy.user.service.StudentService;
import com.casestudy.user.service.utils.StudentDetailsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/education")
public class StudentController {

    @Autowired
    private EducationService educationService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDetailsHelper studentHelper;

    @GetMapping("/hello")
    public UserDetails UserInformation(@RequestBody UserDetails user) {
        educationService.helloString(user.getUserName());
        UserDetails response = userDetailsRepository.findByUserName(user.getUserName());
        if (Objects.isNull(response)) {
            userDetailsRepository.save(user);
            response = userDetailsRepository.findByUserName(user.getUserName());
        }
        return response;
    }


    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody StudentRegister student) {
        Student studentDetails = studentHelper.mapToEntityModel(student);
        Student registeredStudent = studentService.registerStudent(studentDetails);
        return Objects.nonNull(registeredStudent)?new ResponseEntity<>(registeredStudent, HttpStatus.CREATED)
                : new ResponseEntity<>("Registered with username already!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/student")
    public String getByUserName1(@RequestParam String username, @RequestParam String password) {
        return studentRepository.findByUsernameAndPassword(username, password).toString();
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Optional<Student> student = studentService.login(username, password);
        return student.isPresent()
                ? new ResponseEntity<>("Login successful", HttpStatus.OK)
                : new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/enrollCourse")
    public ResponseEntity<Object> enrollCourse(@RequestBody CourseEnroll courseEnroll) {
        Student student = studentService.enrollment(courseEnroll);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
