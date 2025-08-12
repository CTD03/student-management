package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Subject;
import java.util.List;

public interface SubjectService {
    List<Subject> getAll();
    Subject getById(Long id);
    Subject save(Subject subject);
    void delete(Long id);
}