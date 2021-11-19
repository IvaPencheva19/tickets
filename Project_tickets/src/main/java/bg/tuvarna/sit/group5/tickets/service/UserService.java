package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.data.repositories.EventTypeRepository;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.AllOrganizerModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
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

    public ObservableList<AllOrganizerModel> getAllOrganizers() {
        List<Organizer> orgs = repository.getAllOrganizers();

        return FXCollections.observableList(
                orgs.stream().map(t -> new AllOrganizerModel(t.getUsername())).collect(Collectors.toList()));
    }
    public void deleteUser(User user){
        repository.delete(user);
    }
}
