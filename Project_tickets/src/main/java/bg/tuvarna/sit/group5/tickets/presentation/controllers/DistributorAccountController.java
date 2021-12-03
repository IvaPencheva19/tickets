package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.application.HelloApplication;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import org.apache.log4j.Logger;

import java.io.IOException;

public class DistributorAccountController {
    private  static final Logger log=Logger.getLogger(DistributorAccountController.class);
    @FXML
    private Label helloDist;
    private Distributor dist;
    public void setUser(User user) {
        dist = (Distributor) user;

        helloDist.setText("Welcome " + dist.getUsername());
        log.info("Client with id: " + dist.getIdUser() + " successfully logged in!");
    }
    public void logOut(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("WelcomeLoginForm.fxml", "Login");
        CloseForm.closeForm(event);
    }
    public void accInfo(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("DistributorAccountInformationForm.fxml", "Distributor info");
        DistributorAccountInformationController next = loader.getController();
        next.loadDist();
        next.setUser();

        CloseForm.closeForm(event);
    }
}
