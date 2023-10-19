package com.workflow.entity;

import jakarta.persistence.Id;
import java.util.Date;

public class Ticket {

    @Id
    long ticketId;
    String ticketName;
    String ticketDescription;
    User ticketAssign;
    Date ticketStartingDate;

    public Date getTicketEndingDate() {
        return ticketEndingDate;
    }

    public void setTicketEndingDate(Date ticketEndingDate) {
        this.ticketEndingDate = ticketEndingDate;
    }

    Date ticketEndingDate;

    public Ticket(){}

    public Ticket(long ticketId, String ticketDescription) {
        this.ticketId = ticketId;
        this.ticketDescription = ticketDescription;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public User getTicketAssign() {
        return ticketAssign;
    }

    public void setTicketAssign(User ticketAssign) {
        this.ticketAssign = ticketAssign;
    }

    public Date getTicketStartingDate() {
        return ticketStartingDate;
    }

    public void setTicketStartingDate(Date ticketStartingDate) {
        this.ticketStartingDate = ticketStartingDate;
    }


}
