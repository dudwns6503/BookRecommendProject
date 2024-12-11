package com.bookrecommend.demo.repository;

import com.bookrecommend.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
