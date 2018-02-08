package rental.system;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// necessary imports
public class Controllers extends Application {
    // subclassing Application in order to use its methods
    @Override
    public void start(Stage stage){
        // overriding in Application to utilise its functionality
        try {
            // Welcome
            FXMLLoader welcome = new FXMLLoader(); // obj to load fxml
            welcome.setLocation(getClass().
                    getResource("/rental/system/ui/welcome.fxml"));
            Parent root = welcome.load(); // defining root as the welcome
            Scene scene = new Scene(root);
            stage.setScene(scene);// setting the scene
            stage.show(); // displaying the window
            stage.setTitle("Mandy | Rental Management System");

        } catch (IOException ex) {
            Logger.getLogger(Controllers.class.getName()).
                    log(Level.SEVERE, null, ex);
            // catching exception if fxml not found
        }
        
    }
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
