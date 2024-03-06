package com.example.library.service

import com.example.library.domain.Book
import com.example.library.repository.BookRepository

import javax.inject.Singleton

@Singleton
class BookService {
    private final BookRepository bookRepository

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author)
    }
}