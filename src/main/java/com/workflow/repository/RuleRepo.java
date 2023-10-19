package com.workflow.repository;

import com.workflow.entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface RuleRepo extends JpaRepository<Rule , Long> {
}
