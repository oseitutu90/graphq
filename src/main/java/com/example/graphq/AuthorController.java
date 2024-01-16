package com.example.graphq;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    private final BookService bookService;

    public AuthorController(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    @QueryMapping
    public Iterable<Author> allAuthors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    public Author author(@Argument Long id) {
        return authorRepository.findById(id).orElse(null);
    }
    @MutationMapping
    public Book addBook(@Argument BookInput book) {
        Author author = authorRepository.findById(book.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found."));
        Book newBook = new Book(null, book.title(), book.publisher(), author);
        bookService.save(newBook);
        return newBook;
    }


    @SchemaMapping(typeName = "Author", field = "books")
    public List<Book> books(Author author) {
        return bookService.findByAuthor(author);
    }
    public record BookInput(String title, String publisher, Long authorId){}
}
