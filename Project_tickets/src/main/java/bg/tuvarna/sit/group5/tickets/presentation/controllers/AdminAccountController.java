package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Admin;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import javafx.event.ActionEvent;
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

        helloDist.setText(adm.getUsername());
        log.info("Client with id: " + adm.getIdUser() + " successfully logged in!");
    }
    public void addOrganizer(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("AddOrganizerAccountForm.fxml", "Admin");
        AddOrganizerAccountController next = loader.getController();
        next.setUser();
        CloseForm.closeForm(event);
    }
    public void addDistributor(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("AddDistributorAccountForm.fxml", "Admin-");
        AddDistributorAccountController next = loader.getController();
        next.setUser();
        CloseForm.closeForm(event);

    }
    public void logOut(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("WelcomeLoginForm.fxml", "Login");
        CloseForm.closeForm(event);
    }

    public void changeAccount(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("ChangeAdminAccountForm.fxml", "Admin");
        ChangeAdminAccountController next = loader.getController();
        next.loadCombo();
        CloseForm.closeForm(event);
    }

    public void updateOrganizerAccount(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("UpdateOrganizerAccountForm.fxml", "Update Organizer");
        UpdateOrganizerAccountController next = loader.getController();
        next.load();
        next.setUser();
        CloseForm.closeForm(event);
    }


}
