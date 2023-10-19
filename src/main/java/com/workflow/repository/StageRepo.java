package com.workflow.repository;

import com.workflow.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepo extends JpaRepository<Stage , Long> {
}
