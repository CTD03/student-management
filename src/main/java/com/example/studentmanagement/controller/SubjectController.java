package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Subject;
import com.example.studentmanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("subjects", subjectService.getAll());
        return "subjects/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("subject", new Subject());
        return "subjects/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Subject subject) {
        subjectService.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("subject", subjectService.getById(id));
        return "subjects/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Subject subject) {
        subject.setId(id);
        subjectService.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        subjectService.delete(id);
        return "redirect:/subjects";
    }
}