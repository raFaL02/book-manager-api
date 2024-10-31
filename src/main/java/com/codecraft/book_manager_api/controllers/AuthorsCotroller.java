package com.codecraft.book_manager_api.controllers;

import com.codecraft.book_manager_api.domain.author.Author;
import com.codecraft.book_manager_api.domain.book.Book;
import com.codecraft.book_manager_api.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorsCotroller {

    @Autowired
    private AuthorsRepository authorsRepository;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorsRepository.findAll();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorsRepository.save(author);
    }

    @GetMapping("/{id}")
    public Author getAuthorsById(@PathVariable UUID id) {
        return authorsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable UUID id, @RequestBody Author authorDetails) {
        return authorsRepository.findById(id).map(author -> {
            author.setName(authorDetails.getName());
            author.setBiography(authorDetails.getBiography());
            return authorsRepository.save(author);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable UUID id) {
        authorsRepository.deleteById(id);
    }

    @GetMapping("/{authorId}/books")
    public List<Book> getBooksByAuthos(@PathVariable UUID authorId) {
        return (List<Book>) authorsRepository.findById(authorId).map(Author::getBooks).orElse(null);
    }
}
