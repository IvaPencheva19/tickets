package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.presentation.models.AllOrganizerModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.HelloModel;
import bg.tuvarna.sit.group5.tickets.service.UserService;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class HelloController implements EventHandler<MouseEvent> {
    @FXML
    private Label welcomeText;

   // private final EventTypeService service=EventTypeService.getInstance();
   private final UserService service=UserService.getInstance();
    @FXML
    private Button helloButton;
    private final HelloModel model;
    @FXML
    //private ListView<EventTypeModel> listView;
    private ListView<AllOrganizerModel> listView;
    public HelloController() {
        this.model = new HelloModel();
    }

    @FXML
    private void initialize(){
        helloButton.setOnMouseClicked(this::handle);
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        welcomeText.setText(model.getWelcomeMessage());
       // ObservableList<EventTypeModel>eventTypeModels=service.getAll();
      // ObservableList<EventTypeModel>eventTypeModels=service.getType();
        ObservableList<AllOrganizerModel>orgModels=service.getAllOrganizers();
        listView.setItems(orgModels);

    }
}