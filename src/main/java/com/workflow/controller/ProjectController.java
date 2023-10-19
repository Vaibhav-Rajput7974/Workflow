package com.workflow.controller;

import com.workflow.entity.Project;
import com.workflow.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepo projectRepo;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectRepo.findAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable long projectId) {
        Optional<Project> optionalProject = projectRepo.findById(projectId);

        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project addProject) {
        Project savedProject = projectRepo.save(addProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable long projectId) {
        if (projectRepo.existsById(projectId)) {
            projectRepo.deleteById(projectId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
