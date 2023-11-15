package com.sys.courses.back.services;

import com.sys.courses.back.models.User;
import com.sys.courses.back.models.UserRole;

import java.util.Set;

public interface UserService {
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
}
