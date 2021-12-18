package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.*;
import bg.tuvarna.sit.group5.tickets.service.*;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EventServiceTest {
    EventTypeService etserv=EventTypeService.getInstance();
    EventService evserv=EventService.getInstance();
    OrganizerService orgserv=OrganizerService.getInstance();
    TicketsService tserv= TicketsService.getInstance();
    OrganizerService oserv=OrganizerService.getInstance();
    DistributorService dserv=DistributorService.getInstance();
    @Test
    void testCreateEvent(){
        LocalTime time= LocalTime.now();
        LocalDate date = LocalDate.of(2022, 1, 20);
        EventType type=etserv.getEventByName("Festival");
        Organizer organizer=orgserv.getByUsername("maria1");

        Event event=new Event("Spirit","New festival",date,time,"Burgas", (byte) 1,type,organizer);
        evserv.createEvent(event);
        Event ret=evserv.getByName("Spirit");
        assertNotNull(ret);
        assertEquals(event,ret);
    }
    @Test
    void testChangeDate(){
        LocalDate date = LocalDate.of(2022, 1, 24);
        Event event=evserv.getByName("Spirit");
        evserv.changeDate(event,date);
        assertEquals(date,event.getDate());
    }

    @Test
    void testChangeTime(){
        LocalTime time = LocalTime.of(20,00);
        Event event=evserv.getByName("Spirit");
        evserv.changeTime(event,time);
        assertEquals(time,event.getTime());
    }
    @Test
    void testChangePlace(){
        Event event=evserv.getByName("Spirit");
        evserv.changePlace(event,"Varna");
        assertEquals("Varna",event.getPlace());
    }
    @Test
    void testChangeStatus(){
        Event event=evserv.getByName("Spirit");
        evserv.changeStatus(event,(byte)0);
        assertEquals((byte)0,event.getPlace());
    }
    @Test
    void testChangeType(){
        EventType etype=etserv.getEventByName("Concert");
        Event event=evserv.getByName("Spirit");
        evserv.changeType(event,etype);
        assertEquals(etype,event.getEventType());
    }
    @Test
    void testChangeDescription(){
        Event event=evserv.getByName("Spirit");
        evserv.changeDescription(event,"Spirit 2022 - Concert");
        assertEquals("Spirit 2022 - Concert",event.getDescription());
    }
    @Test
    void testChangeName(){
        Event event=evserv.getByName("Spirit");
        evserv.changeName(event,"Spirit 2022");
        assertEquals("Spirit 2022",event.getName());
    }
    @Test
    void testGetByName(){
        Event event=evserv.getByName("Grafa");
        assertNotNull(event);
        assertEquals("Grafa",event.getName());
    }
    @Test
     void testAddTicket(){
        Event event=evserv.getByName("Spirit");
        Tickets tickets=new Tickets("ticket1",100.00,50,event);
        tserv.createTickets(tickets);
        evserv.addTicket(event,tickets);
        assertTrue(event.getTicketsByIdEvent().contains(tickets));
    }

    @Test
    void testGetAllByOrganizer(){
        Organizer org=oserv.getByUsername("maria1");
        ObservableList<EventModel> events=evserv.getAllByOrganizer(org);
        assertNotNull(events);
        assertEquals(4,events.size());
    }
    @Test
    void testGetByStatus(){
        Distributor dist=dserv.getByUsername("ivan222");
        ObservableList<EventModel> events=evserv.getAllByStatus(dist,(byte)1);
        assertNotNull(events);
        assertEquals(1,events.size());
    }
    @Test
    void testGetAllByDates(){
        Organizer org=oserv.getByUsername("maria1");
        LocalDate date1=LocalDate.now();
        LocalDate date2=date1.plusMonths(1);
        ObservableList<EventModel> events=evserv.getAllByDates(org,date1,date2);
        assertNotNull(events);
        assertEquals(1,events.size());
    }
    @Test
    void testGetAllByDistOrg(){
        Organizer org=oserv.getByUsername("maria1");
        Distributor dist=dserv.getByUsername("ivan222");
        Set<Event> events=evserv.getAllByDistOrg(dist,org);
        assertNotNull(events);
        assertEquals(3, events.size());
    }
    @Test
    void testMakeUnactiveEvents(){
        LocalTime time= LocalTime.now();
        LocalDate date = LocalDate.of(2021, 12, 10);
        EventType type=etserv.getEventByName("Concert");
        Organizer organizer=orgserv.getByUsername("maria1");

        Event event=new Event("Concert2","Concert",date,time,"Burgas", (byte) 1,type,organizer);
        evserv.createEvent(event);
        evserv.makeUnactiveEvents();
        Event ret=evserv.getByName("Concert2");
        assertEquals((byte)0,ret.getStatus());
    }
    @Test
    void testAddDistributor(){
        Distributor dist=dserv.getByUsername("simona123");
        Event event=evserv.getByName("Spirit");
        evserv.addDistributor(event,dist);
        assertTrue(event.getDistribEvent().contains(dist));
    }




}
