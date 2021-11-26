package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Admin;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.apache.log4j.Logger;

public class AdminAccountController {

    private  static final Logger log=Logger.getLogger(DistributorAccountController.class);
    @FXML
    private Label helloDist;
    private Admin adm;
    public void setUser(User user) {
        adm = (Admin) user;

        helloDist.setText("Welcome " + adm.getUsername());
        log.info("Client with id: " + adm.getIdUser() + " successfully logged in!");
    }
}
