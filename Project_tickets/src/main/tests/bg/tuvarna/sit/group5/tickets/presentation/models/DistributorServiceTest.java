package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Admin;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.service.AdminService;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.*;

public class DistributorServiceTest {
    DistributorService disserv=DistributorService.getInstance();
    UserRepository urep=UserRepository.getInstance();
    @Test
    void testChangeUserName() {
        Distributor dis=(Distributor)urep.getByUsername("elena");
        disserv.changeUserName(dis,"elena11");
        assertEquals("elena11",dis.getUsername());
    }
    @Test
    void testChangePassword() {
        Distributor dis=(Distributor)urep.getByUsername("elena11");
        disserv.changePassword(dis,"elena11");
        assertEquals("elena11",dis.getPassword());
    }
    @Test
    void testChangeFirstName() {
        Distributor dis=(Distributor)urep.getByUsername("elena11");
        disserv.changeFirstName(dis,"Eleonora");
        assertEquals("Eleonora",dis.getFirstname());
    }
    @Test
    void testChangeLastName() {
        Distributor dis=(Distributor)urep.getByUsername("elena11");
        disserv.changeLastName(dis,"Ilieva");
        assertEquals("Ilieva",dis.getLastname());
    }
    @Test
    void testChangePhone() {
        Distributor dis=(Distributor)urep.getByUsername("elena11");
        disserv.changePhone(dis,"0881637813");
        assertEquals("0881637813",dis.getPhone());
    }
    @Test
    void testChangeEmail() {
        Distributor dis=(Distributor)urep.getByUsername("elena11");
        disserv.changeEmail(dis,"eli.ilieva@gmail.com");
        assertEquals("eli.ilieva@gmail.com",dis.getEmail());
    }
    @Test
    void testChangeHonor() {
        Distributor dis=(Distributor)urep.getByUsername("elena11");
        disserv.changeHonor(dis,1600);
        assertEquals(1600,dis.getHonor());
    }
    @Test
    void testCreateDistributor(){
        Distributor dis=new Distributor("simona123","123","Simona","Diqnova","0887965733","diqnova99@gmail.com",1200,0);
       disserv.createDistributor(dis);
        Distributor reptype=disserv.getByUsername("simona123");
        assertNotNull(reptype);
        assertEquals(dis,reptype);
    }
    @Test
    void testDeleteDistributor(){
        Distributor dis=disserv.getByUsername("dist1");
        disserv.deleteDistributor(dis);
        Distributor reptype=disserv.getByUsername("dist1");
        assertNull(reptype);
    }
    @Test
    void testGetByUserName(){
       Distributor dis = disserv.getByUsername("simona123");
       assertNotNull(dis);
       assertEquals("simona123",dis.getUsername());
    }
   @Test
    void getAllDistributors(){
       ObservableList<DistributorModel> dis=disserv.getAllDistributors();
       assertNotNull(dis);
       assertEquals(3,dis.size());
   }
   @Test
    void testAddEvent(){
        EventService evserv=EventService.getInstance();
        Event event=evserv.getByName("Grafa");
        Distributor dis=disserv.getByUsername("simona123");
        disserv.addEvent(dis,event);
        assertTrue(dis.getEventsByDistributor().contains(event));
   }
    @Test
    void testDeleteEvent(){
        EventService evserv=EventService.getInstance();
        Event event=evserv.getByName("Grafa");
        Distributor dis=disserv.getByUsername("simona123");
        disserv.removeEvent(dis,event);
        assertFalse(dis.getEventsByDistributor().contains(event));

    }




}
