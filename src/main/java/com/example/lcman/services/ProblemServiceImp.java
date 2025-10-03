package com.example.lcman.services;

import com.example.lcman.model.Problem;
import com.example.lcman.repositories.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemServiceImp implements ProblemService {
    private final ProblemRepository problemRepository;

    public ProblemServiceImp(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    // Sử dụng optional vì có thể xảy ra null (không có dữ liệu) --> an toàn khi có exception
    public Optional<Problem> getProblemById(Long id) {
        return problemRepository.findById(id);
    }

    public Problem createProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    public Problem updateProblem(Long id, Problem updatedProblem) {
        return problemRepository.findById(id)
                .map(problem -> {
                    problem.setTitle(updatedProblem.getTitle());
                    problem.setDifficulty(updatedProblem.getDifficulty());
                    return problemRepository.save(problem);
                })
                .orElseThrow(() -> new RuntimeException("Problem not found with id " + id));
    }

    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }


}
