package com.example.proiectfacultate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void saveStudent(StudentEntity student){
        student.setExternalId(UUID.randomUUID());
        repository.save(student);
    }

    public List<StudentEntity> findAll(){
        return repository.findAll();
    }

    public StudentEntity findByExternalId(UUID externalId){
        return repository.findByExternalId(externalId);
    }

    public void deleteStudent(UUID externalId){
        repository.deleteByExternalId(externalId);
    }

    public void updateStudent(UUID externalId, StudentEntity studentUpdated){
        StudentEntity studentToUpdate = repository.findByExternalId(externalId);

        studentToUpdate.setNume(studentUpdated.getNume());
        studentToUpdate.setPrenume(studentUpdated.getPrenume());
        studentToUpdate.setAn(studentUpdated.getAn());

        repository.save(studentToUpdate);
    }

}
