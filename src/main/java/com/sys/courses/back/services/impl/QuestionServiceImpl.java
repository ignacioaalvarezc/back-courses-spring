package com.sys.courses.back.services.impl;

import com.sys.courses.back.models.Exam;
import com.sys.courses.back.models.Question;
import com.sys.courses.back.repositories.QuestionRepository;
import com.sys.courses.back.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return (Set<Question>) questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfExam(Exam exam) {
        return questionRepository.findByExam(exam);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question = new Question();
        question.setQuestionId(questionId);
        questionRepository.delete(question);
    }
}
