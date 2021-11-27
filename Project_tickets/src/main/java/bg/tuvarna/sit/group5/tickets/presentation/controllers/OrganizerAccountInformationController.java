package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrganizerAccountInformationController {
    @FXML
    private Label hello;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private Label fname;
    @FXML
    private Label lname;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label honor;

    private OrganizerService service=new OrganizerService();
    public void load(){
        Organizer org=service.getByUsername(HelloController.user.getUsername());
        username.setText(org.getUsername());
        password.setText(org.getPassword());
        fname.setText(org.getFirstname());
        lname.setText(org.getLastname());
        phone.setText(org.getPhone());
        email.setText(org.getEmail());
        honor.setText(org.getHonor().toString());
    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
}
