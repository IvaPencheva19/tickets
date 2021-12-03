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
    @Column(name = "seat")
    private Integer seat;
    @Basic
    @Column(name = "custumer_name")
    private String custumer_name;
    @ManyToOne
    @JoinColumn(name="tickets_idTickets")
    private Tickets ticket_type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_idUser", nullable = false)
    private Distributor distrib;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_idEvent", nullable = false)
    private Event event;

    public SellTickets(){}

    public SellTickets(Integer count, Integer seat, String custumer_name,
                       Tickets ticket_type, Distributor distribEvent) {
        this.count = count;
        this.seat = seat;
        this.custumer_name = custumer_name;
        this.ticket_type = ticket_type;
        this.distrib = distribEvent;
    }


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

    public Distributor getDistributor() {
        return distrib;
    }

    public void setDistribEvent(Distributor distribEvent) {
        this.distrib = distribEvent;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public String getCustumer_name() {
        return custumer_name;
    }

    public void setCustumer_name(String custumer_name) {
        this.custumer_name = custumer_name;
    }

    public Tickets getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(Tickets ticket_type) {
        this.ticket_type = ticket_type;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Distributor getDistrib() {
        return distrib;
    }

    public void setDistrib(Distributor distrib) {
        this.distrib = distrib;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellTickets that = (SellTickets) o;
        return idSell == that.idSell && Objects.equals(count, that.count) && Objects.equals(seat, that.seat) && Objects.equals(custumer_name, that.custumer_name) && Objects.equals(ticket_type, that.ticket_type) && Objects.equals(distrib, that.distrib) && Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSell, count, seat, custumer_name, ticket_type, distrib, event);
    }
}

