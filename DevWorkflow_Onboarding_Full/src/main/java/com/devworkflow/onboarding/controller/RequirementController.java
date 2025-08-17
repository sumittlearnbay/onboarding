package com.devworkflow.onboarding.controller;

import com.devworkflow.onboarding.model.Requirement;
import com.devworkflow.onboarding.service.RequirementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/requirements")
public class RequirementController {
    private final RequirementService svc;
    public RequirementController(RequirementService svc){ this.svc = svc; }

    @GetMapping public List<Requirement> all(){ return svc.all(); }
    @PostMapping public Requirement create(@RequestBody Requirement r){ return svc.create(r); }
    @PutMapping("/{id}") public Requirement update(@PathVariable Long id, @RequestBody Requirement r){ return svc.update(id, r); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ svc.delete(id); }
}
