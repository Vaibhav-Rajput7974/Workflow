package com.example.Workflows.Repositary;

import com.example.Workflows.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepositary extends JpaRepository<Ticket,Long> {
}
