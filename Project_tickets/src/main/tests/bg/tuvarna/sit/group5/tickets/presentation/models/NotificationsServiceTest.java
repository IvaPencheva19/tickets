package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Notifications;
import bg.tuvarna.sit.group5.tickets.data.repositories.NotificationsRepository;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.NotificationsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationsServiceTest {
    NotificationsService nserv= NotificationsService.getInstance();
    DistributorService dserv=DistributorService.getInstance();
    NotificationsRepository nrep=NotificationsRepository.getInstance();
    @Test
    void testCreateNotification(){
        Distributor dist=dserv.getByUsername("ivan222");
        Notifications not=new Notifications("Test Notification",dist);
        nserv.createNotification(not);
        Notifications ret=nrep.getById(not.getIdNotif());
        assertNotNull(ret);
        assertEquals(ret,not);
    }
    @Test
    void testSetSeen(){
        Notifications ret=nrep.getById(35);
        nserv.setSeen(ret,(byte)1);
        assertEquals((byte)1,ret.getSeen());
    }
    @Test
    void testDeleteNotifications(){
        Notifications ret=nrep.getById(35);
        nserv.deleteNotification(ret);
        Notifications nt=nrep.getById(35);
        assertNull(nt);
    }
}
