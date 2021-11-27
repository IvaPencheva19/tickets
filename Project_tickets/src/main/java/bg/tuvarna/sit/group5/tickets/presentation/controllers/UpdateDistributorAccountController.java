package bg.tuvarna.sit.group5.tickets.presentation.controllers;


import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.DistributorModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class UpdateDistributorAccountController {
    @FXML
    private ListView loadList;

    private DistributorService service=new DistributorService();
    public void loadDist() {
        ObservableList<DistributorModel> distributors=service.getAllDistributors();
        loadList.setItems(distributors);
    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
}
