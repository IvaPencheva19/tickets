package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.presentation.models.EventTypeModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.OrganizerModel;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.collections.ObservableList;
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
}
