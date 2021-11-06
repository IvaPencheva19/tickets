package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sell_tickets", schema = "tickets_oop")
public class SellTicketsEntity {
    private int idSell;
    private Integer count;
    private int distribEventIdDistEvent;
    private DistribEventEntity distribEvent;

    @Id
    @Column(name = "idSell")
    public int getIdSell() {
        return idSell;
    }

    public void setIdSell(int idSell) {
        this.idSell = idSell;
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
    @Column(name = "Distrib_event_idDistEvent")
    public int getDistribEventIdDistEvent() {
        return distribEventIdDistEvent;
    }

    public void setDistribEventIdDistEvent(int distribEventIdDistEvent) {
        this.distribEventIdDistEvent = distribEventIdDistEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellTicketsEntity that = (SellTicketsEntity) o;
        return idSell == that.idSell && distribEventIdDistEvent == that.distribEventIdDistEvent && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSell, count, distribEventIdDistEvent);
    }

    @ManyToOne
    @JoinColumn(name = "Distrib_event_idDistEvent", referencedColumnName = "idDistEvent", nullable = false)
    public DistribEventEntity getDistribEvent() {
        return distribEvent;
    }

    public void setDistribEvent(DistribEventEntity distribEvent) {
        this.distribEvent = distribEvent;
    }
}
