package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;
import bg.tuvarna.sit.group5.tickets.data.repositories.TicketsRepository;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.TicketsService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsServiceTest {
    TicketsService tserv=TicketsService.getInstance();
    TicketsRepository trep=TicketsRepository.getInstance();
    EventService eserv=EventService.getInstance();

    @Test
    void testCreateTickets(){
        Event event=eserv.getById(45);
       Tickets tickets=new Tickets("typeTick",100.00,50,event);
        tserv.createTickets(tickets);
        Tickets reptype=tserv.getByType("typeTick",event);
        assertNotNull(reptype);
        assertEquals(tickets,reptype);
    }
    @Test
    void testDeleteTickets(){
        Event event=eserv.getById(47);
        Tickets tickets=tserv.getByType("type2",event);
        tserv.deleteTickets(tickets);
        Tickets ret=tserv.getByType("type2",event);
        assertNull(ret);
    }
    @Test
    void testChangeType(){
        Event event=eserv.getById(45);
        Tickets tickets=tserv.getByType("typeTick",event);
        tserv.changeType(tickets,"type2");
        assertEquals("type2",tickets.getType());
    }
    @Test
    void testChangePrice(){
        Event event=eserv.getById(45);
        Tickets tickets=tserv.getByType("type2",event);
        tserv.changePrice(tickets,60.00);
        assertEquals(60.00,tickets.getPrice());
    }
    @Test
    void testChangeCount(){
        Event event=eserv.getById(45);
        Tickets tickets=tserv.getByType("type2",event);
        tserv.changeCount(tickets,100);
        assertEquals(100,tickets.getCount());
    }
    @Test
    void testGetByType(){
        Event event=eserv.getById(45);
        Tickets tickets=tserv.getByType("type2",event);
        assertNotNull(tickets);
        assertEquals("type2",tickets.getType());
    }
    @Test
    void testGetAllTicketsByEvent(){
        Event event=eserv.getByName("Grafa");
        ObservableList<TicketsModel> tickets=tserv.getAllTicketsByEvent(event);
        assertNotNull(tickets);
        assertEquals(2,tickets.size());
    }
}
