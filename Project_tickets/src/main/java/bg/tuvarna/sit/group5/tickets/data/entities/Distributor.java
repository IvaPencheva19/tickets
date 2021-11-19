package bg.tuvarna.sit.group5.tickets.data.entities;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("distributor")
public class Distributor extends User{
    public Distributor(){}

    public Distributor(String username, String password, String firstname, String lastname,
                       String phone, String email, double honor, double rating) {
        super(username, password, firstname, lastname, phone, email);
        this.honor = honor;
        this.rating = rating;
    }

    @Basic
    @Column(name = "honor")
    private Double honor;
    @Basic
    @Column(name = "rating")
    private Double rating;

    @OneToMany(mappedBy = "distributorsEvent")
    private Set<DistribEvent> eventsByDistributor;

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
}
