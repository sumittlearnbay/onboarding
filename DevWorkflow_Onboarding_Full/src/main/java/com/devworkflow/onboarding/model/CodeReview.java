package com.devworkflow.onboarding.model;

import jakarta.persistence.*;

@Entity
public class CodeReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String repo;
    private String prNumber;
    private String status;
    @Column(length=4000)
    private String notes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRepo() { return repo; }
    public void setRepo(String repo) { this.repo = repo; }
    public String getPrNumber() { return prNumber; }
    public void setPrNumber(String prNumber) { this.prNumber = prNumber; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
