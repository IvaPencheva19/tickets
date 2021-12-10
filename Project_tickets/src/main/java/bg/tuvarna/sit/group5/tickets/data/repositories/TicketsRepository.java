package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TicketsRepository implements DAORepository<Tickets>{

    private static final Logger log= Logger.getLogger(TicketsRepository.class);

   public static TicketsRepository getInstance(){
        return TicketsRepository.TicketsRepositoryHolder.INSTANCE;
    }

    private static class TicketsRepositoryHolder {

        public static TicketsRepository INSTANCE=new TicketsRepository();
    }


    @Override
    public void save(Tickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Tickets saved successfully");
        }
        catch (Exception ex){
            log.error(("Tickets save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Tickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Tickets updated successfully");
        }
        catch (Exception ex){
            log.error(("Tickets update error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Tickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Tickets deleted successfully");
        }
        catch (Exception ex){
            log.error(("Tickets delete error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public Tickets getById(int id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        Tickets retTickets;

        try {
            String jql="SELECT t FROM Tickets t WHERE t.idTickets=id";
            retTickets=session.createQuery(jql, Tickets.class).getSingleResult();
            log.info("Get tickets by id");
        }
        catch (Exception ex){
            retTickets=null;
            log.error("Get tickets error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retTickets;
    }

    @Override
    public List<Tickets> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Tickets>tickets=new LinkedList<>();

        try {
            String jql="SELECT t FROM Tickets t";
            tickets.addAll(session.createQuery(jql, Tickets.class).getResultList());
            log.info("Get all tickets");
        }
        catch (Exception ex){
            log.error("Get tickets error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return tickets;
    }

    public Tickets getByType(String name, Event ev) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
       Tickets retType;
        try {
            String jql = "SELECT u FROM Tickets u WHERE type = :name AND eventByEventIdEvent=:ev";
            Query query = session.createQuery(jql,Tickets.class);
            query.setParameter("name", name);
            query.setParameter("ev", ev);
            retType= (Tickets) query.getSingleResult();
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
