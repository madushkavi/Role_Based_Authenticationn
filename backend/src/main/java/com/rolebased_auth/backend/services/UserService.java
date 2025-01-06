package com.rolebased_auth.backend.services;

import com.rolebased_auth.backend.entity.User;
import com.rolebased_auth.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}

