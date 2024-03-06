package com.example.library.domain

import io.micronaut.data.annotation.*
import io.micronaut.data.model.*
import javax.persistence.*
import io.micronaut.core.annotation.NonNull

@Entity
@Table(name = "books")
class Book {
    @Id
    @GeneratedValue
    Long id

    @NonNull
    String title

    @NonNull
    String author

    @NonNull
    String isbn

    @NonNull
    @Enumerated(EnumType.STRING)
    Status status
}


enum Status {
    AVAILABLE, BORROWED
}