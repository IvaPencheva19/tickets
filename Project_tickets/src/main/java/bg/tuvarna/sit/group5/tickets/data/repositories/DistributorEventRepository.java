package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;

import bg.tuvarna.sit.group5.tickets.data.entities.DistribEvent;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DistributorEventRepository implements DAORepository<DistribEvent>{

    private static final Logger log= Logger.getLogger(DistributorEventRepository.class);

    private static DistributorEventRepository getInstance(){
        return DistributorEventRepository.DistributorEventRepositoryHolder.INSTANCE;
    }

    private static class DistributorEventRepositoryHolder {

        public static DistributorEventRepository INSTANCE=new DistributorEventRepository();
    }


    @Override
    public void save(DistribEvent obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("DistributorEvent saved successfully");
        }
        catch (Exception ex){
            log.error(("DistributorEvent save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(DistribEvent obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("DistributorEvent saved successfully");
        }
        catch (Exception ex){
            log.error(("DistributorEvent save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(DistribEvent obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("DistributorEvent saved successfully");
        }
        catch (Exception ex){
            log.error(("DistributorEvent save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }

    }

    @Override
    public DistribEvent getById(int id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        DistribEvent retDistEv;
        try {
            String jql="SELECT de FROM DistribEvent de WHERE de.idDistEvent=id";
            retDistEv=session.createQuery(jql, DistribEvent.class).getSingleResult();
            log.info("Get distributorEvent by id");
        }
        catch (Exception ex){
            retDistEv=null;
            log.error("Get distributorEvent error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return retDistEv;
    }

    @Override
    public List<DistribEvent> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<DistribEvent>distributorEvents=new LinkedList<>();

        try {
            String jql="SELECT de FROM DistribEvent de";
            distributorEvents.addAll(session.createQuery(jql, DistribEvent.class).getResultList());
            log.info("Get all distributorEvent");
        }
        catch (Exception ex){
            log.error("Get distributorEvent error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return distributorEvents;
    }


}
