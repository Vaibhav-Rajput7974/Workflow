package com.example.Workflows.Service;

import com.example.Workflows.Entity.Project;
import com.example.Workflows.Repositary.ProjectRepositary;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService {
    @Autowired
    ProjectRepositary projectRepositary;

    public void createProject(Project project){
        projectRepositary.save(project);

    }

    public  boolean  delete(Long projectID){
        try{
            projectRepositary.deleteById(projectID);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
