package com.codecraft.book_manager_api.controllers;

import com.codecraft.book_manager_api.domain.book.Book;
import com.codecraft.book_manager_api.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return booksService.createBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable UUID id) {
        return booksService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable UUID id, @RequestBody Book bookDetails) {
        return booksService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id) {
        booksService.deleteBook(id);
    }

    @PostMapping("/{bookId}/authors/{authorId}")
    public Book addAuthorToBook(@PathVariable UUID bookId, @PathVariable UUID authorId) {
        return booksService.addAuthorToBook(bookId, authorId);
    }
}
