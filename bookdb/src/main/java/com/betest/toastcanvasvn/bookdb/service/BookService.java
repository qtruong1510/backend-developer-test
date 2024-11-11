package com.betest.toastcanvasvn.bookdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betest.toastcanvasvn.bookdb.model.Book;
import com.betest.toastcanvasvn.bookdb.repository.BookRepository;

@Service
public class BookService {

	@Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book); // Save a new book
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Retrieve all books
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id); // Retrieve book by ID
    }
    
 // Update book details
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublishedDate(bookDetails.getPublishedDate());
        book.setIsbn(bookDetails.getIsbn());
        book.setPrice(bookDetails.getPrice());
        return bookRepository.save(book);
    }
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id); // Delete book by ID
    }

}
