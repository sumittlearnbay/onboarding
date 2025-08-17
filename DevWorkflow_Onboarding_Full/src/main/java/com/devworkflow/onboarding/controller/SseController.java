package com.devworkflow.onboarding.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class SseController {
    @GetMapping(value="/sse/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> stream(){
        return Flux.interval(Duration.ofSeconds(1)).map(i -> "heartbeat:"+i);
    }
}
