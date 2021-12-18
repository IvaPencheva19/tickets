package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.EventType;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import bg.tuvarna.sit.group5.tickets.service.EventTypeService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddDeleteEventTypeController {
    @FXML
    private Label hello;
    @FXML
    private ListView loadList;
    @FXML
    private TextField typeVal;
    private EventTypeService etserv=EventTypeService.getInstance();

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
    public void load(){
        ObservableList<EventTypeModel> types=etserv.getAll();
        loadList.getItems().addAll(types);
    }
    public void addType(){
        String newType=typeVal.getText();
        EventType toAdd=new EventType(newType);
        etserv.createEventType(toAdd);
        loadList.getItems().add(toAdd.getTypeNamel());
    }
    public void deleteType(){
        String newType=typeVal.getText();
        EventType toDelete= etserv.getEventByName(newType);
        etserv.deleteEventType(toDelete);
    }
}
