package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "event_type", schema = "tickets_oop")
public class EventType {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvent_type")
    private int idEventType;

    @Basic
    @Column(name = "type_namel")
    private String typeNamel;

    @OneToMany(mappedBy = "eventType",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Event> eventsByIdEventType;

    public EventType(){}

    public EventType(String typeNamel) {
        this.typeNamel = typeNamel;
    }

    public int getIdEventType() {
        return idEventType;
    }

    public void setIdEventType(int idEventType) {
        this.idEventType = idEventType;
    }


    public String getTypeNamel() {
        return typeNamel;
    }

    public void setTypeNamel(String typeNamel) {
        this.typeNamel = typeNamel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventType that = (EventType) o;
        return idEventType == that.idEventType && Objects.equals(typeNamel, that.typeNamel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEventType, typeNamel);
    }


    public Set<Event> getEventsByIdEventType() {
        return eventsByIdEventType;
    }

    public void setEventsByIdEventType(Set<Event> eventsByIdEventType) {
        this.eventsByIdEventType = eventsByIdEventType;
    }
}
