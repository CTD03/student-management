package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student save(Student student);
    void delete(Long id);
}
