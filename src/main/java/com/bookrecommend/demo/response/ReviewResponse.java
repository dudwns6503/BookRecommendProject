package com.bookrecommend.demo.response;

import com.bookrecommend.demo.domain.Review;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ReviewResponse {

    private String reviewId;
    private Long bookId;
    private Long memberId;
    private String contents;
    private String fileUrl;
    private int rating;

    public static ReviewResponse search(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getReviewId())
                .bookId(review.getBook().getId())
                .memberId(review.getMember().getId())
                .contents(review.getContents())
                .fileUrl(review.getFileUrl())
                .rating(review.getRating())
                .build();
    }

    public static List<ReviewResponse> search(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewResponse::search)
                .collect(Collectors.toList());
    }
}
