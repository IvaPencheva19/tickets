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
    @Basic
    @Column(name = "Event_idEvent")
    private int eventIdEvent;
    @ManyToOne
    @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent", nullable = false)
    private Event eventByEventIdEvent;


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


    public int getEventIdEvent() {
        return eventIdEvent;
    }

    public void setEventIdEvent(int eventIdEvent) {
        this.eventIdEvent = eventIdEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets that = (Tickets) o;
        return idTickets == that.idTickets && eventIdEvent == that.eventIdEvent && Objects.equals(type, that.type) && Objects.equals(price, that.price) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTickets, type, price, count, eventIdEvent);
    }


    public Event getEventByEventIdEvent() {
        return eventByEventIdEvent;
    }

    public void setEventByEventIdEvent(Event eventByEventIdEvent) {
        this.eventByEventIdEvent = eventByEventIdEvent;
    }
}
