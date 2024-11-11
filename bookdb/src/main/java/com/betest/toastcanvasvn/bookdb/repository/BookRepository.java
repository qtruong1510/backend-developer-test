package com.betest.toastcanvasvn.bookdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betest.toastcanvasvn.bookdb.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
