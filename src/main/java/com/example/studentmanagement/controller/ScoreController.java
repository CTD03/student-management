package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Score;
import com.example.studentmanagement.service.ScoreService;
import com.example.studentmanagement.service.StudentService;
import com.example.studentmanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("scores", scoreService.getAll());
        return "scores/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("score", new Score());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAll());
        return "scores/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Score score) {
        scoreService.save(score);
        return "redirect:/scores";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("score", scoreService.getById(id));
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("subjects", subjectService.getAll());
        return "scores/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Score score) {
        score.setId(id);
        scoreService.save(score);
        return "redirect:/scores";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        scoreService.delete(id);
        return "redirect:/scores";
    }
}