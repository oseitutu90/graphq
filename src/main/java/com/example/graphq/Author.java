package com.example.graphq;

import jakarta.persistence.*;

import java.util.List;

@Entity
 public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
