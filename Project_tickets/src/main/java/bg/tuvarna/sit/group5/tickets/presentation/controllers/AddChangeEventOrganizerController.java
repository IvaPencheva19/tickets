package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class AddChangeEventOrganizerController {
    @FXML
    Label hello;

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
    public void addEvent(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("AddEventByOrganizerForm.fxml", "Manage Events");
        AddEventByOrganizerController next = loader.getController();
        next.setUser();
        next.load();
        CloseForm.closeForm(event);
    }
    public void deleteEvent(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("DeleteEventByOrganizerForm.fxml", "Manage Events");
        DeleteEventByOrganizerController next = loader.getController();
        next.setUser();
       next.load();
        CloseForm.closeForm(event);
    }
    public void changeEvent(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("ChangeEventByOrganizerForm.fxml", "Manage Events");
        ChangeEventByOrganizerController next = loader.getController();
        next.setUser();
       next.load();
        CloseForm.closeForm(event);
    }
    public void manageEventTypes(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("AddDeleteEventType.fxml", "Manage Event Types");
        AddDeleteEventTypeController next = loader.getController();
        next.setUser();
        next.load();
        CloseForm.closeForm(event);
    }

}
