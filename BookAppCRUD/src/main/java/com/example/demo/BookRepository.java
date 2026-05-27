package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private List<Book> list = new ArrayList<>();


    public List<Book> getAll() {
        return list;
    }

    public Book findById(int id) {
        return list.stream()
                   .filter(b -> b.getId() == id)
                   .findFirst()
                   .orElse(null);
    }

    public Book save(Book book) {
        list.add(book);
        return book;
    }

    public Book update(Book book) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == book.getId()) {
                list.set(i, book);
                return book;
            }
        }
        return null;
    }

    public String delete(int id) {
        list.removeIf(b -> b.getId() == id);
        return "Book with id " + id + " deleted successfully.";
    }
}