package com.devworkflow.onboarding.service;

import com.devworkflow.onboarding.model.Requirement;
import com.devworkflow.onboarding.repository.RequirementRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequirementService {
    private final RequirementRepository repo;
    public RequirementService(RequirementRepository repo){ this.repo = repo; }
    public List<Requirement> all(){ return repo.findAll(); }
    public Requirement create(Requirement r){ return repo.save(r); }
    public Requirement update(Long id, Requirement r){
        Requirement e = repo.findById(id).orElseThrow();
        e.setTitle(r.getTitle()); e.setDescription(r.getDescription()); e.setStatus(r.getStatus());
        return repo.save(e);
    }
    public void delete(Long id){ repo.deleteById(id); }
}
