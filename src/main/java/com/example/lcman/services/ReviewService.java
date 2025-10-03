package com.example.lcman.services;

import com.example.lcman.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();
    Optional<Review> getReviewById(Long Id);
    Review createReview(Review review);
    Review updateReview(Long id, Review updatedReview);
    Review patchReview(Long id, Review partialReview);
    void deleteReview(Long id);
    List<Review> getReviewByUser(Long userId);
    List<Review> getReviewByProblem(Long problemId);

    List<Review> getDueReviews(Long userId);
}
