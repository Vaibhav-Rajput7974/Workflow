package com.example.Workflows.Service;

import com.example.Workflows.Entity.Project;
import com.example.Workflows.Entity.Stage;
import com.example.Workflows.Entity.Ticket;
import com.example.Workflows.Repositary.ProjectRepositary;
import com.example.Workflows.Repositary.StageRepositary;
import com.example.Workflows.Repositary.TicketRepositary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TicketService {
    @Autowired
    StageRepositary stageRepositary;
    @Autowired
    TicketRepositary ticketRepositary;

    @Autowired
    ProjectRepositary projectRepositary;

    public List<Ticket> getAllTicketsInStage(Long projectID,Long stageID){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stage.getStageId()))
                    .findFirst();

            if (stageOptional.isPresent()) {
                return stageRepositary.findById(stageID).get().getTicketInStage();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public Ticket getTicketByID(Long projectID,Long stageID,Long ticketID){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stage.getStageId()))
                    .findFirst();

            if (stageOptional.isPresent()) {
                return ticketRepositary.findById(stageID).get();
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public Ticket createTicket(Long projectID,Long stageID,Ticket ticket){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stage.getStageId()))
                    .findFirst();

            if (stageOptional.isPresent()) {
                return ticketRepositary.save(ticket);
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public Ticket updateTicket(Long projectID,Long stageID,Ticket ticket){
        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stage.getStageId()))
                    .findFirst();

            if (stageOptional.isPresent()) {
                Stage stage = stageOptional.get();
                Optional<Ticket> ticketOptional = stage.getTicketInStage().stream()
                        .filter(ticketfilter -> ticketfilter.getId().equals(ticket.getId()))
                        .findFirst();
                if(ticketOptional.isPresent()) {
                    Ticket oldTicket = ticketOptional.get();
                    oldTicket.setTaskname(ticket.getTaskname());
                    oldTicket.setTicketDescription(ticket.getTicketDescription());
                    return ticketRepositary.save(oldTicket);
                }
                else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public boolean deleteTicket(Long projectID,Long stageID,Long ticketID){

        Optional<Project> projectOptional = projectRepositary.findById(projectID);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Optional<Stage> stageOptional = project.getStagesInProject().stream()
                    .filter(stage -> stage.getStageId().equals(stage.getStageId()))
                    .findFirst();

            if (stageOptional.isPresent()) {
                Stage stage = stageOptional.get();
                Optional<Ticket> ticketOptional = stage.getTicketInStage().stream()
                        .filter(ticketfilter -> ticketfilter.getId().equals(ticketID))
                        .findFirst();
                if(ticketOptional.isPresent()) {
                    ticketRepositary.deleteById(ticketID);
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
        else {
            return false;
        }
    }
}
