package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // 1. CREATE
    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    // 2. READ ALL
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // 3. Get BY ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = repository.findById(id);
        // Returns the employee if found, otherwise returns null
        return employee.orElse(null); 
    }

    // 4. UPDATE
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedInfo) {
        return repository.findById(id)
            .map(employee -> {
                employee.setName(updatedInfo.getName());
                employee.setDepartment(updatedInfo.getDepartment());
                return repository.save(employee);
            })
            .orElseGet(() -> {
                // If not found, save as a new employee
                updatedInfo.setId(id);
                return repository.save(updatedInfo);
            });
    }

    // 5. DELETE
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}