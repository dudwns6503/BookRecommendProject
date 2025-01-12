package com.bookrecommend.demo.request;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Member;
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
    private Long memberId;
    private String contents;
    private String fileUrl;
    private int rating;

    public Review toEntity(String reviewId, Book book, Member member, String contents, String fileUrl, int rating) {
        return Review.builder()
                .reviewId(reviewId)
                .book(book)
                .member(member)
                .contents(contents)
                .fileUrl(fileUrl)
                .rating(rating)
                .build();
    }
}
