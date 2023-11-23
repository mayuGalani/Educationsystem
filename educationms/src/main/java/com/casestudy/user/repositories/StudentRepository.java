package com.casestudy.user.repositories;

import com.casestudy.user.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUsernameAndPassword(String username, String password);

    Student findByStudentUuid(UUID studentUuid);

    Student findByUsername(String username);
}
