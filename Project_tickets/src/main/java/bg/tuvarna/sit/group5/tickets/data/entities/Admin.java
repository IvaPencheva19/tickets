package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("admin")
public class Admin extends User{

}
