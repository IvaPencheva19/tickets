package bg.tuvarna.sit.group5.tickets.presentation.controllers;


import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.DistributorModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class UpdateDistributorAccountController {
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

    private DistributorService service=new DistributorService();

    public void loadDist() {
        ObservableList<DistributorModel> distributors=service.getAllDistributors();
        loadList.setItems(distributors);
        changeCombo.getItems().addAll("username", "password", "firstname", "lastname", "phone",
                "email","honor", "rating");
    }

     public void changeDistributor(){
        String uname=userName.getText();
        Distributor dist=service.getByUsername(uname);
        String newV = newValue.getText();


        String val= this.newValue.getText();
        String res=this.changeCombo.getValue().toString();

        if(res.equals("username")){
            service.changeUserName(dist, newV);

        }

        if(res.equals("password")){
            service.changePassword(dist, newV);
        }

        if(res.equals("firstname")){
            service.changeFirstName(dist, newV);
        }
        if(res.equals("lastname")){
            service.changeLastName(dist, newV);
        }

        if(res.equals("phone")){
            service.changePhone(dist, newV);
        }

        if(res.equals("email")){
            service.changeEmail(dist, newV);
        }
        if(res.equals("honor")){

            double hon= Double.parseDouble(newV);
            service.changeHonor(dist, hon);
        }
        if(res.equals("rating")){
            double rating = Double.parseDouble((newV));
            service.changeRating(dist, rating);
        }

        newValue.clear();
        userName.clear();
    }

    public void deleteDistributor(){
        String uname=userName.getText();
        Distributor dist=service.getByUsername(uname);

        service.deleteDistributor(dist);
    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);

    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
}
