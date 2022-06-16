package ru.netology.tickets;

import ru.netology.tickets.data.Ticket;
import ru.netology.tickets.exceptions.NotFoundException;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tickets.length] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int ticketId) {
        if (findById(ticketId) != null) {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int counter = 0;
            for (Ticket ticket : tickets) {
                if (ticket.getId() != ticketId) {
                    tmp[counter] = ticket;
                    counter++;
                }
            }
            tickets = tmp;
        } else {
            throw new NotFoundException("Element with id: " + ticketId + " not found");
        }
    }
}