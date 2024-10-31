package com.codecraft.book_manager_api.repositories;

import com.codecraft.book_manager_api.domain.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorsRepository extends JpaRepository<Author, UUID> {
}
