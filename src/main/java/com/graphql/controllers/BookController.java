package com.graphql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.entities.Book;
import com.graphql.services.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/create")
	public Book create(@RequestBody Book b) {
		return bookService.create(b);
	}
	
	@GetMapping("/get")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getById/{bookId}")
	public Book getBookById(@PathVariable int bookId) {
		return bookService.getBookById(bookId);
	}
}
