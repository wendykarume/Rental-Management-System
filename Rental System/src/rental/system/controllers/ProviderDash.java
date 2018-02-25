package rental.system.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author karume wendy
 */
public class ProviderDash{    
    
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(); // obj to load fxml
    AddHouse add = new AddHouse();
    
    ViewHouseProvider view = new ViewHouseProvider();
    
    public void show(){

        try {
                loader.setLocation(getClass().getResource(""
                        + "/rental/system/ui/providerdash.fxml"));
                // getting the location
                Parent provider_dash = loader.load(); // defining root as the Parent
                Scene scene = new Scene(provider_dash);
                primaryStage.setScene(scene);// setting the scene
                primaryStage.show(); // displaying the window
                primaryStage.setTitle("Dash ~ Provider | Rental Management System");
                // setting the title
        } catch (IOException ex) {
                Logger.getLogger(ProviderDash.class.getName()).log(Level.SEVERE, null, ex);
                // catching exception if fxml not found
            }        

        }
    
    public void viewHouses(){
        
        view.show();
        
    }
    
    public void addHouses(){
        
        add.show();
        
    }
    
    @FXML public void close(){
        
        primaryStage.close();
        
    }
    
}
