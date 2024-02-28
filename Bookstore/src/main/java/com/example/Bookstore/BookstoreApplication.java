package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
		private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository carepository) {
		return (args) -> {
			log.info("save a couple of books");

			Category category1 = new Category("Detective story");
			Category category2 = new Category("Romance");
			Category category3 = new Category("Fiction");

			carepository.save(category1);
			carepository.save(category2);
			carepository.save(category3);

			repository.save(new Book("Idän pikajunan arvoitus", "Agatha Christie", 1934, "23567-34632", 14.45,category1));
			repository.save(new Book("Baskervillen koira", "Arthur Conan Doyle", 1902, "3563423-67", 9.99, category1));
			repository.save(new Book("Call me by your name", "André Aciman", 2007, "9764532-35", 11.68, category2));
			repository.save(new Book("Normaaleja ihmisiä", "Sally Rooney", 2018, "8765435-12", 19.99, category2));
			repository.save(new Book("Katariina", "Sally Salminen", 1936, "534523-34", 15.67, category3));


			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};

	}

}
