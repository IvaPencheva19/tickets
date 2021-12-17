package bg.tuvarna.sit.group5.tickets.presentation.FormActions;

import javafx.scene.control.Alert;

public class ShowWarning {
    public static void showWarning(String warn){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText(warn);
        a.show();
    }

}
