package com.example.graphq;

import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @CachePut(value = "books", key = "#author")
    List<Book> findByAuthor(Author author);

    // Other repository methods...
}