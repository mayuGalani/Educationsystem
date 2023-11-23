package com.casestudy.user.repositories;

import com.casestudy.user.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FacultyRepository extends JpaRepository<Faculty, UUID> {

    Optional<Faculty> findByUsernameAndPassword(String username, String password);

    void deleteByFacultyUuid(UUID facultyUuid);

}
