package com.codecraft.book_manager_api.controllers;

import com.codecraft.book_manager_api.domain.author.Author;
import com.codecraft.book_manager_api.domain.book.Book;
import com.codecraft.book_manager_api.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorsCotroller {

    @Autowired
    private AuthorsService authorsService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorsService.getAllAuthors();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorsService.createAuthor(author);
    }

    @GetMapping("/{id}")
    public Author getAuthorsById(@PathVariable UUID id) {
        return authorsService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable UUID id, @RequestBody Author authorDetails) {
        return authorsService.updateAuthor(id, authorDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable UUID id) {
        authorsService.deleteAuthor(id);
    }

    @GetMapping("/{authorId}/books")
    public Set<Book> getBooksByAuthos(@PathVariable UUID authorId) {
        return authorsService.getBooksByAuthor(authorId);
    }
}
