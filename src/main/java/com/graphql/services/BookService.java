package com.graphql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graphql.entities.Book;
import com.graphql.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	@Transactional
	public Book create(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBookById(int bookId) {
		return bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("No book was found in the server"));
	}
	@Transactional
	public Book updateBook(Book book) {
		Book existingBook = bookRepo.findById(book.getBookId()).orElseThrow(()->new RuntimeException("No record found"));
		existingBook.setBookAuthor(book.getBookAuthor());
		existingBook.setBookTitle(book.getBookTitle());
		return bookRepo.save(existingBook);
	}
	
	@Transactional
	public void deleteBook(Book book) {
		Book existingBook = bookRepo.findById(book.getBookId()).orElseThrow(()->new RuntimeException("No record found"));
		existingBook.setBookAuthor(book.getBookAuthor());
		existingBook.setBookTitle(book.getBookTitle());
		bookRepo.delete(existingBook);
	}
}
