package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "distrib_event", schema = "tickets_oop")
public class DistribEventEntity {
    private int idDistEvent;
    private int eventIdEvent1;
    private int distributorIdDistributor1;
    private EventEntity event;
    private DistributorEntity distributorsEvent;
    private Collection<SellTicketsEntity> sellTicketsByIdDistEvent;

    @Id
    @Column(name = "idDistEvent")
    public int getIdDistEvent() {
        return idDistEvent;
    }

    public void setIdDistEvent(int idDistEvent) {
        this.idDistEvent = idDistEvent;
    }

    @Basic
    @Column(name = "Event_idEvent1")
    public int getEventIdEvent1() {
        return eventIdEvent1;
    }

    public void setEventIdEvent1(int eventIdEvent1) {
        this.eventIdEvent1 = eventIdEvent1;
    }

    @Basic
    @Column(name = "Distributor_idDistributor1")
    public int getDistributorIdDistributor1() {
        return distributorIdDistributor1;
    }

    public void setDistributorIdDistributor1(int distributorIdDistributor1) {
        this.distributorIdDistributor1 = distributorIdDistributor1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistribEventEntity that = (DistribEventEntity) o;
        return idDistEvent == that.idDistEvent && eventIdEvent1 == that.eventIdEvent1 && distributorIdDistributor1 == that.distributorIdDistributor1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistEvent, eventIdEvent1, distributorIdDistributor1);
    }

    @ManyToOne
    @JoinColumn(name = "Event_idEvent1", referencedColumnName = "idEvent", nullable = false)
    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }

    @ManyToOne
    @JoinColumn(name = "Distributor_idDistributor1", referencedColumnName = "idDistributor", nullable = false)
    public DistributorEntity getDistributorsEvent() {
        return distributorsEvent;
    }

    public void setDistributorsEvent(DistributorEntity distributorsEvent) {
        this.distributorsEvent = distributorsEvent;
    }

    @OneToMany(mappedBy = "distribEvent")
    public Collection<SellTicketsEntity> getSellTicketsByIdDistEvent() {
        return sellTicketsByIdDistEvent;
    }

    public void setSellTicketsByIdDistEvent(Collection<SellTicketsEntity> sellTicketsByIdDistEvent) {
        this.sellTicketsByIdDistEvent = sellTicketsByIdDistEvent;
    }
}
