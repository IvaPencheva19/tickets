package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.service.EventTypeService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventTypeTest {
    EventTypeService etserv=EventTypeService.getInstance();
    @Test
    void testCreateEventType(){
        EventType etype=new EventType("Festival");
        etserv.createEventType(etype);
        EventType ret=etserv.getEventByName("Festival");
        assertNotNull(ret);
    }
    @Test
    void testDeleteEventType(){
        EventType etype=etserv.getEventByName("Sport");
        etserv.deleteEventType(etype);
        EventType ret=etserv.getEventByName("Sport");
        assertNull(ret);
    }
    @Test
    void testGetEventByName(){
        EventType ret=etserv.getEventByName("Festival");
        assertNotNull(ret);
        assertEquals("Festival",ret.getTypeNamel());
    }
    @Test
    void testgetAll(){
        ObservableList<EventTypeModel> types=etserv.getAll();
        assertNotNull(types);
        assertEquals(3,types.size());
    }


}
