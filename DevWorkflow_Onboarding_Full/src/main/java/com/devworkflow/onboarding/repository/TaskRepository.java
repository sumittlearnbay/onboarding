package com.devworkflow.onboarding.repository;

import com.devworkflow.onboarding.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> { }
