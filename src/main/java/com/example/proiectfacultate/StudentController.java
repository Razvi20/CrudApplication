package com.example.proiectfacultate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public void saveStudent(@RequestBody StudentEntity student){
        service.saveStudent(student);
    }

    @GetMapping
    public List<StudentEntity> findAllStudents(){
        return service.findAll();
    }

    @GetMapping("{externalId}")
    public StudentEntity findOneStudent(@PathVariable UUID externalId){
        return service.findByExternalId(externalId);
    }

    @DeleteMapping("/{externalId}")
    public void deleteStudent(@PathVariable UUID externalId){
        service.deleteStudent(externalId);
    }

    @PutMapping("/{externalId}")
    public void updateStudent(@PathVariable UUID externalId, @RequestBody StudentEntity studentUpdated){
        service.updateStudent(externalId,studentUpdated);
    }

}
