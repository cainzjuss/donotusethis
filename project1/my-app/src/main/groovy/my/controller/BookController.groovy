package my.controller

import my.service.BookService
import my.domain.Book
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import io.micronaut.http.MediaType

@Controller("/books")
class BookController {
    private final BookService bookService

    BookController(BookService bookService) {
        this.bookService = bookService
    }

    @Get("/author/{author}")
    List<Book> findByAuthor(String author) {
        return bookService.findBooksByAuthor(author)
    }
}
@Controller('/hello') // (1)
class HelloController {

    @Get(produces = MediaType.TEXT_PLAIN) // (2)
    String index() {
        'Hello World' // (3)
    }
}