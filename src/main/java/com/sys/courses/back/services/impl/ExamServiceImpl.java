package com.sys.courses.back.services.impl;

import com.sys.courses.back.models.Category;
import com.sys.courses.back.models.Exam;
import com.sys.courses.back.repositories.ExamRepository;
import com.sys.courses.back.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Set<Exam> getExams() {
        return new LinkedHashSet<>(examRepository.findAll());
    }

    @Override
    public Exam getExam(Long examId) {
        return examRepository.findById(examId).get();
    }

    @Override
    public void deleteExam(Long examId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        examRepository.delete(exam);
    }

    @Override
    public List<Exam>  listExamsOfACategory(Category category) {
        return this.examRepository.findByCategory(category);
    }

    @Override
    public List<Exam> getExamsEnabled() {
        return examRepository.findByEnabled(true);
    }

    @Override
    public List<Exam> getExamsEnabledOfACategory(Category category) {
        return examRepository.findByCategoryAndEnabled(category, true);
    }
}
