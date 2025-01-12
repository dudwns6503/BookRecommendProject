package com.bookrecommend.demo.controller;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Member;
import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.response.CommonResponse;
import com.bookrecommend.demo.response.ReviewResponse;
import com.bookrecommend.demo.request.ReviewRequest;
import com.bookrecommend.demo.service.BookService;
import com.bookrecommend.demo.service.MemberService;
import com.bookrecommend.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final BookService bookService;
    private final MemberService memberService;

    @PostMapping("/review")
    public ResponseEntity<CommonResponse<ReviewResponse>> save(@RequestBody ReviewRequest request) {
        Book book = bookService.findBook(request.getBookId());
        Member member = memberService.findMember(request.getMemberId());
        Review newReview = request.toEntity(request.getReviewId(), book, member, request.getContents(), request.getFileUrl(), request.getRating());
        reviewService.save(newReview);

        return  ResponseEntity.ok(CommonResponse.success());
    }

    @GetMapping("/reviews/{bookId}")
    public ResponseEntity<CommonResponse<List<ReviewResponse>>> search(@PathVariable("bookId") Long bookId) {
        List<Review> review = reviewService.searchByBook(bookId);
        List<ReviewResponse> response = ReviewResponse.search(review);
        return ResponseEntity.ok(CommonResponse.success(response));
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<CommonResponse<ReviewResponse>> update(@PathVariable("reviewId") String reviewId, @RequestBody ReviewRequest request) {
        reviewService.update(reviewId, request.getContents(), request.getFileUrl(), request.getRating());
        Review review = reviewService.searchByReview(reviewId);
        ReviewResponse response = ReviewResponse.search(review);
        return ResponseEntity.ok(CommonResponse.success(response));
    }

    @PostMapping("/review/{reviewId}/delete")
    public ResponseEntity<CommonResponse<ReviewResponse>> delete(@PathVariable("reviewId") String reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok(CommonResponse.success());
    }
}
