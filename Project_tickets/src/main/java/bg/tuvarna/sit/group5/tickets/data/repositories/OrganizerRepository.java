package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OrganizerRepository implements DAORepository<Organizer>{

    private static final Logger log= Logger.getLogger(OrganizerRepository.class);

    private static OrganizerRepository getInstance(){
        return OrganizerRepository.OrganizerRepositoryHolder.INSTANCE;
    }

    private static class OrganizerRepositoryHolder {

        public static OrganizerRepository INSTANCE=new OrganizerRepository();
    }


    @Override
    public void save(Organizer obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Organizer saved successfully");
        }
        catch (Exception ex){
            log.error(("Organizer save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Organizer obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Organizer saved successfully");
        }
        catch (Exception ex){
            log.error(("Organizer save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Organizer obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Organizer saved successfully");
        }
        catch (Exception ex){
            log.error(("Organizer save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }

    }

    @Override
    public Organizer getById(Long id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        Organizer retOrganizer;

        try {
            String jql="SELECT o FROM Organizer o WHERE o.idOrganizer=id";
            retOrganizer=session.createQuery(jql, Organizer.class).getSingleResult();
            log.info("Get organizer by id");
        }
        catch (Exception ex){
            retOrganizer=null;
            log.error("Get organizer error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return retOrganizer;
    }

    @Override
    public List<Organizer> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Organizer>organizers=new LinkedList<>();

        try {
            String jql="SELECT o FROM Organizer o";
            organizers.addAll(session.createQuery(jql, Organizer.class).getResultList());
            log.info("Get all organizer");
        }
        catch (Exception ex){
            log.error("Get organizer error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return organizers;
    }


}
