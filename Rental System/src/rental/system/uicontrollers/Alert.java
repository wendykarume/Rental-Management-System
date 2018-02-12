package rental.system.uicontrollers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert implements Initializable {
    
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    @FXML private Label title;
    @FXML private Label text;
    
    String msg, ttle;
    
    public void display(String title, String message){

        try {
                msg = message;
                ttle = title;
                loader.setLocation(getClass().
                        getResource("/rental/system/ui/alert.fxml"));
                // getting the location
                Parent alert = loader.load(); // defining root as the Parent
                Scene scene = new Scene(alert);
                primaryStage.setScene(scene);// setting the scene
                primaryStage.setTitle(title);
                // setting the title
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.show(); // displaying the window

            } catch (IOException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                // catching exception if fxml not found
            }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        title.setText(ttle);
        text.setText(msg);
        
    }  
    
}
