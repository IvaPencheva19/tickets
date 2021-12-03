package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EventRepository implements DAORepository<Event>,DAOEvent<Event>{

    private static final Logger log= Logger.getLogger(EventRepository.class);

    public static EventRepository getInstance(){
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
            session.close();
        }
    }

    @Override
    public void update(Event obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Event updated successfully");
        }
        catch (Exception ex){
            log.error(("Event update error" + ex.getMessage()));
        }
        finally {
            transaction.commit();

            session.close();
        }
    }

    @Override
    public void delete(Event obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Event deleted successfully");
        }
        catch (Exception ex){
            log.error(("Event delete error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
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
            session.close();
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
            session.close();
        }
        return events;
    }
    @Override
    public List<Event> getAllEventsByPlace(Organizer org,String place) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Event>events=new LinkedList<>();

        try {
            String jql = "SELECT e FROM Event e WHERE  e.place= :place AND e.organizer= :org";
            Query query = session.createQuery(jql);
            query.setParameter("place", place);
            query.setParameter("org", org);
            events.addAll(query.getResultList());
            log.info("Get all distributors");
        }
        catch (Exception ex){
            log.error("Get Distributor error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return events;
    }
    @Override
    public List<Event> getAllEventsByDate(Organizer org,Date date) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Event>events=new LinkedList<>();

        try {
            String jql = "SELECT e FROM Event e WHERE  e.date= :date AND e.organizer= :org";
            Query query = session.createQuery(jql);
            query.setParameter("date", date);
            query.setParameter("org", org);
            events.addAll(query.getResultList());
            log.info("Get all distributors");
        }
        catch (Exception ex){
            log.error("Get Distributor error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return events;
    }

    public List<Event> getAllEventsByDates(Organizer org, LocalDate date, LocalDate date2) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Event>events=new LinkedList<>();

        try {
            String jql = "SELECT e FROM Event e WHERE  e.date> :date AND e.date< :date2 AND e.organizer= :org";
            Query query = session.createQuery(jql);
            query.setParameter("date", date);
            query.setParameter("date2", date2);
            query.setParameter("org", org);
            events.addAll(query.getResultList());
            log.info("Get all distributors");
        }
        catch (Exception ex){
            log.error("Get Distributor error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return events;
    }

    public Event getByName(String name) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        Event retEvent;

        try {
            String jql = "SELECT u FROM Event u WHERE name = :name";
            Query query = session.createQuery(jql, Event.class);
            query.setParameter("name", name);
            retEvent= (Event)query.getSingleResult();
            log.info("Get type by name");
        }
        catch (Exception ex){
            retEvent=null;
            log.error("Get event error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retEvent;
    }

    public List<Event> getAllEventsByStatus(Organizer org,Byte status) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Event>events=new LinkedList<>();

        try {
            String jql = "SELECT e FROM Event e WHERE  e.status= :status AND e.organizer= :org";
            Query query = session.createQuery(jql);
            query.setParameter("status", status);
            query.setParameter("org", org);
            events.addAll(query.getResultList());
            log.info("Get all distributors");
        }
        catch (Exception ex){
            log.error("Get Distributor error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return events;
    }

    public List<Event> getAllEventsByOrganizer(Organizer org) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Event>events=new LinkedList<>();

        try {
            String jql = "SELECT e FROM Event e WHERE  e.organizer= :organizer";
            Query query = session.createQuery(jql);
            query.setParameter("organizer", org);
            events.addAll(query.getResultList());
            log.info("Get all events");
        }
        catch (Exception ex){
            log.error("Get Events error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return events;
    }
}
