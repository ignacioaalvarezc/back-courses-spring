package com.sys.courses.back.repositories;

import com.sys.courses.back.models.Role;
import com.sys.courses.back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
