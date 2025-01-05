package com.rolebased_auth.backend.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/")
    public ResponseEntity<String>home(){
        return ResponseEntity.ok("Hi, Welcome Booking Application");
    }
}
