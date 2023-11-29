package com.sys.courses.back.services;

import com.sys.courses.back.models.Question;

import java.util.Set;

public interface QuestionService {

    Question addQuestion(Question question);
    Question updateQuestion(Question question);
    Set<Question> getQuestions();
    Question getQuestion(Long questionId);
    Set<Question> getQuestionsOfExam();
    void deleteQuestion(Long questionId);
}
