package com.workflow.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;
    private String ticketName;
    private String ticketDescription;
    @OneToOne
    private User ticketAssign;
    private Date ticketStartingDate;
    private Date ticketEndingDate;
    @ManyToOne
    @JsonBackReference
    private Stage stage;

}
