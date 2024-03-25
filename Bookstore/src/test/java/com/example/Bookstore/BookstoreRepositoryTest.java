package com.example.Bookstore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository carepository;

    @Test
    public void findByTitleReturnsBook() {
        
        List<Book> books = repository.findByTitle("Katariina");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Sally Salminen");
    }

    @Test
    public void createNewStudentAndDelet() {
        Category category = new Category("Scifi");
        carepository.save(category);
        Book book = new Book("Dyyni", "Joku kirjailija", 1936, "7834035-na", 18.67, category);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
        repository.delete(book);
    }


}
