package com.example.BookShop.controller;

import com.example.BookShop.domain.Book;
import com.example.BookShop.resource.BookResource;
import com.example.BookShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public String saveBook(@RequestBody BookResource bookResource){

        return bookService.addBook(bookResource);
    }

    @GetMapping("/all")
    public List<Book> getAllBook(){

        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){

        return bookService.getBookById(id);

    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody BookResource bookResource){

        return bookService.updateBook(id,bookResource);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){

        return bookService.deleteBook(id);

    }

}
