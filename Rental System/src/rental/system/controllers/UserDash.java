// Class package
package rental.system.controllers;

// imports for exception handling
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/* 
    Public class that facilitates various dashboard needs for the user
*/
public class UserDash {
    
    @FXML private AnchorPane user_dash;
    
    // Private method to view houses as a table
    @FXML private void viewHouses(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                            getResource("/rental/system/views/viewhouseuser.fxml"));
            user_dash.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(UserDash.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
