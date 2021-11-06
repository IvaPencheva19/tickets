package bg.tuvarna.sit.group5.tickets.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "tickets_oop")
public class UserEntity {
    private int idUser;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private Collection<AdminEntity> adminsByIdUser;
    private Collection<DistributorEntity> distributorsByIdUser;
    private Collection<OrganizerEntity> organizersByIdUser;

    @Id
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser && Objects.equals(username, that.username)
                && Objects.equals(password, that.password)
                && Objects.equals(firstname, that.firstname)
                && Objects.equals(lastname, that.lastname) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, username, password, firstname, lastname, phone);
    }

    @OneToMany(mappedBy = "userByUserIdUser")
    public Collection<AdminEntity> getAdminsByIdUser() {
        return adminsByIdUser;
    }

    public void setAdminsByIdUser(Collection<AdminEntity> adminsByIdUser) {
        this.adminsByIdUser = adminsByIdUser;
    }

    @OneToMany(mappedBy = "user")
    public Collection<DistributorEntity> getDistributorsByIdUser() {
        return distributorsByIdUser;
    }

    public void setDistributorsByIdUser(Collection<DistributorEntity> distributorsByIdUser) {
        this.distributorsByIdUser = distributorsByIdUser;
    }

    @OneToMany(mappedBy = "userByUserIdUser")
    public Collection<OrganizerEntity> getOrganizersByIdUser() {
        return organizersByIdUser;
    }

    public void setOrganizersByIdUser(Collection<OrganizerEntity> organizersByIdUser) {
        this.organizersByIdUser = organizersByIdUser;
    }
}
