package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		return service.getBookById(id);
	}
	@PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return service.updated(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }
	
}
