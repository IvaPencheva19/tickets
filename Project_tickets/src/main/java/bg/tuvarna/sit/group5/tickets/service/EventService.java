package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.repositories.EventRepository;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.OrganizerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

public class EventService {
    private final EventRepository repository = EventRepository.getInstance();

    public static EventService getInstance() {
        return EventService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final EventService INSTANCE = new EventService();
    }

    public void createEvent(Event event){
        repository.save(event);
    }

    public void deleteEvent(Event event){
        repository.delete(event);
    }

    public void changeDate(Event event, Date date){
        event.setDate(date);
        repository.update(event);
    }

    public void changeTime(Event event, Time time){
        event.setTime(time);
        repository.update(event);
    }

    public void changePlace(Event event, String place){
        event.setPlace(place);
        repository.update(event);
    }

    public void changeStatus(Event event, Byte status){
        event.setStatus(status);
        repository.update(event);
    }
    public void changeType(Event event, EventType eType){
        event.setEventType(eType);
        repository.update(event);
    }
    public void changeOrganizer(Event event, Organizer organizer){
        event.setOrganizer(organizer);
        repository.update(event);
    }
//da napravim set-ovete


    public ObservableList<EventModel> getAllEvents() {
        List<Event> events = repository.getAll();

        return FXCollections.observableList(
                events.stream().map(t -> new EventModel(t.getDate(),t.getTime(),t.getPlace(),
                        t.getStatus(), t.getEventType(), (Organizer) t.getOrganizer())).collect(Collectors.toList()));
    }


}
