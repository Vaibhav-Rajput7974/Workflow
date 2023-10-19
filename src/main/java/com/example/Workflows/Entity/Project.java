package com.example.Workflows.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long projectId;

    private String projectName;

    private String projectDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "project" , cascade = CascadeType.ALL)
    List<Stage> stagesInProject;

    @JsonManagedReference
    @OneToMany(mappedBy = "project" , cascade = CascadeType.ALL)
    List<Rule> triggersList;

    public void setStagesInProject(List<Stage> stagesInProject) {
        this.stagesInProject = stagesInProject;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", stagesInProject=" + stagesInProject +
                '}';
    }
}
