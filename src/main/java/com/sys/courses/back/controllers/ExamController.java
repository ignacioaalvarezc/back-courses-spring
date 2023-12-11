package com.sys.courses.back.controllers;

import com.sys.courses.back.models.Category;
import com.sys.courses.back.models.Exam;
import com.sys.courses.back.services.CategoryService;
import com.sys.courses.back.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@CrossOrigin("*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/")
    public ResponseEntity<Exam> saveExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.addExam(exam));
    }

    @PutMapping("/")
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.addExam(exam));
    }

    @GetMapping("/")
    public ResponseEntity<?> listExams() {
        return ResponseEntity.ok(examService.getExams());
    }

    @GetMapping("/{examId}")
    public Exam listExam(@PathVariable("examId") Long examId) {
        return examService.getExam(examId);
    }

    @DeleteMapping("/{examId}")
    public void deleteExam(@PathVariable("examId") Long examId) {
        examService.deleteExam(examId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Exam> listExamsOfACategory(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.listExamsOfACategory(category);
    }

    @GetMapping("/enabled")
    public List<Exam> listExamsEnabled() {
        return examService.getExamsEnabled();
    }

    @GetMapping("/category/enabled/{categoryId}")
    public List<Exam> listExamsEnabledOfACategory(@PathVariable("categoryId") Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.getExamsEnabledOfACategory(category);
    }

}
