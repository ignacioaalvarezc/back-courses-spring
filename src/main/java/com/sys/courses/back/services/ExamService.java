package com.sys.courses.back.services;

import com.sys.courses.back.models.Category;
import com.sys.courses.back.models.Exam;

import java.util.List;
import java.util.Set;

public interface ExamService {

    Exam addExam(Exam exam);
    Exam updateExam(Exam exam);
    Set<Exam> getExams();
    Exam getExam(Long examId);
    void deleteExam(Long examId);
    List<Exam> listExamsOfACategory(Category category);
    List<Exam> getEnabledExams();
    List<Exam> getEnabledExamsOfACategory(Category category);

}
