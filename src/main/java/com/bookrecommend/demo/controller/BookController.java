package com.bookrecommend.demo.controller;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.response.BookResponse;
import com.bookrecommend.demo.response.CommonResponse;
import com.bookrecommend.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<CommonResponse<BookResponse>> createBook() {
        // 받은 데이터를 검증 후 엔티티로 변환하거나 DTO를 통해 Service 계층으로 넘겨주는 것이 일반적이다.
        Book book = Book.builder()
                .title("채식주의자")
                .author("한강")
                .price(20000)
                .thumbnailImage("https://imageUrl")
                .isbn("123123213")
                .build();

        bookService.save(book);

        return ResponseEntity.ok(CommonResponse.success());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<CommonResponse<BookResponse>> findBook(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);

        BookResponse response = BookResponse.from(book);

        return ResponseEntity.ok(CommonResponse.success(response));
    }
}
