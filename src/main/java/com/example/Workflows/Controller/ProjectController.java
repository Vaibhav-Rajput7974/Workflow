package com.example.Workflows.Controller;

import com.example.Workflows.Entity.Project;
import com.example.Workflows.Entity.ResponseEntity;
import com.example.Workflows.Repositary.ProjectRepositary;
import com.example.Workflows.Repositary.StageRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/projects")
@RestController
public class ProjectController{
    @Autowired
    ProjectRepositary projectRepositary;

    @Autowired
    StageRepositary stageRepositary;

    @PostMapping("/")
    public ResponseEntity<Project> addproject(@RequestBody Project project){
         projectRepositary.save(project);
         return  new ResponseEntity<Project>("project add Succefully",project, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public  ResponseEntity<List<Project> >getProject(){
        return new ResponseEntity<List<Project> >("all Project in application",projectRepositary.findAll(), HttpStatus.OK);
    }

    @PutMapping("/")
    public  Project updateProject(@RequestBody Project project){
        return projectRepositary.findById((long)1).get();
    }

    @DeleteMapping("/{projectID}")
    public  void deleteProject(@PathVariable Long projectID){
         projectRepositary.deleteById((long)1);
    }
}
