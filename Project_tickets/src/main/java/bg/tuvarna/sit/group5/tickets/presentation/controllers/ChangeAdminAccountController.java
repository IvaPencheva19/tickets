package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Admin;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.service.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeAdminAccountController {
    @FXML
    private ComboBox changeCombo;
    @FXML
    private TextField newValue;
    @FXML
    private Label hello;
    public void loadCombo(){
        changeCombo.getItems().addAll("username", "password", "firstname", "lastname", "phone",
                "email");
    }
    private AdminService admSer= AdminService.getInstance();
    private Admin adm=(Admin)HelloController.user;
    public void changeValue(){
        String val= this.newValue.getText();
        String res=this.changeCombo.getValue().toString();

        if(res.equals("username")){
           admSer.changeUserName(adm, val);
           newValue.clear();
        }

        if(res.equals("password")){
            admSer.changePassword(adm, val);
            newValue.clear();
        }

        if(res.equals("firstname")){
            admSer.changeFirstName(adm, val);
            newValue.clear();
        }
        if(res.equals("lastname")){
            admSer.changeLastName(adm, val);
            newValue.clear();
        }

        if(res.equals("phone")){
            admSer.changePhone(adm, val);
            newValue.clear();
        }

        if(res.equals("email")){
            admSer.changeEmail(adm, val);
            newValue.clear();
        }
        newValue.clear();
    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }



}
