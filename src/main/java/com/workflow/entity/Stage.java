package com.workflow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stageId;
    private String stageName;
    private String stageDescription;
    @JsonBackReference
    @ManyToOne
    private Project project;
    @JsonManagedReference
    @OneToMany(mappedBy = "stage")
    private List<Ticket> ticketList;
}
