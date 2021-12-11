package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Notifications;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.service.NotificationsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class NotificationsOrganizerController {
    @FXML
    private Label hello;
    @FXML
    private ListView listNotifs;
    private NotificationsService nserv=NotificationsService.getInstance();

    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void load() {
        for (Notifications n : (HelloController.user.getNotifs())) {
            listNotifs.getItems().addAll(n.getMessage());
            nserv.setSeen(n, (byte) 1);
        }
    }

    }
