package com.graphql.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import com.graphql.entities.Book;
import com.graphql.entities.BookInput;
import com.graphql.services.BookService;

import reactor.core.publisher.Flux;

@Controller
public class BookControllerGL {

	@Autowired
	BookService bookService;
	
	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
		Book book1 = new Book();
		book1.setBookAuthor(book.getBookAuthor());
		book1.setBookPages(book.getBookPages());
		book1.setBookPrice(book.getBookPrice());
		book1.setBookTitle(book.getBookTitle());
		return bookService.create(book1);
	}
	
	@MutationMapping("updateBook")
	public Book updateBook(@Argument BookInput book) {
		Book book1 = new Book();
		book1.setBookAuthor(book.getBookAuthor());
		book1.setBookTitle(book.getBookTitle());
		//book.setBookPages(b.getBookPages());
		//book.setBookPrice(b.getBookPrice());
		book1.setBookId(book.getBookId());
		return bookService.updateBook(book1);
	}
	
	@MutationMapping("deleteBook")
	public List<Book> deleteBook(@Argument BookInput book){
		Book book1 = new Book();
		book1.setBookId(book.getBookId());
		book1.setBookAuthor(book.getBookAuthor());
		book1.setBookPages(book.getBookPages());
		book1.setBookPrice(book.getBookPrice());
		book1.setBookTitle(book.getBookTitle());
		bookService.deleteBook(book1);
		return bookService.getAllBooks();
	}
	
	@QueryMapping("allBooks")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@QueryMapping("getBook")
	public Book getBookById(@Argument int bookId) {
		return bookService.getBookById(bookId);
	}
	
	@SubscriptionMapping
	public Flux<List<Book>> notifyForBook(){
		return Flux.fromStream(
				Stream.generate(()->{
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						e.printStackTrace();
					}
					var bookRecord = bookService.getAllBooks();
					return bookRecord;
				}));
	}
}
