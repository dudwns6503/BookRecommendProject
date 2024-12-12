package com.bookrecommend.demo.request;

import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.response.ReviewResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewRequest {
    private String review_id;
    private String book_id;
    private String member_id;
    private String contents; // String ?
    private String file_url;
    private int rating;

    public static ReviewRequest search(Review review) {
        return ReviewRequest.builder()
                .review_id(review.getReview_id())
                .book_id(review.getBook_id())
                .member_id(review.getMember_id())
                .contents(review.getContents())
                .file_url(review.getFile_url())
                .rating(review.getRating())
                .build();
    }
}
