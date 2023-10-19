package com.workflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stage {

    @Id
    long stageId;
    String stageName;
    String stageDescription;

    public Stage() {
    }

    public Stage(long stageId, String stageName, String stageDescription) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.stageDescription = stageDescription;
    }

    public long getStageId() {
        return stageId;
    }

    public void setStageId(long stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }
}
