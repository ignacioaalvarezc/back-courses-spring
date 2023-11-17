package com.sys.courses.back.controllers;

import com.sys.courses.back.models.Role;
import com.sys.courses.back.models.User;
import com.sys.courses.back.models.UserRole;
import com.sys.courses.back.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception{
        user.setProfile("default.png");
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(2L);
        role.setName("USER");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoles.add(userRole);

        return userService.saveUser(user, userRoles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}