package com.bookrecommend.demo.request;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.service.BookService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class ReviewRequest {

    private String reviewId;
    private Long bookId;
    private String memberId;
    private String contents;
    private String fileUrl;
    private int rating;

    public Review toEntity(String reviewId, Book book, String memberId, String contents, String fileUrl, int rating) {
        return Review.builder()
                .reviewId(reviewId)
                .book(book)
                .memberId(memberId)
                .contents(contents)
                .fileUrl(fileUrl)
                .rating(rating)
                .build();
    }
}
