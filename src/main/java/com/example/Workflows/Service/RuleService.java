package com.example.Workflows.Service;

import com.example.Workflows.Entity.Project;
import com.example.Workflows.Entity.Rule;
import com.example.Workflows.Entity.Stage;
import com.example.Workflows.Repositary.ProjectRepositary;
import com.example.Workflows.Repositary.RuleReposistary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RuleService {
    @Autowired
    ProjectRepositary projectRepositary;
    @Autowired
    RuleReposistary ruleReposistary;
    public List<Rule> getAllRule(Long projectID){
        try {
            return projectRepositary.findById(projectID).get().getTriggersList();
        }
        catch (Exception e){
            return null;
        }
    }

    public Rule getRuleById(Long projectID,Long ruleID){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Rule> stageOptional = project.getTriggersList().stream()
                    .filter(rule -> rule.getId().equals(ruleID))
                    .findFirst();

            if (stageOptional.isPresent()) {
                return ruleReposistary.findById(ruleID).get();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public boolean deleteRule(Long projectID,Long ruleID){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Rule> stageOptional = project.getTriggersList().stream()
                    .filter(rule -> rule.getId().equals(ruleID))
                    .findFirst();

            if (stageOptional.isPresent()) {
                 ruleReposistary.deleteById(ruleID);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
