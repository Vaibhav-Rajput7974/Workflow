package com.example.Workflows.Repositary;

import com.example.Workflows.Entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepositary extends JpaRepository<Stage,Long> {
}
