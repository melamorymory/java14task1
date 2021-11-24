package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketManager manager = new TicketManager();
    Ticket ticket1 = new Ticket(1, 2253, "DME", "LED", 100);
    Ticket ticket2 = new Ticket(2, 1586, "DME", "LED", 90);
    Ticket ticket3 = new Ticket(3, 1618, "DME", "LED", 100);
    Ticket ticket4 = new Ticket(4, 2253, "LED", "DME", 100);
    Ticket ticket5 = new Ticket(5, 2551, "SVO", "LED", 90);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    void shouldFindDME_LEDTickets() {
        Ticket[] actual = manager.findAll("DME", "LED");
        Ticket[] expected = new Ticket[]{ticket2, ticket3, ticket1};
        Arrays.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindDME_KZNTickets() {
        Ticket[] actual = manager.findAll("DME", "KZN");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindVKO_KZNTickets() {
        Ticket[] actual = manager.findAll("VKO", "KZN");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }
}