package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.repositories.EventTypeRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
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
    public ObservableList<EventTypeModel> getType() {
        List<EventType> types=new LinkedList<>();

    types.add(repository.getById(1));
        return FXCollections.observableList(
                types.stream().map(t -> new EventTypeModel(t.getTypeNamel())).collect(Collectors.toList()));
    }
}
