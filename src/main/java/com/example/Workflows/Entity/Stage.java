package com.example.Workflows.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;
@Data
@AllArgsConstructor
@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long stageId;

    private String stageName;

    private String stageDescription;
    @JsonBackReference
    @ManyToOne
    private Project project;

    @JsonManagedReference
    @OneToMany(mappedBy = "stage")
    List<Ticket> ticketInStage;
}
