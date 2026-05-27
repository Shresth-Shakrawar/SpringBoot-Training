package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	
	public List<Book> getAllBooks(){
		return repository.getAll();
	}
	
	public Book getBookById(int id) {
		return repository.findById(id);
	}
	
	public Book addBook(Book b) {
		return repository.save(b);
	}
	
	public Book updated(Book b) {
		Book updated = repository.update(b);
		return updated;
	}
	
	public String deleteBook(int id) {
		return repository.delete(id);
	}
	
	
}