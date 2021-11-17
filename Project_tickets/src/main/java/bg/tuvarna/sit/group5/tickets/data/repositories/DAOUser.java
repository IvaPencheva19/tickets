package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.User;

import java.util.List;

public interface DAOUser {
    User getByUsername(String uname);
    List<Distributor> getAllDistributors();
    List<Organizer> getAllOrganizers();

}
