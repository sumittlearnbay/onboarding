package com.devworkflow.onboarding.controller;

import com.devworkflow.onboarding.service.AIAssistantService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController @RequestMapping("/api/ai")
public class AIAssistantController {
    private final AIAssistantService svc;
    public AIAssistantController(AIAssistantService svc){ this.svc = svc; }

    @PostMapping(value = "/suggestions", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> suggest(@RequestBody String prompt, @RequestHeader(value="X-User", required=false) String user){
        String u = (user==null?"user":user);
        return svc.streamSuggestion(prompt, u);
    }

    @GetMapping("/conversations")
    public String conversations(){ return "[]"; }
}
