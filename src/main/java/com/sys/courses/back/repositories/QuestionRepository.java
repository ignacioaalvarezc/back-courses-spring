package com.sys.courses.back.repositories;

import com.sys.courses.back.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
