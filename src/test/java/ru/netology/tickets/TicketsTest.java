package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.tickets.data.Ticket;

public class TicketsTest {

    Ticket ticket1 = new Ticket(1, 25000.0, "SVO", "NYC", 300.0);
    Ticket ticket2 = new Ticket(2, 41500.0, "STO", "WAS", 240.0);
    Ticket ticket3 = new Ticket(3, 18750.0, "VKO", "MXP", 120.0);
    Ticket ticket4 = new Ticket(4, 21000.0, "ZIA", "LHR", 150.0);
    Ticket ticket5 = new Ticket(5, 23000.0, "ROM", "PAR", 60.0);
    Ticket ticket6 = new Ticket(6, 21000.0, "ROM", "PAR", 55);
    Ticket ticket7 = new Ticket(7, 37500.0, "STO", "WAS", 250.0);

    @Test
    public void managerSearch() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket[] expected = {ticket7, ticket2};
        Ticket[] actual = manager.findAll("STO", "WAS");
        Assertions.assertArrayEquals(expected, actual);
        expected = new Ticket[]{ticket6, ticket5};
        actual = manager.findAll("ROM", "PAR");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void managerEmptySearchResult() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("QQQ", "WWW");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void managerSingleSearchResult() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("ZIA", "LHR");
        Assertions.assertArrayEquals(expected, actual);
    }
}
