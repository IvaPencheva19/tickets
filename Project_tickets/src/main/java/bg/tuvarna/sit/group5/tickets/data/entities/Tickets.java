package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tickets", schema = "tickets_oop")
public class Tickets {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTickets")
    private int idTickets;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "count")
    private Integer count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Event_idEvent", nullable = false)
    private Event eventByEventIdEvent;
    @Basic
    @Column(name = "startCount")
    private Integer startCount;

    public Tickets(){}

    public Tickets(String type, Double price, Integer count,Event event) {
        this.type = type;
        this.price = price;
        this.count = count;
        this.eventByEventIdEvent=event;
        this.startCount=count;

    }

    public int getIdTickets() {
        return idTickets;
    }

    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Event getEventByEventIdEvent() {
        return eventByEventIdEvent;
    }

    public void setEventByEventIdEvent(Event eventByEventIdEvent) {
        this.eventByEventIdEvent = eventByEventIdEvent;
    }

    public Integer getStartCount() {
        return startCount;
    }

    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Tickets other = (Tickets)o;
        return Objects.equals(idTickets, other.getIdTickets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTickets, type, price, count, eventByEventIdEvent, startCount);
    }
}
