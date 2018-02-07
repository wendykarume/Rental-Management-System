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
    public void start(Stage primaryStage){
        // overriding in Application to utilise its functionality
        try {
            FXMLLoader loader = new FXMLLoader(); // obj to load fxml
            loader.setLocation(getClass().getResource(""
                    + "/rental/system/ui/welcome.fxml"));
            // getting the location
            Parent root = loader.load(); // defining root as the Parent
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Mandy | Rental Management System");
        } catch (IOException ex) {
            Logger.getLogger(Controllers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
