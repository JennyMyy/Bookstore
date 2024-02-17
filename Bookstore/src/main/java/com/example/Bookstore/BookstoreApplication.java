package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {

			repository.save(new Book("Idän pikajunan arvoitus", "Agatha Christie", 1934, "23567-34632", 14.45));
			repository.save(new Book("Baskervillen koira", "Arthur Conan Doyle", 1902, "3563423-67", 9.99));
			repository.save(new Book("Call me by your name", "André Aciman", 2007, "9764532-35", 11.68));
			repository.save(new Book("Normaaleja ihmisiä", "Sally Rooney", 2018, "8765435-12", 19.99));
			repository.save(new Book("Katariina", "Sally Salminen", 1936, "534523-34", 15.67));
		};

	}

}
