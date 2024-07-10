package com.example.BookShop.service.impl;

import com.example.BookShop.domain.Book;
import com.example.BookShop.repo.BookRepository;
import com.example.BookShop.resource.BookResource;
import com.example.BookShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public String addBook(BookResource bookResource){
        Book book = new Book();

        book.setTitle(bookResource.getTitle());
        book.setAuthor(bookResource.getAuthor());
        book.setPublishedDate(bookResource.getPublishedDate());
        bookRepository.save(book);

        return "record saved successfully.";
    }

    @Override
    public List<Book> getAllBook(){

        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            return Optional.ofNullable(book.get());
        }else {
            return Optional.empty();
        }
    }

    @Override
    public String updateBook(Long id, BookResource bookResource){
        Optional<Book> extistBook = bookRepository.findById(id);
        if(extistBook.isPresent()){
            Book book = extistBook.get();
            book.setTitle(bookResource.getTitle());
            book.setAuthor(bookResource.getAuthor());
            book.setPublishedDate(bookResource.getPublishedDate());
            bookRepository.save(book);
            return "record updated successfully";
        }else {
            return "record not found";
        }
    }

    @Override
    public String deleteBook(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            bookRepository.deleteById(id);
            return "record delete successfully";
        }else {
            return "record not found";
        }

    }

}
