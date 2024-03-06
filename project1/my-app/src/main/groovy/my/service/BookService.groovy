package my.service

import io.micronaut.vertx.pg.client.*
import io.vertx.core.json.JsonObject
import jakarta.inject.Singleton

@Singleton
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