package bg.tuvarna.sit.group5.tickets.data.access;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
public class Connection {
private static final Logger log=Logger.getLogger(Connection.class);
private static SessionFactory sessionFactory;
static{
    try{
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    catch(Throwable ex){
        log.error("Initial SessionFactory created failed "+ex);
    }
}
public static Session openSession(){
    return sessionFactory.openSession();
}
public static void openSessionClose(){
    sessionFactory.close();
}

}
