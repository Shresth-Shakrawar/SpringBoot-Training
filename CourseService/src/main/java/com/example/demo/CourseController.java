package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	@Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCourse(c));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/enroll")
    public ResponseEntity<Enrollment> enroll(@RequestParam Long studentId,
                                             @RequestParam Long courseId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.enroll(studentId, courseId));
    }

    @GetMapping("/enrollments/{studentId}")
    public ResponseEntity<List<Enrollment>> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getEnrollmentsByStudent(studentId));
    }
}
