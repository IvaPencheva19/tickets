package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.SellTickets;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class SellTicketsRepository implements DAORepository<SellTickets>{

    private static final Logger log= Logger.getLogger(SellTicketsRepository.class);

    public static SellTicketsRepository getInstance(){
        return SellTicketsRepository.SellTicketsRepositoryHolder.INSTANCE;
    }

    private static class SellTicketsRepositoryHolder {

        public static SellTicketsRepository INSTANCE=new SellTicketsRepository();
    }


    @Override
    public void save(SellTickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Sell tickets saved successfully");
        }
        catch (Exception ex){
            log.error(("Sell tickets save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(SellTickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Sell tickets updated successfully");
        }
        catch (Exception ex){
            log.error(("Sell tickets update error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(SellTickets obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Sell tickets deleted successfully");
        }
        catch (Exception ex){
            log.error(("Sell tickets delete error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public SellTickets getById(int id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        SellTickets retSellTickets;

        try {
            String jql = "SELECT u FROM SellTickets u WHERE idSell = :id";
            Query query = session.createQuery(jql, SellTickets.class);
            query.setParameter("id", id);
            retSellTickets= (SellTickets) query.getSingleResult();
            log.info("Get sell tickets by id");
        }
        catch (Exception ex){
            retSellTickets=null;
            log.error("Get sell tickets error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retSellTickets;
    }

    @Override
    public List<SellTickets> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<SellTickets>sellTickets=new LinkedList<>();

        try {
            String jql="SELECT st FROM SellTickets st";
            sellTickets.addAll(session.createQuery(jql, SellTickets.class).getResultList());
            log.info("Get all sell tickets");
        }
        catch (Exception ex){
            log.error("Get sell tickets error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return sellTickets;
    }


}
