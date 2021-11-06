package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tickets", schema = "tickets_oop")
public class TicketsEntity {
    private int idTickets;
    private String type;
    private Double price;
    private Integer count;
    private int eventIdEvent;
    private EventEntity eventByEventIdEvent;

    @Id
    @Column(name = "idTickets")
    public int getIdTickets() {
        return idTickets;
    }

    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "Event_idEvent")
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
        TicketsEntity that = (TicketsEntity) o;
        return idTickets == that.idTickets && eventIdEvent == that.eventIdEvent && Objects.equals(type, that.type) && Objects.equals(price, that.price) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTickets, type, price, count, eventIdEvent);
    }

    @ManyToOne
    @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent", nullable = false)
    public EventEntity getEventByEventIdEvent() {
        return eventByEventIdEvent;
    }

    public void setEventByEventIdEvent(EventEntity eventByEventIdEvent) {
        this.eventByEventIdEvent = eventByEventIdEvent;
    }
}
