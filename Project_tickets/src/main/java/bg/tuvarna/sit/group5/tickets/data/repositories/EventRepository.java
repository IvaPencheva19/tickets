package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EventRepository implements DAORepository<Event>{

    private static final Logger log= Logger.getLogger(EventRepository.class);

    private static EventRepository getInstance(){
        return EventRepository.EventRepositoryHolder.INSTANCE;
    }

    private static class EventRepositoryHolder {

        public static EventRepository INSTANCE=new EventRepository();
    }


    @Override
    public void save(Event obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Event saved successfully");
        }
        catch (Exception ex){
            log.error(("Event save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Event obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Event saved successfully");
        }
        catch (Exception ex){
            log.error(("Event save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Event obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Event saved successfully");
        }
        catch (Exception ex){
            log.error(("Event save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }

    }

    @Override
    public Event getById(int id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        Event retEvent;

        try {
            String jql="SELECT e FROM Event e WHERE e.idEvent=id";
            retEvent=session.createQuery(jql, Event.class).getSingleResult();
            log.info("Get event by id");
        }
        catch (Exception ex){
            retEvent=null;
            log.error("Get event error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return retEvent;
    }

    @Override
    public List<Event> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Event>events=new LinkedList<>();

        try {
            String jql="SELECT e FROM Event e";
            events.addAll(session.createQuery(jql, Event.class).getResultList());
            log.info("Get all admins");
        }
        catch (Exception ex){
            log.error("Get Admin error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return events;
    }


}
