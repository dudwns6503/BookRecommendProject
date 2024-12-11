package com.bookrecommend.demo.service;

import com.bookrecommend.demo.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("성공 - 책 저장 테스트")
    void saveSuccessWhenValidBookIsGiven() {
        // given
        Book book = Book.builder()
                .title("소년이 온다")
                .author("한강")
                .price(20000)
                .thumbnailImage("https://imageUrl")
                .isbn("123123213")
                .build();

        // when
        bookService.save(book);

        // then
        Book savedBook = bookService.findBook(1L);
        assertThat(savedBook.getTitle()).isEqualTo(book.getTitle());
    }
}