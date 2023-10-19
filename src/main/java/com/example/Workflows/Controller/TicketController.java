package com.example.Workflows.Controller;

import com.example.Workflows.Entity.Stage;
import com.example.Workflows.Entity.Ticket;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/projects")
@RestController
public class TicketController {
    @PostMapping("/{projectID}/stages/{stageID}/tickets")
    public Ticket addTicket(@RequestBody Stage stage, @PathVariable Long projectID,@PathVariable Long stageID){
        return new Ticket();
    }

    @GetMapping("/{projectID}/stages/{stageID}/tickets")
    public Ticket getAllTickets(@RequestBody Stage stage, @PathVariable Long projectID,@PathVariable Long stageID){
        return new Ticket();
    }

    @GetMapping("/{projectID}/stages/{stageID}/tickets/{ticketID}")
    public Ticket getTicketById(@RequestBody Stage stage, @PathVariable Long projectID,@PathVariable Long stageID,@PathVariable Long ticketID){
        return new Ticket();
    }

    @PutMapping("/{projectID}/stages/{stageID}/tickets")
    public Ticket updateStageById(@RequestBody Stage stage, @PathVariable Long projectID,@PathVariable Long stageID){
        return new Ticket();
    }

    @DeleteMapping("/{projectID}/stages/{stageID}/tickets/{ticketID}")
    public void deleteTicketById(@PathVariable Long projectID,@PathVariable Long stageID,@PathVariable Long ticketID){
        return;
    }
}
