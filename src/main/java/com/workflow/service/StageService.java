package com.workflow.service;

import com.workflow.entity.Project;
import com.workflow.entity.Stage;
import com.workflow.repository.ProjectRepo;
import com.workflow.repository.StageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {
    @Autowired
    private StageRepo stageRepo;

    @Autowired
    private ProjectRepo projectRepo;

    public List<Stage> getAllStages() {
        return stageRepo.findAll();
    }

    public Optional<Stage> getStageById(long stageId) {
        return stageRepo.findById(stageId);
    }

    public Stage addNewStage(long projectId , Stage stage) {
        Project project = projectRepo.findById(projectId).get();
        return stageRepo.save(stage);
    }

    public Optional<Stage> updateStage(long stageId, Stage updateStage) {
        Optional<Stage> optionalStage = stageRepo.findById(stageId);

        if (optionalStage.isPresent()) {
            Stage existingStage = optionalStage.get();
            existingStage.setStageName(updateStage.getStageName());
            existingStage.setStageDescription(updateStage.getStageDescription());
            stageRepo.save(existingStage);
            return Optional.of(existingStage);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteStageById(long stageId) {
        if (stageRepo.existsById(stageId)) {
            stageRepo.deleteById(stageId);
            return true;
        }
        return false;
    }
}
