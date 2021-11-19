package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;

import java.sql.Time;
import java.util.Date;

public class EventModel {
    private Date date;
    private Time time;
    private String place;
    private Byte status;
    private EventType eventType;
    private Organizer organizer;

    public EventModel(Date date, Time time, String place, Byte status, EventType eventType, Organizer organizer) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.status = status;
        this.eventType = eventType;
        this.organizer = organizer;
    }

    public String toString() {
        return  String.format("%s %s %s %s %s %s ",date, time,
                place, status, eventType,organizer);
    }

}
