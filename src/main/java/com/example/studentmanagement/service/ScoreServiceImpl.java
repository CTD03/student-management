package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Score;
import com.example.studentmanagement.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    public Score getById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public void delete(Long id) {
        scoreRepository.deleteById(id);
    }
}
