package ru.netology.tickets;

import ru.netology.tickets.data.Ticket;

import java.util.Arrays;

public class Manager {

    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    private Ticket[] addToArray(Ticket[] sourceArray, Ticket toAdd) {
        Ticket[] tmp = new Ticket[sourceArray.length + 1];
        for (int i = 0; i < sourceArray.length; i++) {
            tmp[i] = sourceArray[i];
        }
        tmp[sourceArray.length] = toAdd;
        sourceArray = tmp;
        return sourceArray;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] output = new Ticket[0];
        Ticket[] currentTickets = repository.findAll();
        for (Ticket ticket : currentTickets) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                output = addToArray(output, ticket);
            }
        }
        Arrays.sort(output);
        return output;
    }
}