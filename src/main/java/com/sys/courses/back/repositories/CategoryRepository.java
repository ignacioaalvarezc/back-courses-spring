package com.sys.courses.back.repositories;

import com.sys.courses.back.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
