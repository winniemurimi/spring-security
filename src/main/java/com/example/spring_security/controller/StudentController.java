package com.example.spring_security.controller;

import com.example.spring_security.models.entities.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")  // Corrected version: "vi" to "v1"
public class StudentController {

    private static final List<Student> STUDENTS = List.of(// Corrected constructor calls
            new Student(1, "C1928hjt","Artwel Murimi")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("id") Integer id) {
        // Find the student by ID
        Optional<Student> student = STUDENTS.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst();

        // Return the student or throw an exception if not found
        return student.orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
