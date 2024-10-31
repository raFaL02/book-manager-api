package com.codecraft.book_manager_api.controllers;

import com.codecraft.book_manager_api.domain.author.Author;
import com.codecraft.book_manager_api.domain.book.Book;
import com.codecraft.book_manager_api.repositories.AuthorsRepository;
import com.codecraft.book_manager_api.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return booksRepository.save(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable UUID id) {
        return booksRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable UUID id, @RequestBody Book bookDetails) {
        return booksRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setIsbn(bookDetails.getIsbn());
            book.setGeneres(bookDetails.getGeneres());
            book.setPublishDate(bookDetails.getPublishDate());
            return booksRepository.save(book);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id) {
        booksRepository.deleteById(id);
    }

    @PostMapping("/{bookId}/authors/{authorId}")
    public Book addAuthorToBook(@PathVariable UUID bookId, @PathVariable UUID authorId) {
        Book book = booksRepository.findById(bookId).orElse(null);
        Author author = authorsRepository.findById(authorId).orElse(null);
        if (book != null && author != null) {
            book.getAuthors().add(author);
            return booksRepository.save(book);
        }
        return null;
    }
}
