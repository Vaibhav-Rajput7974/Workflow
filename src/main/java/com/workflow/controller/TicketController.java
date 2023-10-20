package com.workflow.controller;

import com.workflow.entity.Ticket;
import com.workflow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable long id) {
        Optional<Ticket> optionalTicket = ticketService.getTicketById(id);

        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ticket> addNewTicket(@RequestBody Ticket addTicket) {
        Ticket savedTicket = ticketService.addTicket(addTicket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable long id, @RequestBody Ticket updateTicket) {
        Optional<Ticket> optionalTicket = ticketService.updateTicket(id, updateTicket);

        if (optionalTicket.isPresent()) {
            return ResponseEntity.ok(optionalTicket.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketById(@PathVariable long id) {
        if (ticketService.deleteTicketById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
