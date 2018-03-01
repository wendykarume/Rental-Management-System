/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author karume wendy
 */
public class UserView {
    
    @FXML private AnchorPane user_view;
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    
    public void show(){

        try {
                loader.setLocation(getClass().getResource(""
                        + "/rental/system/ui/UserView.fxml"));
                // getting the location
                Parent root = loader.load(); // defining root as the Parent
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);// setting the scene
                primaryStage.show(); // displaying the window
                primaryStage.setTitle("View ~ User | Rental Management System");
                // setting the title
        } catch (IOException ex) {
                Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
                // catching exception if fxml not found
            }        

        }
    
    @FXML private void back(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/userdash.fxml"));
            user_view.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(UserView.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
