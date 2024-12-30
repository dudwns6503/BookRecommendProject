package com.bookrecommend.demo.response;

import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.request.ReviewRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponse {

    private String reviewId;
    private Long bookId;
    private String memberId;
    private String contents;
    private String fileUrl;
    private int rating;

    public static ReviewResponse search(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getReviewId())
                .bookId(review.getBook().getId())
                .memberId(review.getMemberId())
                .contents(review.getContents())
                .fileUrl(review.getFileUrl())
                .rating(review.getRating())
                .build();
    }
}
