package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.OrganizerModel;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class UpdateOrganizerAccountController {
    @FXML
    private ListView loadList;
    @FXML
    private Label hello;
    @FXML
    private TextField userName;
    @FXML
    private TextField newValue;
    @FXML
    private ComboBox changeCombo;

    private OrganizerService service=new OrganizerService();

    public void load() {
        ObservableList<OrganizerModel> organizers=service.getAllOrganizers();
        loadList.setItems(organizers);
        changeCombo.getItems().addAll("username", "password", "firstname", "lastname", "phone",
                "email","honor");
    }
    public void changeOrganizer(){
        String uname=userName.getText();
        Organizer org=service.getByUsername(uname);
        String newVal=newValue.getText();


        String val= this.newValue.getText();
        String res=this.changeCombo.getValue().toString();

        if(res.equals("username")){
            service.changeUserName(org, newVal);

        }

        if(res.equals("password")){
            service.changePassword(org, newVal);
        }

        if(res.equals("firstname")){
            service.changeFirstName(org, newVal);
        }
        if(res.equals("lastname")){
            service.changeLastName(org, newVal);
        }

        if(res.equals("phone")){
            service.changePhone(org, newVal);
        }

        if(res.equals("email")){
            service.changeEmail(org, newVal);
        }
        if(res.equals("honor")){

            double hon= Double.parseDouble(newVal);
            service.changeHonor(org, hon);
        }

        newValue.clear();
        userName.clear();
    }
    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }

}
