package com.example.lcman.services;

import com.example.lcman.model.Review;
import com.example.lcman.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class ReviewServiceImp implements ReviewService {
    //Dùng final thì khai báo constructor
    private final ReviewRepository reviewRepository;

    public ReviewServiceImp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(Long Id) {
        return reviewRepository.findById(Id);
    }

    @Override
    public Review createReview(Review review) {
        review.setInterval(1);
        review.setEaseFactor(2.5);
        review.setRepetition(0);
        review.setNextReviewDate(LocalDate.now());
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setUserId(updatedReview.getUserId());
                    review.setProblemId(updatedReview.getProblemId());
                    review.setStatus(updatedReview.getStatus());
                    review.setInterval(updatedReview.getInterval());
                    review.setEaseFactor(updatedReview.getEaseFactor());
                    review.setRepetition(updatedReview.getRepetition());
                    review.setNextReviewDate(updatedReview.getNextReviewDate());
                    review.setLastReviewedAt(updatedReview.getLastReviewedAt());
                    review.setUpdatedAt(LocalDateTime.now());
                    return reviewRepository.save(review);
                })
                .orElse(null);
    }

    @Override
    public Review patchReview(Long id, Review partialReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    if (partialReview.getStatus() != null) review.setStatus(partialReview.getStatus());
                    if (partialReview.getInterval() != null) review.setInterval(partialReview.getInterval());
                    if (partialReview.getEaseFactor() != null) review.setEaseFactor(partialReview.getEaseFactor());
                    if (partialReview.getRepetition() != null) review.setRepetition(partialReview.getRepetition());
                    if (partialReview.getNextReviewDate() != null) review.setNextReviewDate(partialReview.getNextReviewDate());
                    if (partialReview.getLastReviewedAt() != null) review.setLastReviewedAt(partialReview.getLastReviewedAt());
                    review.setUpdatedAt(LocalDateTime.now());
                    return reviewRepository.save(review);
                })
                .orElse(null);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> getReviewByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<Review> getReviewByProblem(Long problemId) {
        return reviewRepository.findByProblemId(problemId);
    }

    @Override
    public List<Review> getDueReviews(Long userId) {
        return reviewRepository.findByUserIdAndNextReviewDateLessThanEqual(userId, LocalDate.now());
    }

}
