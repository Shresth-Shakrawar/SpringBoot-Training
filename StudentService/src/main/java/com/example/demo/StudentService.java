package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service 

public class StudentService {
	@Autowired
	private StudentRepository repository;
	public Student save(Student s) {
		if (repository.findByEmail(s.getEmail()).isPresent()) {
			throw new RuntimeException("Email already registered: " + s.getEmail());
		}
		return repository.save(s);
	}
	public List<Student> getAll(){
		return repository.findAll();
	}
	public Optional<Student> getStudentById(Long id) {
		return repository.findById(id);

	}
	public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        repository.deleteById(id);
	}
	
}
