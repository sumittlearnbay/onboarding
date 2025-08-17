package com.devworkflow.onboarding.controller;

import com.devworkflow.onboarding.dto.AuthDtos.*;
import com.devworkflow.onboarding.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/auth")
public class AuthController {
    private final AuthService auth;
    public AuthController(AuthService auth){ this.auth = auth; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req){
        auth.register(req); return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest req){
        return ResponseEntity.ok(new TokenResponse(auth.login(req)));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){ return ResponseEntity.ok().build(); }
}
