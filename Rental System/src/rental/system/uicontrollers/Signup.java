package rental.system.uicontrollers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Signup extends Application {
    
    @Override
    public void start(Stage primaryStage){
        
        try {
            FXMLLoader loader = new FXMLLoader(); 
            loader.setLocation(getClass().getResource("/rental/system/ui/signup.fxml"));
            Parent root =loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Signup | Rental Management System");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
