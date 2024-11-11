package com.betest.toastcanvasvn.bookdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betest.toastcanvasvn.bookdb.model.Book;
import com.betest.toastcanvasvn.bookdb.service.BookService;

@RestController
@RequestMapping("/api/books")
@Validated
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return ResponseEntity.ok(book); // Retrieve book by ID
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails); // Update book by ID
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id); // Delete book by ID
        return ResponseEntity.noContent().build();
    }

}
