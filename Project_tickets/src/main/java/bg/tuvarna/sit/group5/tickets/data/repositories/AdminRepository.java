package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.access.Connection;
import bg.tuvarna.sit.group5.tickets.data.entities.Admin;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AdminRepository implements DAORepository<Admin>{

    private static final Logger log= Logger.getLogger(AdminRepository.class);

    private static AdminRepository getInstance(){
        return AdminRepository.AdminRepositoryHolder.INSTANCE;
    }

    private static class AdminRepositoryHolder {

        public static AdminRepository INSTANCE=new AdminRepository();
    }


    @Override
    public void save(Admin obj) {
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
    public void update(Admin obj) {
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
    public void delete(Admin obj) {
        Session session= Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Admin saved successfully");
        }
        catch (Exception ex){
            log.error(("Admin save error" + ex.getMessage()));
        }
        finally {
            transaction.commit();
        }

    }

    @Override
    public Admin getById(Long id) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        Admin retAdmin;

        try {
            String jql="SELECT a FROM Admin a WHERE a.idAdmin=id";
            retAdmin=session.createQuery(jql, Admin.class).getSingleResult();
            log.info("Get admin by id");
        }
        catch (Exception ex){
            retAdmin=null;
            log.error("Get admin error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return retAdmin;
    }

    @Override
    public List<Admin> getAll() {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Admin>admins=new LinkedList<>();

        try {
            String jql="SELECT a FROM Admin a";
            admins.addAll(session.createQuery(jql, Admin.class).getResultList());
            log.info("Get all admins");
        }
        catch (Exception ex){
            log.error("Get Admin error: " +ex.getMessage());
        }
        finally {
            transaction.commit();
        }
        return admins;
    }


}
