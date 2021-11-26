package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "distrib_event", schema = "tickets_oop")
public class DistribEvent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDistEvent")
    private int idDistEvent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Event_idEvent1", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "User_idUser", nullable = false)
    private Distributor distributorsEvent;

    @OneToMany(mappedBy = "distribEvent",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SellTickets> sellTicketsByIdDistEvent;

    public DistribEvent(){}

    public DistribEvent(Event event, Distributor distributorsEvent) {
        this.event = event;
        this.distributorsEvent = distributorsEvent;
    }

    public int getIdDistEvent() {
        return idDistEvent;
    }

    public void setIdDistEvent(int idDistEvent) {
        this.idDistEvent = idDistEvent;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public User getDistributorsEvent() {
        return distributorsEvent;
    }

    public void setDistributorsEvent(Distributor distributorsEvent) {
        this.distributorsEvent = distributorsEvent;
    }


    public Set<SellTickets> getSellTicketsByIdDistEvent() {
        return sellTicketsByIdDistEvent;
    }

    public void setSellTicketsByIdDistEvent(Set<SellTickets> sellTicketsByIdDistEvent) {
        this.sellTicketsByIdDistEvent = sellTicketsByIdDistEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistribEvent that = (DistribEvent) o;
        return idDistEvent == that.idDistEvent && Objects.equals(event, that.event) && Objects.equals(distributorsEvent, that.distributorsEvent) && Objects.equals(sellTicketsByIdDistEvent, that.sellTicketsByIdDistEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistEvent, event, distributorsEvent, sellTicketsByIdDistEvent);
    }
}
