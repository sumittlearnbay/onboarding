package com.devworkflow.onboarding.service;

import com.devworkflow.onboarding.dto.AuthDtos.*;
import com.devworkflow.onboarding.model.User;
import com.devworkflow.onboarding.repository.UserRepository;
import com.devworkflow.onboarding.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository users;
    private final JwtUtil jwt;

    public AuthService(UserRepository users, JwtUtil jwt) {
        this.users = users; this.jwt = jwt;
    }

    public void register(RegisterRequest req){
        User u = new User();
        u.setEmail(req.email);
        u.setPasswordHash(BCrypt.hashpw(req.password, BCrypt.gensalt()));
        u.setRole("EMPLOYEE");
        users.save(u);
    }

    public String login(LoginRequest req){
        User u = users.findByEmail(req.email).orElseThrow();
        if(!BCrypt.checkpw(req.password, u.getPasswordHash())) throw new RuntimeException("Invalid credentials");
        return jwt.generateToken(u.getEmail());
    }
}
