package com.example.lcman.controller;

import com.example.lcman.model.Review;
import com.example.lcman.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public List<Review> getReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public Review createdReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        Review review = reviewService.updateReview(id, updatedReview);
        return (review != null) ? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Review> patchReview(@PathVariable Long id, @RequestBody Review partialReview) {
        Review review = reviewService.patchReview(id, partialReview);
        return (review != null) ? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/due")
    public List<Review> getDueReviews(@RequestParam Long userId) {
        return reviewService.getDueReviews(userId);
    }

    @GetMapping("/user/{userId}")
    public List<Review> getReviewByUser(@PathVariable Long userId) {
        return reviewService.getReviewByUser(userId);
    }

    @GetMapping("/problem/{problemId}")
    public List<Review> getReviewByProblem(@PathVariable Long problemId) {
        return reviewService.getReviewByProblem(problemId);
    }




}
