package com.sys.courses.back.controllers;

// IMPORTS
import com.sys.courses.back.infra.exceptions.UserNotFoundException;
import com.sys.courses.back.models.User;
import com.sys.courses.back.infra.security.JwtToken.JwtRequest;
import com.sys.courses.back.infra.security.JwtToken.JwtResponse;
import com.sys.courses.back.infra.security.JwtToken.JwtUtils;
import com.sys.courses.back.services.impl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
            String token = this.jwtUtils.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (UserNotFoundException e) {
            log.error("Error al generar el token: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error en la autentificacion");
        }
    }

    private void authenticate(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException exception) {
            throw new Exception("Usuario deshabilitado " + exception.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales inválidas " + e.getMessage());
        }
    }

    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(Principal principal) {
        try {
            if (principal == null) {
                throw new UserNotFoundException("No se ha autenticado ningún usuario");
            }
            String username = principal.getName();
            User currentUser = (User) this.userDetailsService.loadUserByUsername(username);
            return ResponseEntity.ok(currentUser);
        } catch (UserNotFoundException e) {
            log.error("Error al obtener el usuario actual: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no autenticado");
        }
    }
}
