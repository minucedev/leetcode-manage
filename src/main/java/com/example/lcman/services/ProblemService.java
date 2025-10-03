package com.example.lcman.services;

import com.example.lcman.model.Problem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProblemService {
    List<Problem> getAllProblems();
    Optional<Problem> getProblemById(Long id);
    Problem createProblem(Problem problem);
    Problem updateProblem(Long id, Problem updatedProblem);
    void deleteProblem(Long id);
}
