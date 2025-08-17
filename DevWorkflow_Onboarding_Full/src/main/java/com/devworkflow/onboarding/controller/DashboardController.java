package com.devworkflow.onboarding.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController @RequestMapping("/api/dashboard")
public class DashboardController {
    @GetMapping("/overview")
    public Map<String,Object> overview(){
        return Map.of("openTasks", 5, "codeReviews", 2, "jiraIssues", 3, "pullRequests", 1);
    }
}
