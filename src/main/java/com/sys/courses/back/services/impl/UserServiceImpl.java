package com.sys.courses.back.services.impl;

import com.sys.courses.back.infra.exceptions.UserFoundException;
import com.sys.courses.back.models.Category;
import com.sys.courses.back.models.User;
import com.sys.courses.back.models.UserRole;
import com.sys.courses.back.repositories.RoleRepository;
import com.sys.courses.back.repositories.UserRepository;
import com.sys.courses.back.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception {
        User userLocal = userRepository.findByUsername(user.getUsername());
        if(userLocal != null) {
            System.out.println("El usuario ya existe");
            throw new UserFoundException("El usuario ya esta presente");
        }
        else {
            for(UserRole userRole:userRoles) {
                roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            userLocal = userRepository.save(user);
        }
        return userLocal;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public Set<User> getUsers() {
        return new LinkedHashSet<>(userRepository.findAll());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
