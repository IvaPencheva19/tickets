package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Notifications;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.data.repositories.NotificationsRepository;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;

public class NotificationsService {
    private final NotificationsRepository repository = NotificationsRepository.getInstance();

    public static NotificationsService getInstance() {
        return NotificationsService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final NotificationsService INSTANCE = new NotificationsService();
    }
    public void createNotification(Notifications not){
        repository.save(not);
    }

    public void deleteNotification(Notifications not){
        repository.delete(not);
    }

    public void setSeen(Notifications not,Byte b){
        not.setSeen(b);
        repository.update(not);
    }
    public void deleteByDistributor(Distributor dist){
        for(Notifications n:dist.getNotifs()){
            deleteNotification(n);
        }
    }
    public void deleteByOrganizer(Organizer org){
        for(Notifications n:org.getNotifs()){
            deleteNotification(n);
        }
    }

}
