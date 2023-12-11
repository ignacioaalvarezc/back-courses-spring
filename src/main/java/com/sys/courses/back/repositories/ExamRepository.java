package com.sys.courses.back.repositories;

import com.sys.courses.back.models.Category;
import com.sys.courses.back.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByCategory(Category category);
}
