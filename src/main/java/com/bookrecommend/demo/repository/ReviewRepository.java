package com.bookrecommend.demo.repository;

import com.bookrecommend.demo.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, String> {
    List<Review> findByBookId(Long bookId);
}
