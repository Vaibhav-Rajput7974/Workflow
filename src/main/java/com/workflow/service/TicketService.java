package com.workflow.service;

import com.workflow.entity.Ticket;
import com.workflow.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public Optional<Ticket> getTicketById(long id) {
        return ticketRepo.findById(id);
    }

    public Ticket addTicket(Ticket addTicket) {
        return ticketRepo.save(addTicket);
    }

    public Optional<Ticket> updateTicket(long id, Ticket updateTicket) {
        Optional<Ticket> optionalTicket = ticketRepo.findById(id);

        if (optionalTicket.isPresent()) {
            Ticket existingTicket = optionalTicket.get();
            existingTicket.setTicketName(updateTicket.getTicketName());
            existingTicket.setTicketStartingDate(updateTicket.getTicketStartingDate());
            existingTicket.setTicketEndingDate(updateTicket.getTicketEndingDate());
            existingTicket.setTicketAssign(updateTicket.getTicketAssign());
            existingTicket.setTicketDescription(updateTicket.getTicketDescription());
            ticketRepo.save(existingTicket);
            return Optional.of(existingTicket);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteTicketById(long id) {
        if (ticketRepo.existsById(id)) {
            ticketRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
