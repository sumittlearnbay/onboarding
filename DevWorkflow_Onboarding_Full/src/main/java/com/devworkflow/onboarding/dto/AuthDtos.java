package com.devworkflow.onboarding.dto;

public class AuthDtos {
    public static class RegisterRequest {
        public String email;
        public String password;
    }
    public static class LoginRequest {
        public String email;
        public String password;
    }
    public static class TokenResponse {
        public String token;
        public TokenResponse(String t){ this.token=t; }
    }
}
