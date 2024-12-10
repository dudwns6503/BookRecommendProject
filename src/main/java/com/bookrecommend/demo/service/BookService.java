package com.bookrecommend.demo.service;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.exception.BookNotFoundException;
import com.bookrecommend.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void save(Book book) {
        Book savedBook = bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book findBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException());

        return book;
    }
}
