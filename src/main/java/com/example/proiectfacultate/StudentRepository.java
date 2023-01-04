package com.example.proiectfacultate;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByExternalId(UUID externalId);

    @Transactional
    void deleteByExternalId(UUID externalId);
}
