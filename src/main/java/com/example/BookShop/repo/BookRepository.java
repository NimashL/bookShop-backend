package com.example.BookShop.repo;

import com.example.BookShop.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository

public interface BookRepository extends JpaRepository<Book,Long> {

}
