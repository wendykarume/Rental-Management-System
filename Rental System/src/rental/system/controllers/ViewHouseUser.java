package rental.system.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHouseUser {

    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    public void show(){
    
    try {
            loader.setLocation(getClass().
                    getResource("/rental/system/ui/viewhouseuser.fxml"));
            // getting the location
            Parent root = loader.load(); // defining root as the Parent
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);// setting the scene
            primaryStage.setTitle("View Houses ~ User | Rental Management System");
            // setting the title
            primaryStage.show(); // displaying the window
            
        } catch (IOException ex) {
            Logger.getLogger(ViewHouseUser.class.getName()).log(Level.SEVERE, null, ex);
            // catching exception if fxml not found
        }
    
    }
    
    public void close(){
        
        primaryStage.close();
        
    }
    
}
