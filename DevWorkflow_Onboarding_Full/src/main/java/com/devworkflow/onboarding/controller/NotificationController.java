package com.devworkflow.onboarding.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController @RequestMapping("/api/notifications")
public class NotificationController {
    private final java.util.List<java.util.Map<String,Object>> notif = new java.util.concurrent.CopyOnWriteArrayList<>();
    @GetMapping public List<Map<String,Object>> all(){ return notif; }
    @PostMapping("/send") public Map<String,Object> send(@RequestBody Map<String,Object> m){ notif.add(m); return m; }
    @PostMapping("/read") public String read(){ return "ok"; }
}
