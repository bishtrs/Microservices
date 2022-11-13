package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
	
    List<Book> books = new ArrayList<>();
        
    public BookRestController() {
        books.add(new Book("The Fountainhead", "Ayn Rand", "Philosophical"));
        books.add(new Book("Murder on the Orient Express", "Agatha Christie", "Thriller"));
        books.add(new Book("The Silence of the Lambs", "Thomas Harris", "Thriller"));
    }

    @GetMapping("/{id}") 
    public Book get(@PathVariable("id") int id) {
        return books.get(id);
    }
}
   