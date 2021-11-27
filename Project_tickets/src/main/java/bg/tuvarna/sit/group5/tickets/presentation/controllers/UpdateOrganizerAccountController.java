package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.OrganizerModel;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class UpdateOrganizerAccountController {
    @FXML
    private ListView loadList;

    private OrganizerService service=new OrganizerService();
    public void load() {
        ObservableList<OrganizerModel> organizers=service.getAllOrganizers();
        loadList.setItems(organizers);
    }

    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
}
