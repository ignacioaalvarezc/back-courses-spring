package com.sys.courses.back.services;

import com.sys.courses.back.dto.UserDto;
import com.sys.courses.back.infra.exceptions.UserNotFoundException;
import com.sys.courses.back.models.Category;
import com.sys.courses.back.models.User;
import com.sys.courses.back.models.UserRole;

import java.util.Set;

public interface UserService {
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception;
    public User saveAdmin(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String username);
    Set<User> getUsers();
    User getUserById(Long userId);
    User getUserByUsername(String username);
    public void deleteUser(Long userId);



    public User updateUser(User user) throws UserNotFoundException;
    void toggleUserStatus(Long userId, boolean newStatus);

}
