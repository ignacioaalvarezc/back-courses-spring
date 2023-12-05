package com.sys.courses.back.controllers;

import com.sys.courses.back.dto.UserDto;
import com.sys.courses.back.infra.exceptions.UserNotFoundException;
import com.sys.courses.back.models.Category;
import com.sys.courses.back.models.Role;
import com.sys.courses.back.models.User;
import com.sys.courses.back.models.UserRole;
import com.sys.courses.back.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
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

    @PostMapping("/save-admin")
    public User saveAdmin(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(1L);
        role.setName("ADMIN");
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


    @GetMapping("/{userId}")
    public User listUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/")
    public ResponseEntity<?> listUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @GetMapping("/current-user")
    public User getCurrentUser() {
        return new User();
    }
}