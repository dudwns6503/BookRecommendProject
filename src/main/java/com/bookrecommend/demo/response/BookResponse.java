package com.bookrecommend.demo.response;

import com.bookrecommend.demo.domain.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookResponse {

    private String title;
    private String author;
    private String isbn;
    private String description;
    private Integer price;
    private String publisher;
    private String publishDate;
    private String thumbnailImage;
    private String rating;

    public static BookResponse from(Book book) {
        return BookResponse.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .description(book.getDescription())
                .price(book.getPrice())
                .publisher(book.getPublisher())
                .publishDate(book.getPublishDate())
                .thumbnailImage(book.getThumbnailImage())
                .rating(String.valueOf(book.getRating()))
                .build();
    }
}
