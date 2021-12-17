package bg.tuvarna.sit.group5.tickets.presentation.models;


import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.repositories.EventTypeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EventTypeRepositoryTest {

    EventTypeRepository repository=EventTypeRepository.getInstance();
    EventType etype;
@Test
    void testCreate(){

     etype=new EventType("Sports");
    repository.save(etype);
    EventType reptype=repository.getById(etype.getIdEventType());
    assertEquals(etype.getTypeNamel(),reptype.getTypeNamel());
}
@Test
    void testUpdate(){
    etype=repository.getByName("Cinema");
    etype.setTypeNamel("Cinemas");
    repository.update(etype);
    assertEquals("Cinemas",etype.getTypeNamel());
}
@Test
    void testDelete(){
    etype=repository.getByName("Sport");
    repository.delete(etype);
    EventType reptype=repository.getByName("Sport");
    assertNull(reptype);
}
    @Test
    void testGetById(){
        etype=new EventType("Sport");
        repository.save(etype);
        EventType reptype=repository.getById(etype.getIdEventType());
        assertNotNull(reptype);
        assertEquals(etype.getIdEventType(),reptype.getIdEventType());
    }
   @Test
    void testGetAll(){
    assertEquals(3,repository.getAll().size());
   }



}
