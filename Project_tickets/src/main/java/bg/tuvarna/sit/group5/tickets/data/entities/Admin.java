package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("admin")
public class Admin extends User{
    public Admin(){}

    public Admin(String username, String password, String firstname, String lastname, String phone, String email) {
        super(username, password, firstname, lastname, phone, email);
    }
}
