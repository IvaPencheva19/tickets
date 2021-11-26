package bg.tuvarna.sit.group5.tickets.presentation.FormActions;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;


public class CloseForm {
    public static void closeForm(ActionEvent event)
    {

        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
