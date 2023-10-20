package com.workflow.controller;

import com.workflow.entity.Project;
import com.workflow.service.ProjectService;
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
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable long projectId) {
        Optional<Project> optionalProject = projectService.getProjectById(projectId);

        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Project> addNewProject(@RequestBody Project addProject) {
        Project savedProject = projectService.addNewProject(addProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable long projectId) {
        if (projectService.deleteProjectById(projectId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

