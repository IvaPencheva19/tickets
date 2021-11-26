package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddDistributorAccountController {
    private DistributorService distService=new DistributorService();
    @FXML
    private Button add;
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
    Label hello;
    @FXML
    private void addDistributor(ActionEvent event){

        String uname = this.username.getText();
        String pass = this.password.getText();
        String fn = this.fname.getText();
        String ln = this.lname.getText();
        String ph = this.phone.getText();
        String em = this.email.getText();
        double hon= Double.parseDouble(honor.getText());
        Distributor newOrg= new Distributor(uname,pass,fn,ln,ph,em,hon,0.0);
        distService.createDistributor(newOrg);

    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
}
