package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.*;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.TicketsModel;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.SellTicketsService;
import bg.tuvarna.sit.group5.tickets.service.TicketsService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Set;

public class SellTicketController {
    @FXML
    private Label hello;
    @FXML
    private ListView listEvents;
    @FXML
    private ListView listTickets;

    @FXML
    private TextField evname;
    @FXML
    private Label lticks;

    @FXML
    private Label lcusname;
    @FXML
    private TextField cusname;
    @FXML
    private Label lticktype;
    @FXML
    private ComboBox ticktype;
    @FXML
    private Label lcount;
    @FXML
    private TextField tcount;
    @FXML
    private Button buyTickets;

    private Event event;


    private EventService service = new EventService();
    private TicketsService tService = new TicketsService();
    private SellTicketsService stServ = new SellTicketsService();
    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }

    public void load() {

        ObservableList<EventModel> events = service.getAllByStatus((Distributor)HelloController.user,(byte) 1);
        listEvents.setItems(events);
    }

    public void checkTickets(){
        String name = evname.getText();
        event = service.getByName(name);
        Set<Tickets> tick = event.getTicketsByIdEvent();
        int br=0;
        for(Tickets t : tick){
            br=br+t.getCount();
        }
        if(br==0){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("No available tickets!");
            a.show();

        }
        else{
            lcusname.setVisible(true);
            cusname.setVisible(true);
            lticktype.setVisible(true);
            ticktype.setVisible(true);
            lcount.setVisible(true);
            tcount.setVisible(true);
            buyTickets.setVisible(true);
            listTickets.setVisible(true);
            for(Tickets t: tick){
                ticktype.getItems().addAll(t.getType());
            }
            ObservableList<TicketsModel> ticks = tService.getAllTicketsByEvent(event);
            listTickets.setItems(ticks);
        }
    }

    public void buyTickets(){
        String cname = cusname.getText();
        Integer count = Integer.parseInt(this.tcount.getText());
        String type = ticktype.getValue().toString();
        Tickets tick = tService.getByType(type,event);
        if(tick.getCount()<count){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Not enough tickets of this type! Only "+tick.getCount()+ " left!");
            a.show();
        }
        else{
        tService.changeCount(tick, tick.getCount()-count);
        SellTickets tickets = new SellTickets(count, cname, tick, (Distributor) HelloController.user, event);
        stServ.createSellTickets(tickets);
        }
        evname.clear();
        cusname.clear();
        tcount.clear();

    }
}
