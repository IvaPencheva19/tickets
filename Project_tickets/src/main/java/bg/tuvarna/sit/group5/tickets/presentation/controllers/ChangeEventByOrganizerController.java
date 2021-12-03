package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.EventTypeService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ChangeEventByOrganizerController {
    @FXML
    private Label hello;
    @FXML
    private ListView listEvents;
    @FXML
    private ComboBox comboChange;
    @FXML
    private ComboBox comboType;

    @FXML
    private TextField newVal;
    @FXML
    private TextField toChange;
    @FXML
    DatePicker datePick;
    private EventService service = new EventService();
    private DistributorService dserv = new DistributorService();

    public void goBack(ActionEvent event) {
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }

    public void setUser() {
        hello.setText(HelloController.user.getUsername());
    }

    public void load() {

        ObservableList<EventModel> events = service.getAllByOrganizer((Organizer)HelloController.user);
        listEvents.setItems(events);
        comboChange.getItems().addAll("name", "description", "date", "time", "place",
                "event type");


    }
   public void comboChoice(){
        if ((this.comboChange.getValue().toString()).equals("event type")) {
            comboType.setVisible(true);
            EventTypeService eserv=new EventTypeService();
            ObservableList<EventTypeModel> types = eserv.getAll();
            comboType.getItems().addAll(types);

        }
        else comboType.setVisible(false);
       if ((this.comboChange.getValue().toString()).equals("date")) {
           datePick.setVisible(true);
       }

    }
    public void changeValue(){
        String val= this.newVal.getText();
        String res=this.comboChange.getValue().toString();
        String toChange=this.toChange.getText();
        Event event=service.getByName(toChange);
        if(res.equals("name")){
            service.changeName(event, val);

        }

        if(res.equals("description")){
            service.changeDescription(event, val);
        }

        if(res.equals("date")){
            LocalDate ldate=datePick.getValue();
            service.changeDate(event,ldate);

        }
        if(res.equals("time")){
            LocalTime ltime=LocalTime.parse(this.newVal.getText());
            service.changeTime(event, ltime);
        }

        if(res.equals("place")){
            service.changePlace(event, val);
        }

        if(res.equals("event type")){
        String etype=comboType.getValue().toString();
        EventTypeService eserv=new EventTypeService();
        EventType typeVal=eserv.getEventByName(etype);
        service.changeType(event,typeVal);
        }

    }

    public void changeStatus(){
        String toChange=this.toChange.getText();
        Event event=service.getByName(toChange);
        if (event.getStatus()==0)
        service.changeStatus(event,(byte) 1);
        else service.changeStatus(event,(byte) 0);
    }
}
