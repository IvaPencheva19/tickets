package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.*;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Set;

public class RatingDistributorController {
    @FXML
    private Label hello;

    @FXML
    private Label countActive;

    @FXML
    private Label countSold;

    @FXML
    private Label lrating;




    private EventService eventService = new EventService();

    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }

    public void load(){
        ObservableList <EventModel> events= eventService.getAllByStatus((Distributor)HelloController.user, (byte) 1);
        Integer evcount=events.size();
        countActive.setText(evcount.toString());

        Integer countsold=0;
        for(SellTickets s: ((Distributor) HelloController.user).getSellTickets()){
            if((s.getEvent()).getStatus()==1){
                countsold+=s.getCount();
            }
        }
        countSold.setText(countsold.toString());

        Double rating;
        Integer limit=0;
        Set<Event> evs=eventService.getByStatus((Distributor)HelloController.user, (byte) 1);
    for (Event ev:evs){
        for (Tickets t:ev.getTicketsByIdEvent()){
            limit+=t.getStartCount()/(ev.getDistribEvent().size());
        }
     }

    rating=(((double)countsold/(double)limit)*100);
   

        BigDecimal bd = new BigDecimal(rating).setScale(2, RoundingMode.HALF_UP);
        rating=bd.doubleValue();
        lrating.setText(rating.toString());
        DistributorService dis=new DistributorService();

        dis.changeRating((Distributor) HelloController.user,rating);
    }
}
