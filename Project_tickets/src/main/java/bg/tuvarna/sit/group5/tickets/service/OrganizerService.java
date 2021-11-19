package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;

public class OrganizerService {
    private final UserRepository repository = UserRepository.getInstance();

    public static UserService getInstance() {
        return OrganizerService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final UserService INSTANCE = new UserService();
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
}
