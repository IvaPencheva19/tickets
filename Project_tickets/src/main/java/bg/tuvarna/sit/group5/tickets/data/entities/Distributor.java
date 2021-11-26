package bg.tuvarna.sit.group5.tickets.data.entities;


import bg.tuvarna.sit.group5.tickets.common.Constants;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import bg.tuvarna.sit.group5.tickets.presentation.controllers.DistributorAccountController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.persistence.*;
import java.net.URL;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("distributor")
public class Distributor extends User{


    @Basic
    @Column(name = "honor")
    private Double honor;
    @Basic
    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "distributorsEvent",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DistribEvent> eventsByDistributor;

    public Distributor(){}

    public Distributor(String username, String password, String firstname, String lastname,
                       String phone, String email, double honor, double rating) {
        super(username, password, firstname, lastname, phone, email);
        this.honor = honor;
        this.rating = rating;
    }

    public double getHonor() {
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

    public Set<DistribEvent> getEventsByDistributor() {
        return eventsByDistributor;
    }

    public void setEventsByDistributor(Set<DistribEvent> eventsByDistributor) {
        this.eventsByDistributor = eventsByDistributor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Distributor that = (Distributor) o;
        return Objects.equals(honor, that.honor) && Objects.equals(rating, that.rating) && Objects.equals(eventsByDistributor, that.eventsByDistributor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), honor, rating, eventsByDistributor);
    }

    @Override
    public void loadController()
    {
        FXMLLoader loader = OpenForm.openNewForm("DistributorAccountForm.fxml", "Distributor");
        DistributorAccountController next = loader.getController();
        next.setUser(this);
    }
}
