package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;

import java.util.Date;
import java.util.List;

public interface DAOEvent<T> {
    List<T> getAllEventsByDate(Organizer org, Date date);
    List<T> getAllEventsByPlace(Organizer org,String place);
}
