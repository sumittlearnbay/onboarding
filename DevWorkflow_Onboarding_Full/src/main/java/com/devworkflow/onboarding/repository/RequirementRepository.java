package com.devworkflow.onboarding.repository;

import com.devworkflow.onboarding.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository<Requirement, Long> { }
