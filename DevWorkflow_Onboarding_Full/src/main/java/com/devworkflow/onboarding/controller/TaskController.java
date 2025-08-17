package com.devworkflow.onboarding.controller;

import com.devworkflow.onboarding.model.Task;
import com.devworkflow.onboarding.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService svc;
    public TaskController(TaskService svc){ this.svc = svc; }

    @GetMapping public List<Task> all(){ return svc.all(); }
    @PostMapping public Task create(@RequestBody Task t){ return svc.create(t); }
    @PutMapping("/{id}") public Task update(@PathVariable Long id, @RequestBody Task t){ return svc.update(id, t); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ svc.delete(id); }
}
