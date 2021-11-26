package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.apache.log4j.Logger;

public class OrganizerAccountController {

    private  static final Logger log=Logger.getLogger(DistributorAccountController.class);
    @FXML
    private Label helloDist;
    private Organizer org;
    public void setUser(User user) {
        org = (Organizer) user;

        helloDist.setText("Welcome " + org.getUsername());
        log.info("Client with id: " + org.getIdUser() + " successfully logged in!");
    }
    public void logOut(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("WelcomeLoginForm.fxml", "Login");
        CloseForm.closeForm(event);
    }
}
