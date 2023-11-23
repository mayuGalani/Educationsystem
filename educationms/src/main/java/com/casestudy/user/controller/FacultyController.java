package com.casestudy.user.controller;

import com.casestudy.user.model.FacultyRegister;
import com.casestudy.user.repositories.FacultyRepository;
import com.casestudy.user.entity.Faculty;
import com.casestudy.user.service.FacultyService;
import com.casestudy.user.service.utils.FacultyDetailsHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/faculty")
@Transactional
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private FacultyDetailsHelper facultyDetailsHelper;

    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody FacultyRegister facultyRegister) {
        Faculty faculty = facultyService.registerFaculty(facultyDetailsHelper.mapToEntityModel(facultyRegister));
        return faculty!=null
                ? new ResponseEntity<>(faculty, HttpStatus.CREATED)
                : new ResponseEntity<>("Registered with username already!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password) {
        Optional<Faculty> faculty = facultyService.login(username, password);
        return faculty.isPresent()
                ? new ResponseEntity<>(faculty, HttpStatus.OK)
                : new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateFaculty(@RequestBody FacultyRegister facultyRegister) {
        Faculty faculty = facultyService.updateFaculty(facultyDetailsHelper.mapToEntityModel(facultyRegister));
        return faculty!=null
                ? new ResponseEntity<>(faculty, HttpStatus.ACCEPTED)
                : new ResponseEntity<>("Faculty not found!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> removeFaculty(@RequestParam String username, @RequestParam String password) {
        Optional<Faculty> faculty = facultyRepository.findByUsernameAndPassword(username,password);
        if(faculty.isPresent()){
            facultyRepository.deleteByFacultyUuid(faculty.get().getFacultyUuid());
            return new ResponseEntity<>("Faculty Removed Successfully!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Faculty not found!", HttpStatus.BAD_REQUEST);
        }
    }

}
