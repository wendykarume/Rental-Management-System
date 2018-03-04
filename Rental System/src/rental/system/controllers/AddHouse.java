// Class package
package rental.system.controllers;

// Exception handling
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.AnchorPane;

// Class imports
import rental.system.models.House;

/*
    Class failitating the provider in adding houses
*/
public class AddHouse {

    // FXML objects to be used
    @FXML private AnchorPane add_house;
    @FXML private JFXTextField type, place, status, price;
    
    // Class objects to be used
    House house = new House(); // Database class for houses
    
    // Private method used by FXML button to add new houses
    @FXML private void add(ActionEvent event) throws Exception{
        
        try{
            // Creating database tables
            house.create();
            
            // Inserting data into database
            house.insert(type.getText(), place.getText(), status.getText(), 
                    Integer.parseInt(price.getText()));
        
            // Closing connection
            house.closeConnection();
            
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/viewhouseprovider.fxml"));
            add_house.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(AddHouse.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
    }
    
    // Private method for going back
    @FXML private void back(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/providerdash.fxml"));
            add_house.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(AddHouse.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
