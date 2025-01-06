package com.example.spring_security.student;

import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")  // Corrected version: "vi" to "v1"
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James"),  // Corrected constructor calls
            new Student(2, "Maria")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        // Find the student by ID
        Optional<Student> student = STUDENTS.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst();

        // Return the student or throw an exception if not found
        return student.orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
