package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "event", schema = "tickets_oop")
public class EventEntity {
    private int idEvent;
    private Date date;
    private Time time;
    private String place;
    private Byte status;
    private int eventTypeIdEventType;
    private int organizerIdOrganizer;
    private Collection<DistribEventEntity> distribEvent;
    private EventTypeEntity eventType;
    private OrganizerEntity organizer;
    private Collection<TicketsEntity> ticketsByIdEvent;

    @Id
    @Column(name = "idEvent")
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @Column(name = "place")
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Event_type_idEvent_type")
    public int getEventTypeIdEventType() {
        return eventTypeIdEventType;
    }

    public void setEventTypeIdEventType(int eventTypeIdEventType) {
        this.eventTypeIdEventType = eventTypeIdEventType;
    }

    @Basic
    @Column(name = "Organizer_idOrganizer")
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
        EventEntity that = (EventEntity) o;
        return idEvent == that.idEvent && eventTypeIdEventType == that.eventTypeIdEventType && organizerIdOrganizer == that.organizerIdOrganizer && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(place, that.place) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, date, time, place, status, eventTypeIdEventType, organizerIdOrganizer);
    }

    @OneToMany(mappedBy = "event")
    public Collection<DistribEventEntity> getDistribEvent() {
        return distribEvent;
    }

    public void setDistribEvent(Collection<DistribEventEntity> distribEvent) {
        this.distribEvent = distribEvent;
    }

    @ManyToOne
    @JoinColumn(name = "Event_type_idEvent_type", referencedColumnName = "idEvent_type", nullable = false)
    public EventTypeEntity getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEntity eventType) {
        this.eventType = eventType;
    }

    @ManyToOne
    @JoinColumn(name = "Organizer_idOrganizer", referencedColumnName = "idOrganizer", nullable = false)
    public OrganizerEntity getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerEntity organizer) {
        this.organizer = organizer;
    }

    @OneToMany(mappedBy = "eventByEventIdEvent")
    public Collection<TicketsEntity> getTicketsByIdEvent() {
        return ticketsByIdEvent;
    }

    public void setTicketsByIdEvent(Collection<TicketsEntity> ticketsByIdEvent) {
        this.ticketsByIdEvent = ticketsByIdEvent;
    }
}
