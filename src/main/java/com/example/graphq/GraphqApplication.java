package com.example.graphq;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableCaching
public class GraphqApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqApplication.class, args);

	}
	@Bean
	public ApplicationRunner initializer(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author twain = new Author();
			twain.setName("Mark Twain");
			authorRepository.save(twain);
			Author bradlyCooper = new Author();
			bradlyCooper.setName("Bradly");
			authorRepository.save(bradlyCooper);


			Book book1 = new Book();
			book1.setTitle("The Adventures of Tom Sawyer");
			book1.setPublisher("American Publishing Company");
			book1.setAuthor(twain);
			bookRepository.save(book1);

			// Additional book entries
			Book book2 = new Book();
			book2.setTitle("Book Title 2");
			book2.setPublisher("Publisher 2");
			book2.setAuthor(bradlyCooper);

			Book book3 = new Book();
			book3.setTitle("Book Title 3");
			book3.setPublisher("Publisher 3");
			book3.setAuthor(bradlyCooper);


			Book book4 = new Book();
			book4.setTitle("Book Title 4");
			book4.setPublisher("Publisher 4");
			book4.setAuthor(twain);
			bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
		};
	}
	}
