package com.workflow.controller;

import com.workflow.entity.Ticket;
import com.workflow.repository.TicketRepo;
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
    private TicketRepo ticketRepo;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketRepo.findAll();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable long id) {
        Optional<Ticket> optionalTicket = ticketRepo.findById(id);

        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ticket> addNewTicket(@RequestBody Ticket addTicket) {
        Ticket savedTicket = ticketRepo.save(addTicket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable long id, @RequestBody Ticket updateTicket) {
        Optional<Ticket> optionalTicket = ticketRepo.findById(id);

        if (optionalTicket.isPresent()) {
            Ticket existingTicket = optionalTicket.get();

            existingTicket.setTicketName(updateTicket.getTicketName());
            existingTicket.setTicketStartingDate(updateTicket.getTicketStartingDate());
            existingTicket.setTicketEndingDate(updateTicket.getTicketEndingDate());
            existingTicket.setTicketAssign(updateTicket.getTicketAssign());
            existingTicket.setTicketDescription(updateTicket.getTicketDescription());

            ticketRepo.save(existingTicket);
            return ResponseEntity.ok(existingTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketById(@PathVariable long id) {
        if (ticketRepo.existsById(id)) {
            ticketRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}