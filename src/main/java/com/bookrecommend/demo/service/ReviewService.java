package com.bookrecommend.demo.service;

import com.bookrecommend.demo.domain.Review;
import com.bookrecommend.demo.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Transactional
    public Review search(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

}
