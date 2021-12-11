package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Notifications;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;


public class UserService {
    private final UserRepository repository = UserRepository.getInstance();

    public static UserService getInstance() {
        return UserService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final UserService INSTANCE = new UserService();
    }


    public void deleteUser(User user){
        repository.delete(user);
    }
    public boolean isAllSeen(User user){
        boolean seen=true;
        for (Notifications n:user.getNotifs()){
            if(n.getSeen()==0) seen=false;
        }
        return seen;
    }
}
