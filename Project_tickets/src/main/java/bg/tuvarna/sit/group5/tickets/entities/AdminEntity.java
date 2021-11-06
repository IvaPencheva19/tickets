package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "admin", schema = "tickets_oop")
public class AdminEntity {
    private int idAdmin;
    private int userIdUser;
    private UserEntity userByUserIdUser;
    private Collection<DistributorEntity> distributorsByIdAdmin;
    private Collection<OrganizerEntity> organizersByIdAdmin;

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
        AdminEntity that = (AdminEntity) o;
        return idAdmin == that.idAdmin && userIdUser == that.userIdUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdmin, userIdUser);
    }

    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false)
    public UserEntity getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(UserEntity userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }

    @OneToMany(mappedBy = "admin")
    public Collection<DistributorEntity> getDistributorsByIdAdmin() {
        return distributorsByIdAdmin;
    }

    public void setDistributorsByIdAdmin(Collection<DistributorEntity> distributorsByIdAdmin) {
        this.distributorsByIdAdmin = distributorsByIdAdmin;
    }

    @OneToMany(mappedBy = "admin")
    public Collection<OrganizerEntity> getOrganizersByIdAdmin() {
        return organizersByIdAdmin;
    }

    public void setOrganizersByIdAdmin(Collection<OrganizerEntity> organizersByIdAdmin) {
        this.organizersByIdAdmin = organizersByIdAdmin;
    }
}
