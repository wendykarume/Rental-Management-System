package rental.system.controllers;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rental.system.models.House;

public class AddHouse {

    Stage primaryStage = new Stage();
    @FXML private AnchorPane add_house;
    @FXML private JFXTextField type, location, status, price;
    
    House house = new House();
    
    @FXML private void add(ActionEvent event) throws Exception{
        
        try{
            house.create();
            house.insert(type.getText(), location.getText(), status.getText(), 
                    price.getText());
        
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/viewhouseprovider.fxml"));
            add_house.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(AddHouse.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
    }
    
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
