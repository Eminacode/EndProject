package com.QA.H2Example.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/student")
    private List<Student> getAllStudent(){

        return (List<Student>) studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    private Optional<Student> getStudent(@PathVariable("id") int id){

        return studentRepository.findById(id);
    }


    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable("id") int id){
        studentRepository.deleteById(id);
    }

    @PostMapping("/student")
    private int saveStudent(@RequestBody Student student){
        studentRepository.save(student);
        return student.getId();
    }

}