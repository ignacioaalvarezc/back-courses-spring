package com.sys.courses.back.controllers;

import com.sys.courses.back.models.Exam;
import com.sys.courses.back.models.Question;
import com.sys.courses.back.services.ExamService;
import com.sys.courses.back.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamService examService;

    @PostMapping("/")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.saveQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<?> listExamQuestions(@PathVariable("examId") Long examId) {
        Exam exam = examService.getExam(examId);
        Set<Question> questions = exam.getQuestions();

        List exams = new ArrayList(questions);
        if (exams.size() > Integer.parseInt(exam.getQuestionsAmount())) {
            exams = exams.subList(0, Integer.parseInt(exam.getQuestionsAmount() + 1));
        }

        Collections.shuffle(exams);
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/{questionId}")
    public Question listQuestionById(@PathVariable("questionId") Long questionId) {
        return questionService.getQuestion(questionId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId) {
        questionService.deleteQuestion(questionId);
    }

    @GetMapping("/exam/all/{examId}")
    public ResponseEntity<?> listExamQuestionsAsAnAdmin(@PathVariable("examId") Long examId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        Set<Question> questions = questionService.getExamQuestions(exam);
        return ResponseEntity.ok(questions);
    }
}
