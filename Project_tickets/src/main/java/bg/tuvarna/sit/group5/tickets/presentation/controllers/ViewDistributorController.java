package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.SellTickets;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.SellTicketsModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.util.Set;


public class ViewDistributorController {
    @FXML
    private Label hello;
    @FXML
    private TextField userDist;
    @FXML
    private ComboBox comboEvents;
    @FXML
    private Label username;
    @FXML
    private Label fname;
    @FXML
    private Label lname;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label honor;
    @FXML
    private Label rating;
    @FXML
    private Pane infoPane;
    @FXML
    private Pane infoPaneEv;
    @FXML
    private DatePicker dateFrom;
    @FXML
    private DatePicker dateTo;
    @FXML
    private ListView soldList;


    private DistributorService distServ =  new DistributorService();
    private EventService eServ = new EventService();
    private Distributor dist;


    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }

    public void show(){
        infoPane.setDisable(false);
        infoPaneEv.setDisable(false);
        String usedist = userDist.getText();
        dist=distServ.getByUsername(usedist);
        username.setText(dist.getUsername());
        fname.setText(dist.getFirstname());
        lname.setText(dist.getLastname());
        phone.setText(dist.getPhone());
        email.setText(dist.getEmail());
        honor.setText(dist.getHonor().toString());
        rating.setText(dist.getRating().toString());
        loadCombo();
    }

    public void search(){


        String evName=comboEvents.getValue().toString();
        Event ret=eServ.getByName(evName);
        Set<SellTickets> tsell=ret.getSellTickets();
        for(SellTickets ts:tsell){
            SellTicketsModel sells=new SellTicketsModel(ts.getCount(),ts.getCustumer_name(),ts.getTicket_type());
            soldList.getItems().addAll(sells);
        }
    }

    public void loadCombo(){
        Set<Event> events = eServ.getAllByDistOrg(dist, (Organizer) HelloController.user);
        for(Event e: events){
            comboEvents.getItems().addAll(e.getName());
        }





    }


}
