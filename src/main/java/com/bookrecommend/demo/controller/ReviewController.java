package com.bookrecommend.demo.controller;

import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.request.ReviewRequest;
import com.bookrecommend.demo.response.BookResponse;
import com.bookrecommend.demo.response.CommonResponse;
import com.bookrecommend.demo.response.ReviewResponse;
import com.bookrecommend.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/review")
    public ResponseEntity<CommonResponse<ReviewResponse>> createReview() {
        Review review = Review.builder()
                .review_id("review01")
                .book_id("book1")
                .member_id("user1")
                .contents("contents")
                .file_url("")
                .rating(10)
                .build();

        reviewService.createReview(review);

        return  ResponseEntity.ok(CommonResponse.success());
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<CommonResponse<ReviewRequest>> search(@PathVariable("id") String book_id) {
        Review review = reviewService.search(book_id);
        ReviewRequest request = ReviewRequest.search(review);
        System.out.println("Received Review: " + review);
        return ResponseEntity.ok(CommonResponse.success(request));
    }
}
