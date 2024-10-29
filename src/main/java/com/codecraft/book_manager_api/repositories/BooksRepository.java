package com.codecraft.book_manager_api.repositories;

import com.codecraft.book_manager_api.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BooksRepository extends JpaRepository<Book, UUID> {
}
