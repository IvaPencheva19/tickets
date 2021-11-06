package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "organizer", schema = "tickets_oop")
public class OrganizerEntity {
    private int idOrganizer;
    private Double honor;
    private int adminIdAdmin;
    private int userIdUser;
    private Collection<EventEntity> eventsByIdOrganizer;
    private AdminEntity admin;
    private UserEntity userByUserIdUser;

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
        OrganizerEntity that = (OrganizerEntity) o;
        return idOrganizer == that.idOrganizer && adminIdAdmin == that.adminIdAdmin && userIdUser == that.userIdUser && Objects.equals(honor, that.honor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrganizer, honor, adminIdAdmin, userIdUser);
    }

    @OneToMany(mappedBy = "organizer")
    public Collection<EventEntity> getEventsByIdOrganizer() {
        return eventsByIdOrganizer;
    }

    public void setEventsByIdOrganizer(Collection<EventEntity> eventsByIdOrganizer) {
        this.eventsByIdOrganizer = eventsByIdOrganizer;
    }

    @ManyToOne
    @JoinColumn(name = "Admin_idAdmin", referencedColumnName = "idAdmin", nullable = false)
    public AdminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }

    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false)
    public UserEntity getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(UserEntity userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }
}
