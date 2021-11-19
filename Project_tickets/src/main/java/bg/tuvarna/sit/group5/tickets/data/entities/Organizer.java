package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("organizer")
public class Organizer extends User{

    public Organizer() {}

    public Organizer(String username, String password, String firstname, String lastname,
                     String phone, String email, double honor) {
        super(username, password, firstname, lastname, phone, email);
        this.honor = honor;
    }

    @Basic
    @Column(name = "honor")
    private Double honor;

    @OneToMany(mappedBy = "organizer")
    private Set<Event> events;


    public Double getHonor() {
        return honor;
    }

    public void setHonor(Double honor) {
        this.honor = honor;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Organizer organizer = (Organizer) o;
        return Objects.equals(honor, organizer.honor) && Objects.equals(events, organizer.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), honor, events);
    }
}
