package com.codecraft.book_manager_api.services;

import com.codecraft.book_manager_api.domain.author.Author;
import com.codecraft.book_manager_api.domain.book.Book;
import com.codecraft.book_manager_api.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    public List<Author> getAllAuthors() {
        return authorsRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return authorsRepository.save(author);
    }

    public Author getAuthorById(UUID id) {
        return authorsRepository.findById(id).orElse(null);
    }

    public Author updateAuthor(UUID id, Author authorDetails) {
        return authorsRepository.findById(id).map(author -> {
            author.setName(authorDetails.getName());
            author.setBiography(authorDetails.getBiography());
            return authorsRepository.save(author);
        }).orElse(null);
    }

    public void deleteAuthor(UUID id) {
        authorsRepository.deleteById(id);
    }

    public Set<Book> getBooksByAuthor(UUID authorId) {
        return authorsRepository.findById(authorId).map(Author::getBooks).orElse(null);
    }
}
