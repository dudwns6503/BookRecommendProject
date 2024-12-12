package com.bookrecommend.demo.response;

import com.bookrecommend.demo.domain.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponse {

    private String review_id;
    private String book_id;
    private String member_id;
    private String contents;
    private String file_url;
    private int rating;

    public ReviewResponse createReview (Review review) {
        return ReviewResponse.builder()
                .review_id(review.getReview_id())
                .book_id(review.getBook_id())
                .member_id(review.getMember_id())
                .contents(review.getContents())
                .file_url(review.getFile_url())
                .rating(review.getRating())
                .build();
    }
}
