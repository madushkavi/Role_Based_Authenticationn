package com.rolebased_auth.backend.controllers;
import com.rolebased_auth.backend.entity.User;
import com.rolebased_auth.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if (userService.findByUsername(user.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        String role = user.getRole().toUpperCase();
        if (!Arrays.asList("PARTNER", "CLIENT", "ADMIN").contains(role)) {
            return ResponseEntity.badRequest().body("Invalid role");
        }
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser (@RequestBody User loginRequest){
        return userService.findByUsername(loginRequest.getUserName())
                .map(user->
                {
                    if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

                        return ResponseEntity.ok(user.getRole());
                    } else {
                        return ResponseEntity.status(401).body("Invalid credentials");
                    }
                })
                .orElse(ResponseEntity.status(401).body("Invalid"));
    }

}
