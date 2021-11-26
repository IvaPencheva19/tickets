package bg.tuvarna.sit.group5.tickets.application;

import bg.tuvarna.sit.group5.tickets.common.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private  static final Logger log=Logger.getLogger(HelloApplication.class);
    public static Parent root;
    public static AnchorPane pane;
    @Override
    public void start(Stage stage) throws IOException {


        PropertyConfigurator.configure(HelloApplication.class.getResource(Constants.Configurations.LOG4J_PROPERTIES));
        URL path= getClass().getResource(Constants.View.HELLO_VIEW);

        if(path!=null){
             root= FXMLLoader.load(path);

            Scene scene = new Scene(root);

            stage.setScene(scene);
            /*stage.setResizable(false);
            stage.setMaxWidth(1280);
            stage.setMaxHeight(800);
            stage.setWidth(1280);
            stage.setHeight(800);*/
            stage.show();
        }

        else{
            log.error("Error main");
            System.exit(-1);
        }
    }

    public void changeScene(){

    }

    public static void main(String[] args) {
        launch();
    }
}