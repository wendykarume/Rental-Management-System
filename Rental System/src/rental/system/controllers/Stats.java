// Class package
package rental.system.controllers;

// Java imports
import java.net.URL;
import java.util.ResourceBundle;

// Exception handling imports
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/*
    Class that will facilitate the display of statistics to a provider
*/
public class Stats implements Initializable {
    
    // Objects to be used
    @FXML private AnchorPane stats;
    
    // Show the statistics
    @FXML private void showStats(ActionEvent event){
        
        try{
            // Run code and catch exception if there
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/stats.fxml"));
            stats.getChildren().setAll(pane);

        }catch (IOException e){
            // Output the exception
            Logger.getLogger(Stats.class.getName()).
                    log(Level.SEVERE, null, e);

        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
