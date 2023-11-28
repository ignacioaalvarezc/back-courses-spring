package com.sys.courses.back.repositories;

import com.sys.courses.back.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
