package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.DistributorModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.EventTypeService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Set;

public class DeleteEventByOrganizerController {
    @FXML
    private Label hello;
    @FXML
    private ListView listEvents;
    @FXML
    private TextField eventToDelete;
    private EventService evserv=new EventService();
    private DistributorService dserv=new DistributorService();
    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }

    public void load(){

        ObservableList<EventModel> events=evserv.getAllEvents();
        listEvents.setItems(events);

    }
    public void deleteEvent(){
        String eventName=eventToDelete.getText();
        Event event=evserv.getByName(eventName);
        Set<Distributor> distributors=event.getDistribEvent();
        for(Distributor d:distributors){
            dserv.removeEvent(d,event);
        }
        evserv.deleteEvent(event);
    }


}
