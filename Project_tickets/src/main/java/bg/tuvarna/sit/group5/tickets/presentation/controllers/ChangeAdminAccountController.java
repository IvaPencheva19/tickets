package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ChangeAdminAccountController {
    @FXML
    private ComboBox changeCombo;
    public void loadCombo(){
        changeCombo.getItems().addAll("username", "password", "firstname", "lastname", "phone",
                "email");
    }
    public void changeValue(){
        
    }



}
