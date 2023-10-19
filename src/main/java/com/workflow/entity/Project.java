package com.workflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Project {

    @Id
    long projectId;
    String projectName;
    String projectDescrition;

    public Project(){}
    public Project(long projectId, String projectName, String projectDescrition) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescrition = projectDescrition;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescrition() {
        return projectDescrition;
    }

    public void setProjectDescrition(String projectDescrition) {
        this.projectDescrition = projectDescrition;
    }
}
