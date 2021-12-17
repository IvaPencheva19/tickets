package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.time.LocalDate;

public class ViewEventsByDistributorController {
    @FXML
    private Label hello;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    ListView listEvents;
    private EventService service=EventService.getInstance();
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void viewEvents(){
        LocalDate ldate1=fromDate.getValue();
        LocalDate ldate2=toDate.getValue();
        listEvents.getItems().clear();
        ObservableList<EventModel> events = service.getAllByDateDistributor((Distributor) HelloController.user,ldate1,ldate2);
        listEvents.setItems(events);

    }
}
