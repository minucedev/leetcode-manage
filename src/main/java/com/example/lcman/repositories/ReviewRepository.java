package com.example.lcman.repositories;

import com.example.lcman.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository <Review ,Long>{
    List<Review> findByUserIdAndNextReviewDateLessThanEqual(Long userId, LocalDate date);
    List<Review> findByUserId (Long userId);
    List<Review> findByProblemId (Long problemId);

}

