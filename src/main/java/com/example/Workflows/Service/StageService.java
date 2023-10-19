package com.example.Workflows.Service;

import com.example.Workflows.Entity.Project;
import com.example.Workflows.Entity.Stage;
import com.example.Workflows.Entity.Ticket;
import com.example.Workflows.Repositary.ProjectRepositary;
import com.example.Workflows.Repositary.StageRepositary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StageService {
    @Autowired
    ProjectRepositary projectRepositary;

    @Autowired
    StageRepositary stageRepositary;

    public Stage getStageByID(Long projectID,Long stageID){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stageID))
                    .findFirst();

            if (stageOptional.isPresent()) {
                return stageRepositary.findById(projectID).get();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public List<Stage> getAllStages(Long projectID){
        try {
            return projectRepositary.findById(projectID).get().getStagesInProject();
        }
        catch (Exception e){
            return null;
        }
    }

    public Stage createStage(Stage stage,Long projectID){
        Project project=projectRepositary.findById(projectID).get();
        if(project!=null){
            stage.setProject(project);
            return stageRepositary.save(stage);
        }
        return null;
    }

    public Stage updateStage(Stage newStage,Long projectID){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stage.getStageId()))
                    .findFirst();

            if (stageOptional.isPresent()) {
                Stage oldStage = stageOptional.get();
                oldStage.setStageName(newStage.getStageName());
                oldStage.setStageDescription(newStage.getStageDescription());
                return stageRepositary.save(oldStage);
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public boolean deleteStage(Long stageID,Long projectID){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stage.getStageId()))
                    .findFirst();

            if (stageOptional.isPresent()) {
                stageRepositary.deleteById(stageID);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}

