package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class EventModel {
    private String name;
    private String desc;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private Byte status;
    private String stat;
    private String eventType;
    private String orgName;

    public EventModel(String name,String desc,LocalDate date, LocalTime time, String place, Byte status, EventType eventType, Organizer organizer) {
        this.name=name;
        this.desc=desc;
        this.date = date;
        this.time = time;
        this.place = place;
        this.status = status;
        if (status==1){
            this.stat="Active event";
        }
        if (status==0){
            this.stat="Unactive event";
        }

        this.eventType = eventType.getTypeNamel();
        this.orgName = organizer.getUsername();
    }

    public String toString() {
        return  String.format("%s                       %s                     %s   " +
                        "                 %s                     %s                   %s                      %s ",
                name, date, time, place, stat, eventType,orgName);
    }

}
