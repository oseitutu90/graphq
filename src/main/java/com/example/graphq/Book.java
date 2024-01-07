package com.example.graphq;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String publisher;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book(Long id, String title, String publisher, Author author) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String ttile) {
        this.title = ttile;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
