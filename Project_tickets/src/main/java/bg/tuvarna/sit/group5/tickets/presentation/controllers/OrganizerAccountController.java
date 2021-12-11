package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.apache.log4j.Logger;

public class OrganizerAccountController {

    private  static final Logger log=Logger.getLogger(DistributorAccountController.class);
    @FXML
    private Label helloDist;
    @FXML
    private Pane paneIcon;

    private Organizer org;

    public  void setIcon(boolean st){
        paneIcon.setVisible(st);
    }
    public void setUser(User user) {
        org = (Organizer) user;

        helloDist.setText("Welcome " + org.getUsername());
        log.info("Client with id: " + org.getIdUser() + " successfully logged in!");
    }
    public void logOut(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("WelcomeLoginForm.fxml", "Login");
        CloseForm.closeForm(event);
    }
    public void accInfo(ActionEvent event){
        //FXMLLoader loader = OpenForm.openNewForm("OrganizerAccountInformationForm.fxml", "Organizer information");

        FXMLLoader loader = OpenForm.openNewForm("OrganizerAccountInformationForm.fxml", "Organizer info");

        OrganizerAccountInformationController next = loader.getController();
        next.load();
        next.setUser();

        CloseForm.closeForm(event);
    }
    public void manageEvents(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("AddChangeEventOrganizerForm.fxml", "Manage Events");
        AddChangeEventOrganizerController next = loader.getController();
        next.setUser();
        CloseForm.closeForm(event);
    }
    public void viewEvents(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("ViewEventsByOrganizerForm.fxml", "View Events");
        ViewEventsByOrganizerController next = loader.getController();

       next.setUser();

       CloseForm.closeForm(event);

    }

    public void viewDistributors(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("ViewDistributorForm.fxml", "View Distributors");
        ViewDistributorController next = loader.getController();

        next.setUser();

        CloseForm.closeForm(event);

    }
    public void viewNotifications(ActionEvent event){
        FXMLLoader loader = OpenForm.openNewForm("NotificationsOrganizerForm.fxml", "View notifications");
        NotificationsOrganizerController next = loader.getController();
        next.load();
        next.setUser();

        CloseForm.closeForm(event);
    }
}
