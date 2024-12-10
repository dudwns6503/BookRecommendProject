package com.bookrecommend.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;
    private String author;
    private String isbn;

    @Column(length = 1000)
    private String description;

    private Integer price;
    private String publisher;
    private String publishDate;
    private String thumbnailImage;

    //@Column(columnDefinition = "DECIMAL(2, 1)")
    @Column(precision = 2, scale = 1)
    private BigDecimal rating;

    @Builder
    public Book(String title, String author, Integer price, String isbn, String thumbnailImage) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.thumbnailImage = thumbnailImage;
    }

    public void changeBookName(String title) {
        this.title = title;
    }
}
