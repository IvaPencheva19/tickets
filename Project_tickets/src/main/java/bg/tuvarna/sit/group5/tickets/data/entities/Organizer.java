package bg.tuvarna.sit.group5.tickets.data.entities;

import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import bg.tuvarna.sit.group5.tickets.presentation.controllers.HelloController;
import bg.tuvarna.sit.group5.tickets.presentation.controllers.OrganizerAccountController;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.UserService;
import javafx.fxml.FXMLLoader;

import javax.persistence.*;
import java.util.*;


@Entity
@DiscriminatorValue("organizer")
public class Organizer extends User{



    @Basic
    @Column(name = "honor")
    private Double honor;

    @OneToMany(mappedBy = "organizer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events=new HashSet<>();



    public Organizer() {}

    public Organizer(String username, String password, String firstname, String lastname,
                     String phone, String email, double honor) {
        super(username, password, firstname, lastname, phone, email);
        this.honor = honor;
    }


    public Double getHonor() {
        return honor;
    }

    public void setHonor(Double honor) {
        this.honor = honor;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
    public void addEvent(Event event){
        events.add(event);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Organizer other = (Organizer)o;
        return Objects.equals(getIdUser(), other.getIdUser());
    }


    @Override
    public void loadController()
    {
        FXMLLoader loader = OpenForm.openNewForm("OrganizerAccountForm.fxml", "Organizer");
        OrganizerAccountController next = loader.getController();
        next.setUser(this);
        UserService userv=UserService.getInstance();
        if(!(userv.isAllSeen(HelloController.user))){
            next.setIcon(true);
        }
        EventService eserv=EventService.getInstance();
        eserv.makeUnactiveEvents();
        eserv.makeNotifEvent();
    }
}
