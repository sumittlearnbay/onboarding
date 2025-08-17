package com.devworkflow.onboarding.service;

import com.devworkflow.onboarding.model.AIConversation;
import com.devworkflow.onboarding.repository.AIConversationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class AIAssistantService {
    private final AIConversationRepository repo;

    @Value("${ollama.host}") private String ollamaHost;
    @Value("${ollama.model}") private String model;

    public AIAssistantService(AIConversationRepository repo){ this.repo = repo; }

    public Flux<String> streamSuggestion(String prompt, String user){
        String reply = "Here are prioritized tasks for "+user+": 1) Fix tests 2) Review PR #42 3) Update docs";
        return Flux.just(reply.split(" ")).delayElements(Duration.ofMillis(120));
    }
}
