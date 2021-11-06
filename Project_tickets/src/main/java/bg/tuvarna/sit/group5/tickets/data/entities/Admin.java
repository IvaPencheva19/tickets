package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "admin", schema = "tickets_oop")
public class Admin {
    private int idAdmin;
    private int userIdUser;
    private User userByUserIdUser;
    private Set<Distributor> distributorsByIdAdmin;
    private Set<Organizer> organizersByIdAdmin;

    @Id
    @Column(name = "idAdmin")
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
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
        Admin that = (Admin) o;
        return idAdmin == that.idAdmin && userIdUser == that.userIdUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdmin, userIdUser);
    }

    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false)
    public User getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(User userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }

    @OneToMany(mappedBy = "admin")
    public Set<Distributor> getDistributorsByIdAdmin() {
        return distributorsByIdAdmin;
    }

    public void setDistributorsByIdAdmin(Set<Distributor> distributorsByIdAdmin) {
        this.distributorsByIdAdmin = distributorsByIdAdmin;
    }

    @OneToMany(mappedBy = "admin")
    public Set<Organizer> getOrganizersByIdAdmin() {
        return organizersByIdAdmin;
    }

    public void setOrganizersByIdAdmin(Set<Organizer> organizersByIdAdmin) {
        this.organizersByIdAdmin = organizersByIdAdmin;
    }
}
