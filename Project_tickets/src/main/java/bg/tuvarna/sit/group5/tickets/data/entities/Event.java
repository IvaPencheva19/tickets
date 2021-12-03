package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "event", schema = "tickets_oop")
public class Event {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvent")
    private int idEvent;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "date")
    private LocalDate date;
    @Basic
    @Column(name = "time")
    private LocalTime time;
    @Basic
    @Column(name = "place")
    private String place;
    @Basic
    @Column(name = "status")
    private Byte status;


    @ManyToMany(mappedBy = "eventsByDistributor",fetch = FetchType.EAGER)
    private Set<Distributor> distribEvent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Event_type_idEvent_type", nullable = false)
    private EventType eventType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_idUser", nullable = false)
    private Organizer organizer;

    @OneToMany(mappedBy = "eventByEventIdEvent",cascade = CascadeType.ALL)
    private Set<Tickets> ticketsByIdEvent=new HashSet<>();

    @OneToMany(mappedBy = "event",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SellTickets> sellTickets=new HashSet<>();



    public Event(){}

    public Event(String name, String desc, LocalDate date, LocalTime time,
                 String place, Byte status, EventType eventType, Organizer organizer) {
        this.name=name;
        this.description=desc;
        this.date = date;
        this.time = time;
        this.place = place;
        this.status = status;
        this.eventType = eventType;
        this.organizer = organizer;
    }


    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

    public Set<Distributor> getDistribEvent() {
        return distribEvent;
    }

    public void setDistribEvent(Set<Distributor> distribEvent) {
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

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }


    public Set<Tickets> getTicketsByIdEvent() {
        return ticketsByIdEvent;
    }

    public void setTicketsByIdEvent(Set<Tickets> ticketsByIdEvent) {
        this.ticketsByIdEvent = ticketsByIdEvent;
    }
    public Set<SellTickets> getSellTickets() {
        return sellTickets;
    }

    public void setSellTickets(Set<SellTickets> sellTickets) {
        this.sellTickets = sellTickets;
    }
    public void addSellTicket(SellTickets ticket){
        sellTickets.add(ticket);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return idEvent == event.idEvent && Objects.equals(name, event.name) && Objects.equals(description, event.description) && Objects.equals(date, event.date) && Objects.equals(time, event.time) && Objects.equals(place, event.place) && Objects.equals(status, event.status) && Objects.equals(distribEvent, event.distribEvent) && Objects.equals(eventType, event.eventType) && Objects.equals(organizer, event.organizer) && Objects.equals(ticketsByIdEvent, event.ticketsByIdEvent);
    }



}
