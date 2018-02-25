/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.system.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author karume wendy
 */
public class UserDash {
    
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    UserView view = new UserView();
    
    public void show(){

        try {
                loader.setLocation(getClass().getResource(""
                        + "/rental/system/ui/userdash.fxml"));
                // getting the location
                Parent user_dash = loader.load(); // defining root as the Parent
                Scene scene = new Scene(user_dash);
                primaryStage.setScene(scene);// setting the scene
                primaryStage.show(); // displaying the window
                primaryStage.setTitle("Dash ~ User | Rental Management System");
                // setting the title
        } catch (IOException ex) {
                Logger.getLogger(UserDash.class.getName()).log(Level.SEVERE, null, ex);
                // catching exception if fxml not found
            }        

        }
    
    public void viewHouses(){
        
        view.show();
        
    }
    
    @FXML public void close(){
        
        primaryStage.close();
        
    }
    
}
