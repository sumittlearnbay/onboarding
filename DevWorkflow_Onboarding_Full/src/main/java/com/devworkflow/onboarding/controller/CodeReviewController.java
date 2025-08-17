package com.devworkflow.onboarding.controller;

import com.devworkflow.onboarding.model.CodeReview;
import com.devworkflow.onboarding.service.CodeReviewService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/code-reviews")
public class CodeReviewController {
    private final CodeReviewService svc;
    public CodeReviewController(CodeReviewService svc){ this.svc = svc; }

    @GetMapping public List<CodeReview> all(){ return svc.all(); }
    @PostMapping public CodeReview create(@RequestBody CodeReview r){ return svc.create(r); }
    @PutMapping("/{id}") public CodeReview update(@PathVariable Long id, @RequestBody CodeReview r){ return svc.update(id, r); }
    @GetMapping("/{id}/diff") public String diff(@PathVariable Long id){ return svc.diff(id); }
}
