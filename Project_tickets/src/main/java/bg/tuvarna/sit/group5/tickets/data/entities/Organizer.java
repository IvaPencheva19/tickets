package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("organizer")
public class Organizer extends User{
    @Basic
    @Column(name = "honor")
    private String honor;

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }




}
