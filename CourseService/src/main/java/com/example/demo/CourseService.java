package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollRepo;
    private final RestTemplate restTemplate;
    
    public CourseService(CourseRepository courseRepo,
            EnrollmentRepository enrollRepo,
            RestTemplate restTemplate) {
		this.courseRepo = courseRepo;
		this.enrollRepo = enrollRepo;
		this.restTemplate = restTemplate;
		}

    public Course createCourse(Course c) {
        return courseRepo.save(c);
    }

    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Enrollment enroll(Long studentId, Long courseId) {
        // verify student exists in student-service — throws if not found
        try {
            restTemplate.getForObject(
                "http://localhost:8081/api/students/" + studentId, Object.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Student not found with id: " + studentId);
        }

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(studentId);
        enrollment.setCourse(course);
        return enrollRepo.save(enrollment);
        
    }

    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollRepo.findByStudentId(studentId);
    }
}