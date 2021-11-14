package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements DAORepository<User>{

    private static final Logger log= Logger.getLogger(UserRepository.class);

    private static UserRepository getInstance(){
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
        }
    }

    @Override
    public void update(User obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("User saved successfully");
        }
        catch (Exception ex){
            log.error(("User save error" + ex.getMessage()));
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
            log.info("User saved successfully");
        }
        catch (Exception ex){
            log.error(("User save error" + ex.getMessage()));
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


}
