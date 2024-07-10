package com.example.BookShop.service;

import com.example.BookShop.domain.Book;
import com.example.BookShop.resource.BookResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

     String addBook(BookResource bookResource);

     List<Book> getAllBook();

     Optional<Book> getBookById(Long id);

     String updateBook(Long id, BookResource bookResource);

     String deleteBook(Long id);

}