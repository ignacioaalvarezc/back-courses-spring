package com.sys.courses.back.repositories;

import com.sys.courses.back.models.Exam;
import com.sys.courses.back.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByExam(Exam exam);
}
