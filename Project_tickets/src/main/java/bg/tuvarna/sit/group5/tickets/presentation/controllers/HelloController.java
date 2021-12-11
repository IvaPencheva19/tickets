package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.ButtonEffects;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.models.OrganizerModel;
import bg.tuvarna.sit.group5.tickets.presentation.models.HelloModel;
import bg.tuvarna.sit.group5.tickets.service.LoginService;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

//implements EventHandler<MouseEvent>
public class HelloController  {
  /*  @FXML
    private Label welcomeText;

   // private final EventTypeService service=EventTypeService.getInstance();
   private final OrganizerService service=OrganizerService.getInstance();
    @FXML
    private Button helloButton;
    private final HelloModel model;
    @FXML
    //private ListView<EventTypeModel> listView;
    private ListView<OrganizerModel> listView;
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
        ObservableList<OrganizerModel>orgModels=service.getAllOrganizers();
        listView.setItems(orgModels);

    }*/

    private LoginService loginService=new LoginService();
    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label res;
   public static User user;
 @FXML
 private void userLogIn(ActionEvent event){

     String uname = this.username.getText();
     String pass = this.password.getText();

      user = loginService.validateUserLogin(uname, pass);
     if (user != null)
     {
         String name=user.getUsername();
        // res.setText("Hello"+name);
         user.loadController();

         CloseForm.closeForm(event);

     } else
     {
         res.setText("Wrong username or password");
         this.username.clear();
         this.password.clear();
         this.username.requestFocus();
     }
 }


public void makeEffect(){
     ButtonEffects.makeEffect(login);
}
public void removeEffect(){
     ButtonEffects.removeEffect(login);
}





}