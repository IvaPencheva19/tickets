package bg.tuvarna.sit.group5.tickets.data.repositories;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;

import java.util.Date;
import java.util.List;

public interface DAOEvent<T> {
    List<T> getAllEventsByDate(Date date);
    List<T> getAllEventsByPlace(String place);
}
