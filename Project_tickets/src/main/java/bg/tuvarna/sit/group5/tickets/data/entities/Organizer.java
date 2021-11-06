package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "organizer", schema = "tickets_oop")
public class Organizer {
    private int idOrganizer;
    private Double honor;
    private int adminIdAdmin;
    private int userIdUser;
    private Set<Event> eventsByIdOrganizer;
    private Admin admin;
    private User userByUserIdUser;

    @Id
    @Column(name = "idOrganizer")
    public int getIdOrganizer() {
        return idOrganizer;
    }

    public void setIdOrganizer(int idOrganizer) {
        this.idOrganizer = idOrganizer;
    }

    @Basic
    @Column(name = "honor")
    public Double getHonor() {
        return honor;
    }

    public void setHonor(Double honor) {
        this.honor = honor;
    }

    @Basic
    @Column(name = "Admin_idAdmin")
    public int getAdminIdAdmin() {
        return adminIdAdmin;
    }

    public void setAdminIdAdmin(int adminIdAdmin) {
        this.adminIdAdmin = adminIdAdmin;
    }

    @Basic
    @Column(name = "User_idUser")
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizer that = (Organizer) o;
        return idOrganizer == that.idOrganizer && adminIdAdmin == that.adminIdAdmin && userIdUser == that.userIdUser && Objects.equals(honor, that.honor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrganizer, honor, adminIdAdmin, userIdUser);
    }

    @OneToMany(mappedBy = "organizer")
    public Set<Event> getEventsByIdOrganizer() {
        return eventsByIdOrganizer;
    }

    public void setEventsByIdOrganizer(Set<Event> eventsByIdOrganizer) {
        this.eventsByIdOrganizer = eventsByIdOrganizer;
    }

    @ManyToOne
    @JoinColumn(name = "Admin_idAdmin", referencedColumnName = "idAdmin", nullable = false)
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false)
    public User getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(User userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }
}
