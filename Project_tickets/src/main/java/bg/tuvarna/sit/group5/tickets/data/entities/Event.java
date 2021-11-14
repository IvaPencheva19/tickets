package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "event", schema = "tickets_oop")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvent")
    private int idEvent;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "time")
    private Time time;
    @Basic
    @Column(name = "place")
    private String place;
    @Basic
    @Column(name = "status")
    private Byte status;
    @Basic
    @Column(name = "Event_type_idEvent_type")
    private int eventTypeIdEventType;
    @Basic
    @Column(name = "User_idUser")
    private int organizerIdOrganizer;
    @OneToMany(mappedBy = "event")
    private Set<DistribEvent> distribEvent;
    @ManyToOne
    @JoinColumn(name = "Event_type_idEvent_type", referencedColumnName = "idEvent_type", nullable = false)
    private EventType eventType;
    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false)
    private User organizer;
    @OneToMany(mappedBy = "eventByEventIdEvent")
    private Set<Tickets> ticketsByIdEvent;


    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }


    public int getEventTypeIdEventType() {
        return eventTypeIdEventType;
    }

    public void setEventTypeIdEventType(int eventTypeIdEventType) {
        this.eventTypeIdEventType = eventTypeIdEventType;
    }


    public int getOrganizerIdOrganizer() {
        return organizerIdOrganizer;
    }

    public void setOrganizerIdOrganizer(int organizerIdOrganizer) {
        this.organizerIdOrganizer = organizerIdOrganizer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event that = (Event) o;
        return idEvent == that.idEvent && eventTypeIdEventType == that.eventTypeIdEventType && organizerIdOrganizer == that.organizerIdOrganizer && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(place, that.place) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, date, time, place, status, eventTypeIdEventType, organizerIdOrganizer);
    }


    public Set<DistribEvent> getDistribEvent() {
        return distribEvent;
    }

    public void setDistribEvent(Set<DistribEvent> distribEvent) {
        this.distribEvent = distribEvent;
    }


    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }


    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }


    public Set<Tickets> getTicketsByIdEvent() {
        return ticketsByIdEvent;
    }

    public void setTicketsByIdEvent(Set<Tickets> ticketsByIdEvent) {
        this.ticketsByIdEvent = ticketsByIdEvent;
    }
}
