package com.sys.courses.back;

import com.sys.courses.back.models.Role;
import com.sys.courses.back.models.User;
import com.sys.courses.back.models.UserRole;
import com.sys.courses.back.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackCoursesApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BackCoursesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();

		user.setName("Ignacio");
		user.setLastName("Alvarez");
		user.setUsername("ignacio");
		user.setPassword("12345");
		user.setEmail("ignacio@gmail.com");
		user.setPhoneNumber("985772895");
		user.setProfile("picture.png");

		Role role = new Role();
		role.setRoleId(1L);
		role.setName("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		User savedUser = userService.saveUser(user, userRoles);
		System.out.println(savedUser.getUsername());
	}
}
