package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Notifications;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class NotificationsRepository implements  DAORepository<Notifications>{
    private static final Logger log= Logger.getLogger(EventRepository.class);

    public static NotificationsRepository getInstance(){
        return NotificationsRepository.NotificationsRepositoryHolder.INSTANCE;
    }

    private static class NotificationsRepositoryHolder {

        public static NotificationsRepository INSTANCE=new NotificationsRepository();
    }
    @Override
    public void save(Notifications obj) {
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
    public void update(Notifications obj) {
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
    public void delete(Notifications obj) {
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
    public Notifications getById(int id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        Notifications retNotif;

        try {
            String jql="SELECT e FROM Notifications e WHERE e.idNotif=id";
            retNotif=session.createQuery(jql, Notifications.class).getSingleResult();
            log.info("Get event by id");
        }
        catch (Exception ex){
            retNotif=null;
            log.error("Get event error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return  retNotif;
    }

    @Override
    public List<Notifications> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Notifications> notifs=new LinkedList<>();

        try {
            String jql="SELECT e FROM Notifications e";
            notifs.addAll(session.createQuery(jql, Notifications.class).getResultList());
            log.info("Get all admins");
        }
        catch (Exception ex){
            log.error("Get Admin error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return notifs;
    }
}
