package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "distributor", schema = "tickets_oop")
public class Distributor {
    private int idDistributor;
    private Double honor;
    private Double rating;
    private int adminIdAdmin;
    private int userIdUser;
    private Set<DistribEvent> distribEvents;
    private Admin admin;
    private User user;

    @Id
    @Column(name = "idDistributor")
    public int getIdDistributor() {
        return idDistributor;
    }

    public void setIdDistributor(int idDistributor) {
        this.idDistributor = idDistributor;
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
    @Column(name = "rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
        Distributor that = (Distributor) o;
        return idDistributor == that.idDistributor && adminIdAdmin == that.adminIdAdmin && userIdUser == that.userIdUser && Objects.equals(honor, that.honor) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistributor, honor, rating, adminIdAdmin, userIdUser);
    }

    @OneToMany(mappedBy = "distributorsEvent")
    public Set<DistribEvent> getDistribEvents() {
        return distribEvents;
    }

    public void setDistribEvents(Set<DistribEvent> distribEvents) {
        this.distribEvents = distribEvents;
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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
