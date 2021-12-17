package bg.tuvarna.sit.group5.tickets.presentation.controllers;
import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DistributorAccountInformationController {
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
    @FXML
    private Label rating;

    private DistributorService service=DistributorService.getInstance();

    public void loadDist(){
        Distributor dist=service.getByUsername(HelloController.user.getUsername());
        username.setText(dist.getUsername());
        password.setText(dist.getPassword());
        fname.setText(dist.getFirstname());
        lname.setText(dist.getLastname());
        phone.setText(dist.getPhone());
        email.setText(dist.getEmail());
        honor.setText(dist.getHonor().toString());
        rating.setText(dist.getRating().toString());

    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
}
