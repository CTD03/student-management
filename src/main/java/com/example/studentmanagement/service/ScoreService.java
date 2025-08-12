package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Score;
import java.util.List;

public interface ScoreService {
    List<Score> getAll();
    Score getById(Long id);
    Score save(Score score);
    void delete(Long id);
}