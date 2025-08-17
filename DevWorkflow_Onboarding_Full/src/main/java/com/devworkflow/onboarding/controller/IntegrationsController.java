package com.devworkflow.onboarding.controller;

import com.devworkflow.onboarding.service.IntegrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/integrations")
public class IntegrationsController {
    private final IntegrationService svc;
    public IntegrationsController(IntegrationService svc){ this.svc = svc; }

    @GetMapping public String list(){ return "[\"jira\",\"github\",\"slack\",\"google-calendar\"]"; }

    @PostMapping("/{service}/sync")
    public ResponseEntity<?> sync(@PathVariable String service){ return ResponseEntity.ok().build(); }

    @PostMapping("/webhook/github")
    public ResponseEntity<?> github(@RequestBody String payload, @RequestHeader("X-Hub-Signature-256") String sig){
        boolean ok = svc.validateGithubSignature(payload, sig);
        return ok? ResponseEntity.ok().build(): ResponseEntity.status(401).build();
    }
}
