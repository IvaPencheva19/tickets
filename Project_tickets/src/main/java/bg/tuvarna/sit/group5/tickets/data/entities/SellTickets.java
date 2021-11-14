package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sell_tickets", schema = "tickets_oop")
public class SellTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSell")
    private int idSell;
    @Basic
    @Column(name = "count")
    private Integer count;
    @Basic
    @Column(name = "Distrib_event_idDistEvent")
    private int distribEventIdDistEvent;
    @ManyToOne
    @JoinColumn(name = "Distrib_event_idDistEvent", referencedColumnName = "idDistEvent", nullable = false)
    private DistribEvent distribEvent;


    public int getIdSell() {
        return idSell;
    }

    public void setIdSell(int idSell) {
        this.idSell = idSell;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


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
        SellTickets that = (SellTickets) o;
        return idSell == that.idSell && distribEventIdDistEvent == that.distribEventIdDistEvent && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSell, count, distribEventIdDistEvent);
    }


    public DistribEvent getDistribEvent() {
        return distribEvent;
    }

    public void setDistribEvent(DistribEvent distribEvent) {
        this.distribEvent = distribEvent;
    }
}
