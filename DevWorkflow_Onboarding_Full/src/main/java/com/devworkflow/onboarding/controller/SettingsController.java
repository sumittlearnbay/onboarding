package com.devworkflow.onboarding.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController @RequestMapping("/api/settings")
public class SettingsController {
    private java.util.Map<String, String> cfg = new java.util.concurrent.ConcurrentHashMap<>();
    @GetMapping public Map<String,String> get(){ return cfg; }
    @PutMapping public Map<String,String> put(@RequestBody Map<String,String> in){ cfg.putAll(in); return cfg; }
}
