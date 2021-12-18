package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.OrganizerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class OrganizerService {
    private final UserRepository repository = UserRepository.getInstance();

    public static OrganizerService getInstance() {
        return OrganizerService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final OrganizerService INSTANCE = new OrganizerService();
    }


    public void createOrganizer(Organizer organizer){
        repository.save(organizer);
    }

    public void deleteOrganizer(Organizer organizer){
        repository.delete(organizer);
    }

    public void changeUserName(Organizer organizer, String username){
        organizer.setUsername(username);
        repository.update(organizer);
    }

    public void changePassword(Organizer organizer, String password){
        organizer.setPassword(password);
        repository.update(organizer);
    }

    public void changeFirstName(Organizer organizer, String firstName){
        organizer.setFirstname(firstName);
        repository.update(organizer);
    }

    public void changeLastName(Organizer organizer, String lastName){
        organizer.setLastname(lastName);
        repository.update(organizer);
    }
    public void changePhone(Organizer organizer, String phone){
        organizer.setPhone(phone);
        repository.update(organizer);
    }
    public void changeEmail(Organizer organizer, String email){
        organizer.setEmail(email);
        repository.update(organizer);
    }

    public void changeHonor(Organizer organizer, double honor){
        organizer.setHonor(honor);
        repository.update(organizer);
    }

    public ObservableList<OrganizerModel> getAllOrganizers() {
        List<Organizer> orgs = repository.getAllOrganizers();

        return FXCollections.observableList(
                orgs.stream().map(t -> new OrganizerModel(t.getUsername(),t.getPassword(),t.getFirstname(),
                        t.getLastname(), t.getPhone(), t.getEmail(), t.getHonor())).collect(Collectors.toList()));
    }
    public Organizer getByUsername(String username){
        Organizer ret=(Organizer)repository.getByUsername(username);
        return ret;
    }
   /* public void addEvent(Organizer org, Event event){
        org.addEvent(event);
        repository.update(org);
    }*/
}
