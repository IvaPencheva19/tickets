package bg.tuvarna.sit.group5.tickets.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotif")
    private int idNotif;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "seen")
    private Byte seen;
    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "user", nullable = false)
    private User userNot;

    public Notifications(){}
    public Notifications(String message, User userNot) {
        this.message = message;
        this.seen = 0;
        this.userNot = userNot;
    }

    public int getIdNotif() {
        return idNotif;
    }

    public void setIdNotif(int idNotif) {
        this.idNotif = idNotif;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Byte getSeen() {
        return seen;
    }

    public void setSeen(Byte seen) {
        this.seen = seen;
    }

    public User getUserNot() {
        return userNot;
    }

    public void setUserNot(User userNot) {
        this.userNot = userNot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notifications that = (Notifications) o;
        return idNotif == that.idNotif && Objects.equals(message, that.message) && Objects.equals(seen, that.seen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotif, message, seen);
    }
}
