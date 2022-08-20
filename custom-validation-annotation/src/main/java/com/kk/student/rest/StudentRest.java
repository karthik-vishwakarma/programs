package com.kk.student.rest;

import com.kk.student.model.Student;
import com.kk.student.validation.ValidateStudent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentRest {

    @PostMapping

    public Student createStudent(@Valid @RequestBody @ValidateStudent(message = "Invalid Student Details") Student student) {
        System.out.println("+++++" + student);
        return student;
    }

    @GetMapping
    public String ping() {
        return "ping successfully";
    }
}
