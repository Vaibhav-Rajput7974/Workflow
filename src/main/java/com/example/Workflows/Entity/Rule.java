package com.example.Workflows.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String  preStageTrigger;

    private String newStageTrigger;

    private String preStageAction;

    private String nextStageAction;

    @ManyToOne
    private Project project;
}
