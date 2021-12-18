package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.SellTickets;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;
import bg.tuvarna.sit.group5.tickets.data.repositories.SellTicketsRepository;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.SellTicketsService;
import bg.tuvarna.sit.group5.tickets.service.TicketsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SellTicketsServiceTest {
    SellTicketsService stserv=SellTicketsService.getInstance();
    TicketsService tserv=TicketsService.getInstance();
    EventService eserv=EventService.getInstance();
    DistributorService dserv=DistributorService.getInstance();
    SellTicketsRepository srep=SellTicketsRepository.getInstance();
    @Test
    void testCreateSellTickets(){
        Event event=eserv.getByName("Grafa");
        Tickets tickets=tserv.getByType("zone1",event);
        Distributor dis=dserv.getByUsername("ivan222");
        SellTickets sellTickets=new SellTickets(2,"Petar Mitev",tickets,dis,event);
        stserv.createSellTickets(sellTickets);
        SellTickets ret= srep.getById(sellTickets.getIdSell());
        assertNotNull(ret);
        assertEquals(sellTickets,ret);
    }
}
