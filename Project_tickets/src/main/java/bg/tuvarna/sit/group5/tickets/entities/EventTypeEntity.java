package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "event_type", schema = "tickets_oop")
public class EventTypeEntity {
    private int idEventType;
    private String typeNamel;
    private Collection<EventEntity> eventsByIdEventType;

    @Id
    @Column(name = "idEvent_type")
    public int getIdEventType() {
        return idEventType;
    }

    public void setIdEventType(int idEventType) {
        this.idEventType = idEventType;
    }

    @Basic
    @Column(name = "type_namel")
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
        EventTypeEntity that = (EventTypeEntity) o;
        return idEventType == that.idEventType && Objects.equals(typeNamel, that.typeNamel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEventType, typeNamel);
    }

    @OneToMany(mappedBy = "eventType")
    public Collection<EventEntity> getEventsByIdEventType() {
        return eventsByIdEventType;
    }

    public void setEventsByIdEventType(Collection<EventEntity> eventsByIdEventType) {
        this.eventsByIdEventType = eventsByIdEventType;
    }
}
