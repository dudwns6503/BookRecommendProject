package com.bookrecommend.demo.repository;

import com.bookrecommend.demo.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
