package com.codecraft.book_manager_api.domain.book;

import com.codecraft.book_manager_api.domain.author.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Table(name = "books")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String isbn;
    private String generes;
    private Date publishDate;

    @ManyToMany
    @JoinTable(
            name = "authors",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id")
            )
    Set<Author> authors;
}
