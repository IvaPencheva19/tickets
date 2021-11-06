package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DistributorRepository implements DAORepository<Distributor>{

    private static final Logger log= Logger.getLogger(DistributorRepository.class);

    private static DistributorRepository getInstance(){
        return DistributorRepository.DistributorRepositoryHolder.INSTANCE;
    }

    private static class DistributorRepositoryHolder {

        public static DistributorRepository INSTANCE=new DistributorRepository();
    }


    @Override
    public void save(Distributor obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Distributor saved successfully");
        }
        catch (Exception ex){
            log.error(("Distributor save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Distributor obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Distributor saved successfully");
        }
        catch (Exception ex){
            log.error(("Distributor save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Distributor obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Distributor saved successfully");
        }
        catch (Exception ex){
            log.error(("Distributor save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }

    }

    @Override
    public List<Distributor> getById(Long id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Distributor>distributors=new LinkedList<>();

        try {
            String jql="SELECT d FROM Distributor d WHERE d.idDistributor=id";
            distributors.addAll(session.createQuery(jql, Distributor.class).getResultList());
            log.info("Get Distributor by id");
        }
        catch (Exception ex){
            log.error("Get Distributor error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return distributors;
    }

    @Override
    public List<Distributor> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Distributor>distributors=new LinkedList<>();

        try {
            String jql="SELECT d FROM Distributor d";
            distributors.addAll(session.createQuery(jql, Distributor.class).getResultList());
            log.info("Get all Distributor");
        }
        catch (Exception ex){
            log.error("Get Distributor error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return distributors;
    }


}
