package com.bookrecommend.demo.controller;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.response.CommonResponse;
import com.bookrecommend.demo.response.ReviewResponse;
import com.bookrecommend.demo.request.ReviewRequest;
import com.bookrecommend.demo.service.BookService;
import com.bookrecommend.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final BookService bookService;

    @PostMapping("/review")
    public ResponseEntity<CommonResponse<ReviewResponse>> save(@RequestBody ReviewRequest request) {
        Book book = bookService.findBook(request.getBookId());
        Review newReview = request.toEntity(request.getReviewId(), book, request.getMemberId(), request.getContents(), request.getFileUrl(), request.getRating());
        reviewService.save(newReview);

        return  ResponseEntity.ok(CommonResponse.success());
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<CommonResponse<ReviewResponse>> search(@PathVariable("id") Long bookId) {
        Review review = reviewService.search(bookId);
        ReviewResponse response = ReviewResponse.search(review);
        return ResponseEntity.ok(CommonResponse.success(response));
    }
}
