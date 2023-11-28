package com.sys.courses.back.repositories;

import com.sys.courses.back.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
