package rental.system.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Alert implements Initializable {
   
    
    @FXML private AnchorPane alert;
    
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
    @FXML private void back(ActionEvent event){
        
        try{
            // Running code to catch exception
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/welcome.fxml"));
            alert.getChildren().setAll(pane);
            
        }catch (IOException e) {
            // Output exception
            Logger.getLogger(Alert.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        //code
        
    }  
    
}
