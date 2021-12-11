package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;

import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.DistributorModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class DistributorService {
    private final UserRepository repository = UserRepository.getInstance();

    public static UserService getInstance() {
        return DistributorService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final UserService INSTANCE = new UserService();
    }

    public void createDistributor(Distributor distributor){
        repository.save(distributor);
    }

    public void deleteDistributor(Distributor distributor){
        repository.delete(distributor);
    }

    public void changeUserName(Distributor distributor, String username){
        distributor.setUsername(username);
        repository.update(distributor);
    }

    public void changePassword(Distributor distributor, String password){
        distributor.setPassword(password);
        repository.update(distributor);
    }

    public void changeFirstName(Distributor distributor, String firstName){
        distributor.setFirstname(firstName);
        repository.update(distributor);
    }

    public void changeLastName(Distributor distributor, String lastName){
        distributor.setLastname(lastName);
        repository.update(distributor);
    }
    public void changePhone(Distributor distributor, String phone){
        distributor.setPhone(phone);
        repository.update(distributor);
    }
    public void changeEmail(Distributor distributor, String email){
        distributor.setEmail(email);
        repository.update(distributor);
    }

    public void changeHonor(Distributor distributor, double honor){
        distributor.setHonor(honor);
        repository.update(distributor);
    }

    public void changeRating(Distributor distributor, double rating){
        distributor.setRating(rating);
        repository.update(distributor);
    }


    public ObservableList<DistributorModel> getAllDistributors() {
        List<Distributor> distribs = repository.getAllDistributors();

        return FXCollections.observableList(
                distribs.stream().map(t -> new DistributorModel(t.getUsername(),t.getPassword(),t.getFirstname(),
                        t.getLastname(), t.getPhone(), t.getEmail(), t.getHonor(), t.getRating())).collect(Collectors.toList()));
    }

    public Distributor getByUsername(String username){
        Distributor ret=(Distributor) repository.getByUsername(username);
        return ret;
    }
    public void addEvent(Distributor distributor, Event event){
        distributor.addEvent(event);
        repository.update(distributor);
    }
    public void removeEvent(Distributor distributor, Event event){
        distributor.removeEvent(event);
        repository.update(distributor);
    }

}
