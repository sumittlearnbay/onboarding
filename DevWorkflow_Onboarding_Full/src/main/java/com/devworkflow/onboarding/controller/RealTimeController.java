package com.devworkflow.onboarding.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController @RequestMapping("/realtime")
public class RealTimeController {
    private final SimpMessagingTemplate template;
    public RealTimeController(SimpMessagingTemplate template){ this.template = template; }

    @PostMapping("/push")
    public Map<String,Object> push(@RequestBody Map<String,Object> payload){
        template.convertAndSend("/topic/updates", payload);
        return payload;
    }
}
