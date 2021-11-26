package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Admin;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.apache.log4j.Logger;

public class AdminAccountController {

    private  static final Logger log=Logger.getLogger(DistributorAccountController.class);
    @FXML
    private Label helloDist;
    @FXML
    private Button addOrg;
    @FXML
    private Button addDist;
    private Admin adm;

    public void setUser(User user) {
        adm = (Admin) user;

        helloDist.setText("Welcome " + adm.getUsername());
        log.info("Client with id: " + adm.getIdUser() + " successfully logged in!");
    }
    public void addOrganizer(){
        FXMLLoader loader = OpenForm.openNewForm("AddOrganizerAccountForm.fxml", "Admin");

    }
    public void addDistributor(){
        FXMLLoader loader = OpenForm.openNewForm("AddDistributorAccountForm.fxml", "Admin");

    }


}
