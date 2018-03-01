package rental.system.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewHouseUser {
    
    @FXML private AnchorPane view_house_user;
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
    
    @FXML private void back(ActionEvent event){
        
        try{
            // Running code to catch exception
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/userdash.fxml"));
            view_house_user.getChildren().setAll(pane);
        }catch (IOException e) {
            // Output exception
            Logger.getLogger(ViewHouseUser.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
