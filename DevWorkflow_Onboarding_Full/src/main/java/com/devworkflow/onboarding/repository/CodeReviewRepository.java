package com.devworkflow.onboarding.repository;

import com.devworkflow.onboarding.model.CodeReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeReviewRepository extends JpaRepository<CodeReview, Long> { }
