package bg.tuvarna.sit.group5.tickets.service;


import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.repositories.EventTypeRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.stream.Collectors;

public class EventTypeService {
    private final EventTypeRepository repository = EventTypeRepository.getInstance();

    public static EventTypeService getInstance() {
        return EventTypeHolder.INSTANCE;
    }

    private static class EventTypeHolder {
        public static final EventTypeService INSTANCE = new EventTypeService();
    }

    public ObservableList<EventTypeModel> getAll() {
        List<EventType> types = repository.getAll();

        return FXCollections.observableList(
                types.stream().map(t -> new EventTypeModel(t.getTypeNamel())).collect(Collectors.toList()));
    }

    public EventType getEventByName(String name){
        EventType ret= repository.getByName(name);
        return ret;
    }

    public void createEventType(EventType evType){
        repository.save(evType);
    }

    public void deleteEventType(EventType evType){
        repository.delete(evType);
    }

    /*public void addEvent(EventType et, Event event){
        et.addEvent(event);
        repository.update(et);
    }*/

}
