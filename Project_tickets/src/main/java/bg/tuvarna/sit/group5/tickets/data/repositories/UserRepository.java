package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements DAORepository<User>,DAOUser{

    private static final Logger log= Logger.getLogger(UserRepository.class);

    public static UserRepository getInstance(){
        return UserRepository.UserRepositoryHolder.INSTANCE;
    }

    private static class UserRepositoryHolder {

        public static UserRepository INSTANCE=new UserRepository();
    }


    @Override
    public void save(User obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("User saved successfully");
        }
        catch (Exception ex){
            log.error(("User save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(User obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("User updated successfully");
        }
        catch (Exception ex){
            log.error(("User update error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(User obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("User deleted successfully");
        }
        catch (Exception ex){
            log.error(("User delete error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }

    }

    @Override
    public User getById(int id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        User retUser;
        try {
            String jql="SELECT u FROM User u WHERE u.idUser=id";
            retUser=(session.createQuery(jql, User.class)).getSingleResult();
            log.info("Get user by id");
        }
        catch (Exception ex){
            retUser=null;
            log.error("Get User error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return retUser;
    }

    @Override
    public List<User> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<User>users=new LinkedList<>();

        try {
            String jql="SELECT u FROM User u";
            users.addAll(session.createQuery(jql, User.class).getResultList());
            log.info("Get all users");
        }
        catch (Exception ex){
            log.error("Get User error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return users;
    }

    @Override
    public User getByUsername(String uname) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        User retUser;
        try {
            String jql = "SELECT u FROM User u WHERE username = :name";
            Query query = session.createQuery(jql,User.class);
            query.setParameter("name", uname);
            retUser= (User)query.getSingleResult();
            log.info("Get user by username");
        }
        catch (Exception ex){
            retUser=null;
            log.error("Get User error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return retUser;
    }

    @Override
    public List<Organizer> getAllOrganizers() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Organizer>users=new LinkedList<>();

        try {
            String jql = "SELECT o FROM Organizer o";
            Query query = session.createQuery(jql);
            users.addAll(session.createQuery(jql, Organizer.class).getResultList());
            log.info("Get all organizers");
        }
        catch (Exception ex){
            log.error("Get Organizer error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return users;
    }

    @Override
    public List<Distributor> getAllDistributors() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Distributor>users=new LinkedList<>();

        try {
            String jql = "SELECT d FROM Distributor d";
            Query query = session.createQuery(jql);
            users.addAll(session.createQuery(jql, Distributor.class).getResultList());
            log.info("Get all distributors");
        }
        catch (Exception ex){
            log.error("Get Distributor error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
            session.close();
        }
        return users;
    }


}
