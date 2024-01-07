package com.example.graphq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable("books")
    public List<Book> findByAuthor(Author author) {
        log.info("Fetching books for author {}", author.getName());
        return bookRepository.findByAuthor(author);
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
}
