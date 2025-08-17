package com.devworkflow.onboarding.service;

import com.devworkflow.onboarding.model.CodeReview;
import com.devworkflow.onboarding.repository.CodeReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CodeReviewService {
    private final CodeReviewRepository repo;
    public CodeReviewService(CodeReviewRepository repo){ this.repo = repo; }
    public List<CodeReview> all(){ return repo.findAll(); }
    public CodeReview create(CodeReview r){ return repo.save(r); }
    public CodeReview update(Long id, CodeReview r){
        CodeReview e = repo.findById(id).orElseThrow();
        e.setRepo(r.getRepo()); e.setPrNumber(r.getPrNumber()); e.setStatus(r.getStatus()); e.setNotes(r.getNotes());
        return repo.save(e);
    }
    public String diff(Long id){ return "- old line\n+ new line"; }
}
