package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.*;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.DistributorModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.TicketsModel;
import bg.tuvarna.sit.group5.tickets.service.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class AddEventByOrganizerController {
    @FXML
    Label hello;
    @FXML
    ListView distList;
    @FXML
    ComboBox types;
    @FXML
    TextField type;
    @FXML
    TextField price;
    @FXML
    TextField count;
    @FXML
    TextField username;
    @FXML
    DatePicker date;
    @FXML
    TextField time;
    @FXML
    TextField place;
    @FXML
    TextField name;
    @FXML
    TextArea description;
    @FXML
    ListView addedTickets;
    @FXML
    ListView addedDistributors;



    private DistributorService dserv=new DistributorService();
    private EventTypeService eserv=new EventTypeService();
    private EventService evserv=new EventService();

    private TicketsService tserv=new TicketsService();
    private OrganizerService oserv=new OrganizerService();

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }

    public void load(){
        EventTypeService service=new EventTypeService();
        ObservableList<EventTypeModel> allTypes=service.getAll();
        types.setItems(allTypes);

        ObservableList<DistributorModel> distributors=dserv.getAllDistributors();
        distList.setItems(distributors);

    }
    private Set<Tickets> tickets=new HashSet<>();
    private Set<Distributor>distributors=new HashSet<>();

    public void addTicket(){
        String type=this.type.getText();
        Double price=Double.parseDouble(this.price.getText());
        Integer count=Integer.parseInt(this.count.getText());
        Tickets ticket=new Tickets(type,price,count,null);
        ticket.setStartCount(count);
       tickets.add(ticket);
       TicketsModel tModel=new TicketsModel(ticket.getType(),ticket.getPrice(),ticket.getCount(),null);
       addedTickets.getItems().add(tModel);
    }

    public void addDistributor(){
        String username=this.username.getText();
        Distributor dist=dserv.getByUsername(username);
        distributors.add(dist);
        DistributorModel dModel=new DistributorModel(dist.getUsername(),dist.getPassword(),
                dist.getFirstname(),dist.getLastname(),dist.getPhone(),dist.getEmail(),
                dist.getHonor(),dist.getRating());
        addedDistributors.getItems().add(dModel);

    }
    public void addEvent(){
        LocalDate date=this.date.getValue();

        LocalTime ltime=LocalTime.parse(this.time.getText());
        ltime=ltime.plusHours(2);
        String place=this.place.getText();
        String name=this.name.getText();
        String desc=this.description.getText();
        String type= this.types.getValue().toString();
        EventType evType= eserv.getEventByName(type);
        Event toAdd=new Event(name,desc,date,ltime,place, (byte) 1,evType,(Organizer)HelloController.user);


        for (Tickets t:tickets) {
            t.setEventByEventIdEvent(toAdd);
        }


        toAdd.setTicketsByIdEvent(tickets);
        //toAdd.setDistribEvent(distributors);
        String evname=toAdd.getName();
        evserv.createEvent(toAdd);

        for(Distributor d:distributors){
            dserv.addEvent(d,toAdd);
        }

         tickets.clear();
        distributors.clear();
    }

}
