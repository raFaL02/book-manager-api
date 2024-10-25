package com.codecraft.book_manager_api.domain.author;

import com.codecraft.book_manager_api.domain.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Table(name = "authors")
@Entity
@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String biography;

    @ManyToMany(mappedBy = "authors")
    Set<Book> books;
}
