package com.example.Workflows.Repositary;

import com.example.Workflows.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositary extends JpaRepository<Project,Long> {
}
