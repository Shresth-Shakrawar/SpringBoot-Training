package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.validation.Valid;

import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/all")
	public List<Customer> getAllCustomers(){
		return repository.findAll();	
	}
	@PostMapping("/add")
	public Customer insertCustomer(@Valid @RequestBody Customer customer) {
		return repository.save(customer);
	} 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
	
}
