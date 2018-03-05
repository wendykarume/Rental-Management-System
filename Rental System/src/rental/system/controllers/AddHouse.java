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
import java.sql.ResultSet;
import javafx.scene.control.Label;
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
    @FXML private Label ty_pe, cost, availability, locale, pro_vide;
    
    // Class objects to be used
    House house = new House(); // Database class for houses
     
    // Private method used by FXML button to add new houses
    @FXML private void add(ActionEvent event) throws Exception{
        
        // Setting alert labels empty
        ty_pe.setText("");
        cost.setText("");
        availability.setText("");
        locale.setText("");
        pro_vide.setText("");
        
        try{
            if (type.getLength() == 0){
                
                // Alerting provider
                ty_pe.setText("Required field");
                pro_vide.setText("All fields required");
                
            }else if (place.getLength() == 0){
                
                // Alerting provider
                locale.setText("Required field");
                pro_vide.setText("All fields required");
                
            }else if (status.getLength() == 0){
                
                // Alerting provider
                availability.setText("Required field");
                pro_vide.setText("All fields required");
                
            }else if (price.getLength() == 0){
                
                // Alerting provider
                cost.setText("Required field");
                pro_vide.setText("All fields required");
                
            }else if(checkInt() == false){
                
                // Alerting the provider
                cost.setText("Integer Required");
                
                // Clearing the field
                price.clear();
                
            } else {
                
                ResultSet rs = house.ifHouseExists(type.getText(), 
                        place.getText(), Integer.parseInt(price.getText()));
                // Creating database tables
                
                if (rs != null){
                    
                    // Alerting the provider
                    pro_vide.setText("House Already Exists");
                    ty_pe.setText("Already Exists");
                    locale.setText("Already Exists");
                    cost.setText("Already Exists");
                    
                    // Clearing fields
                    type.clear();
                    place.clear();
                    price.clear();
                    
                    // Closing connection
                    house.closeConnection();
                    
                } else{
                    house.create();

                    // Inserting data into database
                    house.insert(type.getText(), place.getText(), status.getText(), 
                            Integer.parseInt(price.getText()));

                    // Closing connection
                    house.closeConnection();

                    AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/viewhouseprovider.fxml"));
                    add_house.getChildren().setAll(pane);
                }
            }
        
        }catch (IOException e){
            // Output exception
            Logger.getLogger(AddHouse.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
    }
    
    private boolean checkInt(){
        
        try{
            
            Integer.parseInt(price.getText());
            
        }catch(NumberFormatException e){
            
            return false;
            
        }
        
        return true;
    
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
