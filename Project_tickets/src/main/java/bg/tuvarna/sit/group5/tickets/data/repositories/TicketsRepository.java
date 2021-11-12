package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
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

    private static TicketsRepository getInstance(){
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
        }
    }

    @Override
    public void update(Tickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Tickets saved successfully");
        }
        catch (Exception ex){
            log.error(("Tickets save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Tickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Tickets saved successfully");
        }
        catch (Exception ex){
            log.error(("Tickets save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }

    }

    @Override
    public Tickets getById(Long id) {
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
        }
        return tickets;
    }


}
