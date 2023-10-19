package com.workflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rule {

    @Id
    private long ruleId;
    String previousStageTrigger;
    String currentStageTrigger;
    String previousStageAction;
    String currentStageAcion;

    public Rule() {}

    public Rule(long ruleId, String previousStageTrigger, String currentStageTrigger, String previousStageAction, String currentStageAcion) {
        this.ruleId = ruleId;
        this.previousStageTrigger = previousStageTrigger;
        this.currentStageTrigger = currentStageTrigger;
        this.previousStageAction = previousStageAction;
        this.currentStageAcion = currentStageAcion;
    }

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public String getPreviousStageTrigger() {
        return previousStageTrigger;
    }

    public void setPreviousStageTrigger(String previousStageTrigger) {
        this.previousStageTrigger = previousStageTrigger;
    }

    public String getCurrentStageTrigger() {
        return currentStageTrigger;
    }

    public void setCurrentStageTrigger(String currentStageTrigger) {
        this.currentStageTrigger = currentStageTrigger;
    }

    public String getPreviousStageAction() {
        return previousStageAction;
    }

    public void setPreviousStageAction(String previousStageAction) {
        this.previousStageAction = previousStageAction;
    }

    public String getCurrentStageAcion() {
        return currentStageAcion;
    }

    public void setCurrentStageAcion(String currentStageAcion) {
        this.currentStageAcion = currentStageAcion;
    }
}
