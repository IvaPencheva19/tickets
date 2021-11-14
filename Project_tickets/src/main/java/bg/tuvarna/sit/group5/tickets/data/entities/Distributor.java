package bg.tuvarna.sit.group5.tickets.data.entities;


import javax.persistence.*;
@Entity
@DiscriminatorValue("distributor")
public class Distributor extends User{
    @Basic
    @Column(name = "honor")
    private String honor;
    @Basic
    @Column(name = "rating")
    private String rating;

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
