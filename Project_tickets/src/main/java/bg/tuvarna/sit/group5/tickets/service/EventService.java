package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.repositories.EventRepository;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;

public class EventService {
    private final EventRepository repository = EventRepository.getInstance();

    public static EventService getInstance() {
        return EventService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final EventService INSTANCE = new EventService();
    }


}
