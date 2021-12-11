package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.*;
import bg.tuvarna.sit.group5.tickets.data.repositories.EventRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
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

    public void changeDate(Event event, LocalDate date){
        event.setDate(date);
        repository.update(event);
    }

    public void changeTime(Event event, LocalTime time){
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
    public void changeName(Event event, String name){
        event.setName(name);
        repository.update(event);
    }
    public void changeDescription(Event event, String desc){
        event.setDescription(desc);
        repository.update(event);
    }


    public ObservableList<EventModel> getAllEvents() {
        List<Event> events = repository.getAll();

        return FXCollections.observableList(
                events.stream().map(t -> new EventModel(t.getName(),t.getDescription(),t.getDate(),t.getTime(),t.getPlace(),
                        t.getStatus(), t.getEventType(), (Organizer) t.getOrganizer())).collect(Collectors.toList()));
    }
    public void addTickets(Event event, Set<Tickets> tickets){
     event.setTicketsByIdEvent(tickets);
    }
public Event getById(int id){
        Event ret=repository.getById(id);
        return ret;
}
public Event getByName(String name){
    Event ret=repository.getByName(name);
    return ret;
}
    public ObservableList<EventModel> getAllByOrganizer(Organizer org) {
        Set<Event> events = org.getEvents();

        return FXCollections.observableList(
                events.stream().map(t -> new EventModel(t.getName(),t.getDescription(),t.getDate(),t.getTime(),t.getPlace(),
                        t.getStatus(), t.getEventType(), (Organizer) t.getOrganizer())).collect(Collectors.toList()));
    }

    public ObservableList<EventModel> getAllByDistributor(Distributor dist) {
        Set<Event> events = dist.getEventsByDistributor();

        return FXCollections.observableList(
                events.stream().map(t -> new EventModel(t.getName(),t.getDescription(),t.getDate(),t.getTime(),t.getPlace(),
                        t.getStatus(), t.getEventType(), (Organizer) t.getOrganizer())).collect(Collectors.toList()));
    }

    public ObservableList<EventModel> getAllByStatus(Distributor dist, byte status) {
        Set<Event> events = new HashSet<>();
        for(Event e:dist.getEventsByDistributor() ){
            if(e.getStatus()==status){
                events.add(e);
            }
        }

        return FXCollections.observableList(
                events.stream().map(t -> new EventModel(t.getName(),t.getDescription(),t.getDate(),t.getTime(),t.getPlace(),
                        t.getStatus(), t.getEventType(), (Organizer) t.getOrganizer())).collect(Collectors.toList()));
    }

    public Set<Event> getByStatus(Distributor dist, byte status) {
        Set<Event> events = new HashSet<>();
        for (Event e : dist.getEventsByDistributor()) {
            if (e.getStatus() == status) {
                events.add(e);
            }
        }
return events;
    }
    public ObservableList<EventModel> getAllByDates(Organizer org, LocalDate date,LocalDate date2) {
        Set<Event> temp=org.getEvents();
        Set<Event> events=new HashSet<>();
        for(Event e:temp){
            if(e.getDate().compareTo(date)>=0&&e.getDate().compareTo(date2)<=0){
                events.add(e);
            }
        }

        return FXCollections.observableList(
                events.stream().map(t -> new EventModel(t.getName(),t.getDescription(),t.getDate(),t.getTime(),t.getPlace(),
                        t.getStatus(), t.getEventType(), (Organizer) t.getOrganizer())).collect(Collectors.toList()));
    }

    public ObservableList<EventModel> getAllByDateDistributor(Distributor dist, LocalDate date, LocalDate date2){
        Set<Event> temp=dist.getEventsByDistributor();
        Set<Event> events=new HashSet<>();
        for(Event e:temp){
            if(e.getDate().compareTo(date)>=0&&e.getDate().compareTo(date2)<=0){
             events.add(e);
            }
        }

        return FXCollections.observableList(
                events.stream().map(t -> new EventModel(t.getName(),t.getDescription(),t.getDate(),t.getTime(),t.getPlace(),
                        t.getStatus(), t.getEventType(), (Organizer) t.getOrganizer())).collect(Collectors.toList()));

    }

    public Set<Event> getAllByDistOrg(Distributor dist,  Organizer org){
        Set<Event> temp=dist.getEventsByDistributor();
       Set<Event> events=new HashSet<>();
        for(Event e:temp){
      if(e.getOrganizer().getUsername().equals(org.getUsername()))
                events.add(e);

        }

       return events;

    }

}
