package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "distributor", schema = "tickets_oop")
public class DistributorEntity {
    private int idDistributor;
    private Double honor;
    private Double rating;
    private int adminIdAdmin;
    private int userIdUser;
    private Collection<DistribEventEntity> distribEvents;
    private AdminEntity admin;
    private UserEntity user;

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
        DistributorEntity that = (DistributorEntity) o;
        return idDistributor == that.idDistributor && adminIdAdmin == that.adminIdAdmin && userIdUser == that.userIdUser && Objects.equals(honor, that.honor) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistributor, honor, rating, adminIdAdmin, userIdUser);
    }

    @OneToMany(mappedBy = "distributorsEvent")
    public Collection<DistribEventEntity> getDistribEvents() {
        return distribEvents;
    }

    public void setDistribEvents(Collection<DistribEventEntity> distribEvents) {
        this.distribEvents = distribEvents;
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
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
