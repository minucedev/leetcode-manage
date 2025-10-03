package com.example.lcman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user_problem_reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long userId;
    private Long problemId;

    private String status;
    private Integer interval;
    private Double easeFactor;
    private Integer repetition; // Sử dụng integer vì giá trị trong bảng có thể null

    private LocalDate nextReviewDate;
    private LocalDateTime lastReviewedAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
