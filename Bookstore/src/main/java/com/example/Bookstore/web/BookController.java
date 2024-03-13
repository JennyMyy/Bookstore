package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository carepository;


    // Shows all books
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String ShowIndex(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    // Restfulservice to get all books
    @RequestMapping(value="/books", method=RequestMethod.GET)
        public @ResponseBody List<Book> booklistRest() {
            return(List<Book>) repository.findAll();
        }
    
    // Restful service to get student by id
    @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }
    
    
    // Add books
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", carepository.findAll());
        return "addbook";
    }

    // Save a new book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    // Edit selected book
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("departments", repository.findAll());
        model.addAttribute("categories", carepository.findAll());
        return "edit";
    }

    // Delete by book id, admin only
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    // show all books
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

}
