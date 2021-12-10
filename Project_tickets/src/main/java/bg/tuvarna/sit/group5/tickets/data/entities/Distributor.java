package bg.tuvarna.sit.group5.tickets.data.entities;


import bg.tuvarna.sit.group5.tickets.common.Constants;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import bg.tuvarna.sit.group5.tickets.presentation.controllers.DistributorAccountController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.persistence.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@DiscriminatorValue("distributor")
public class Distributor extends User{


    @Basic
    @Column(name = "honor")
    private Double honor;
    @Basic
    @Column(name = "rating")
    private Double rating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="distrib_event",joinColumns=@JoinColumn(name="user_idUser1"),
    inverseJoinColumns=@JoinColumn(name="event_idEvent"))
    private Set<Event> eventsByDistributor=new HashSet<>();

    @OneToMany(mappedBy = "distrib",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SellTickets> sellTickets;


    public Distributor(){}

    public Distributor(String username, String password, String firstname, String lastname,
                       String phone, String email, double honor, double rating) {
        super(username, password, firstname, lastname, phone, email);
        this.honor = honor;
        this.rating = rating;
    }

    public Double getHonor() {
        return honor;
    }

    public void setHonor(Double honor) {
        this.honor = honor;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<Event> getEventsByDistributor() {
        return eventsByDistributor;
    }

    public void setEventsByDistributor(Set<Event> eventsByDistributor) {
        this.eventsByDistributor = eventsByDistributor;
    }

    public Set<SellTickets> getSellTickets() {
        return sellTickets;
    }

    public void setSellTickets(Set<SellTickets> sellTickets) {
        this.sellTickets = sellTickets;
    }

    public void addEvent(Event event){
        eventsByDistributor.add(event);
    }
    public void addSellTicket(SellTickets ticket){
       sellTickets.add(ticket);
    }
    public void removeEvent(Event event){
        eventsByDistributor.remove(event);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Distributor that = (Distributor) o;
        return Objects.equals(honor, that.honor) && Objects.equals(rating, that.rating) && Objects.equals(eventsByDistributor, that.eventsByDistributor) && Objects.equals(sellTickets, that.sellTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), honor);
    }

    @Override
    public void loadController()
    {
        FXMLLoader loader = OpenForm.openNewForm("DistributorAccountForm.fxml", "Distributor");
        DistributorAccountController next = loader.getController();
        next.setUser(this);
    }
}
