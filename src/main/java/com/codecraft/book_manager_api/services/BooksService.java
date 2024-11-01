package com.codecraft.book_manager_api.services;

import com.codecraft.book_manager_api.domain.author.Author;
import com.codecraft.book_manager_api.domain.book.Book;
import com.codecraft.book_manager_api.repositories.AuthorsRepository;
import com.codecraft.book_manager_api.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public Book getBookById(UUID id) {
        return booksRepository.findById(id).orElse(null);
    }

    public Book updateBook(UUID id, Book bookDetails) {
        return booksRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setIsbn(bookDetails.getIsbn());
            book.setGeneres(bookDetails.getGeneres());
            book.setPublishDate(bookDetails.getPublishDate());
            return booksRepository.save(book);
        }).orElse(null);
    }

    public void deleteBook(UUID id) {
        booksRepository.deleteById(id);
    }

    public Book addAuthorToBook(UUID bookId, UUID authorId) {
        Book book = booksRepository.findById(bookId).orElse(null);
        Author author = authorsRepository.findById(authorId).orElse(null);
        if (book != null && author != null) {
            book.getAuthors().add(author);
            return booksRepository.save(book);
        }
        return null;
    }
}
