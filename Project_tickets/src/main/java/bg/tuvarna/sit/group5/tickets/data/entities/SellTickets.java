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

    @ManyToOne
    @JoinColumn(name = "Distrib_event_idDistEvent", nullable = false)
    private DistribEvent distribEvent;


    public int getIdSell() {
        return idSell;
    }

    public void setIdSell(Integer idSell) {
        this.idSell = idSell;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DistribEvent getDistribEvent() {
        return distribEvent;
    }

    public void setDistribEvent(DistribEvent distribEvent) {
        this.distribEvent = distribEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellTickets that = (SellTickets) o;
        return idSell == that.idSell && Objects.equals(count, that.count) && Objects.equals(distribEvent, that.distribEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSell, count, distribEvent);
    }
}
