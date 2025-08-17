package com.devworkflow.onboarding.service;

import com.devworkflow.onboarding.model.Task;
import com.devworkflow.onboarding.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo){ this.repo = repo; }
    public List<Task> all(){ return repo.findAll(); }
    public Task create(Task t){ return repo.save(t); }
    public Task update(Long id, Task t){
        Task e = repo.findById(id).orElseThrow();
        e.setTitle(t.getTitle()); e.setStatus(t.getStatus()); e.setAssignee(t.getAssignee()); e.setDueDate(t.getDueDate());
        return repo.save(e);
    }
    public void delete(Long id){ repo.deleteById(id); }
}
