package com.workflow.service;

import com.workflow.entity.Project;
import com.workflow.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Optional<Project> getProjectById(long projectId) {
        return projectRepo.findById(projectId);
    }

    public Project addNewProject(Project addProject) {
        return projectRepo.save(addProject);
    }

    public boolean deleteProjectById(long projectId) {
        if (projectRepo.existsById(projectId)) {
            projectRepo.deleteById(projectId);
            return true;
        }
        return false;
    }
}

