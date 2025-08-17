package com.devworkflow.onboarding.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class AIConversation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    @Column(length=4000)
    private String prompt;
    @Column(length=4000)
    private String response;
    private java.time.Instant createdAt = Instant.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }
    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
