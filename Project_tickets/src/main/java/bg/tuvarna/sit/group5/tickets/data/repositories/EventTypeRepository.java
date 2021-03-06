package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EventTypeRepository implements DAORepository<EventType>{

    private static final Logger log= Logger.getLogger(EventTypeRepository.class);

    public static EventTypeRepository getInstance(){
        return EventTypeRepository.EventTypeRepositoryHolder.INSTANCE;
    }

    private static class EventTypeRepositoryHolder {

        public static EventTypeRepository INSTANCE=new EventTypeRepository();
    }


    @Override
    public void save(EventType obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("EventType saved successfully");
        }
        catch (Exception ex){
            log.error(("EventType save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(EventType obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("EventType updated successfully");
        }
        catch (Exception ex){
            log.error(("EventType update error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(EventType obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("EventType deleted successfully");
        }
        catch (Exception ex){
            log.error(("EventType delete error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public EventType getById(int id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        EventType retEvType;

        try {
            String jql = "SELECT u FROM EventType u WHERE idEventType = :id";
            Query query = session.createQuery(jql,EventType.class);
            query.setParameter("id", id);
            retEvType= (EventType)query.getSingleResult();
            log.info("Get event type by id");
        }
        catch (Exception ex){
            retEvType=null;
            log.error("Get event type error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retEvType;
    }

    @Override
    public List<EventType> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<EventType>eventTypes=new LinkedList<>();

        try {
            String jql="SELECT et FROM EventType et";
            eventTypes.addAll(session.createQuery(jql, EventType.class).getResultList());
            log.info("Get all event types");
        }
        catch (Exception ex){
            log.error("Get event types error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return eventTypes;
    }


    public EventType getByName(String name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        EventType retType;
        try {
            String jql = "SELECT u FROM EventType u WHERE typeNamel = :name";
            Query query = session.createQuery(jql,EventType.class);
            query.setParameter("name", name);
            retType= (EventType)query.getSingleResult();
            log.info("Get type by name");
        }
        catch (Exception ex){
            retType=null;
            log.error("Get type error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retType;
    }

}
