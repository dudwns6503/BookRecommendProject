package com.bookrecommend.demo.service;

import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Transactional
    public List<Review> searchByBook(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Transactional
    public Review searchByReview(String reviewId) {
        return reviewRepository.findById((reviewId)).orElseThrow();
    }

    @Transactional
    public void update(String reviewId, String contents, String fileUrl, int rating) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new IllegalArgumentException("해당하는 아이디가 없습니다 id : " + reviewId));
        review.update(contents, fileUrl, rating);
    }

    @Transactional
    public void deleteReview(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
