package bg.tuvarna.sit.group5.tickets.presentation.controllers;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddOrganizerAccountController {

    private OrganizerService orgService=new OrganizerService();

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField honor;
    @FXML
    private Label hello;
    @FXML
    private void addOrganizer(ActionEvent event){

        String uname = this.username.getText();
        String pass = this.password.getText();
        String fn = this.fname.getText();
        String ln = this.lname.getText();
        String ph = this.phone.getText();
        String em = this.email.getText();
       double hon= Double.parseDouble(honor.getText());
        Organizer newOrg= new Organizer(uname,pass,fn,ln,ph,em,hon);
        orgService.createOrganizer(newOrg);
        username.clear();
        password.clear();
        fname.clear();
        lname.clear();
        phone.clear();
        email.clear();

    }
    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }

}
