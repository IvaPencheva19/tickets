package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.OrganizerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

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
}
