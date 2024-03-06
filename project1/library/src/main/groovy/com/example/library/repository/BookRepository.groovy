package com.example.library.repository
import com.example.library.domain.Book
import io.micronaut.data.annotation.*
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.repository.CrudRepository;

@Repository
interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query(value = "SELECT * FROM books WHERE author = :author", nativeQuery = true)
    List<Book> findByAuthor(String author);
}