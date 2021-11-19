package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;
import bg.tuvarna.sit.group5.tickets.data.repositories.EventRepository;
import bg.tuvarna.sit.group5.tickets.data.repositories.TicketsRepository;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.TicketsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TicketsService {
    private final TicketsRepository repository = TicketsRepository.getInstance();

    public static TicketsService getInstance() {
        return TicketsService.TicketsHolder.INSTANCE;
    }

    private static class TicketsHolder {
        public static final TicketsService INSTANCE = new TicketsService();
    }

    public void createTickets(Tickets tickets){
        repository.save(tickets);
    }

    public void deleteEvent(Tickets tickets){
        repository.delete(tickets);
    }

    public void changeType(Tickets tickets, String type){
        tickets.setType(type);
        repository.update(tickets);
    }

    public void changePrice(Tickets tickets, double price){
        tickets.setPrice(price);
        repository.update(tickets);
    }

    public void changeCount(Tickets tickets, int count){
        tickets.setCount(count);
        repository.update(tickets);
    }

    public void changeEvent(Tickets tickets, Event event){
        tickets.setEventByEventIdEvent(event);
        repository.update(tickets);
    }

    public ObservableList<TicketsModel> getAllEvents() {
        List<Tickets> tickets = repository.getAll();

        return FXCollections.observableList(
                tickets.stream().map(t -> new TicketsModel(t.getType(),t.getPrice(),t.getCount(),
                        t.getEventByEventIdEvent())).collect(Collectors.toList()));
    }


}
