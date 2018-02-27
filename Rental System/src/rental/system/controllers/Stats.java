// Class package
package rental.system.controllers;

// Java imports
import java.net.URL;
import java.util.ResourceBundle;

// Exception handling imports
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

/*
    Class that will facilitate the display of statistics to a provider
*/
public class Stats implements Initializable {
    
    // Objects to be used
    @FXML private PieChart piechart;
    @FXML private AnchorPane stats;
    
    @FXML private void back(ActionEvent event){
        
    }
    
    @FXML private void logout(ActionEvent event){
        
    }
    
    @FXML private void close(ActionEvent event){
        
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Get values from database and output
        ObservableList <PieChart.Data> piechartdata =
                                                FXCollections.observableArrayList(
        new PieChart.Data("Executed", 60),
        new PieChart.Data("Passed", 25),
        new PieChart.Data("Fails", 15));
        piechart.setData(piechartdata);
    }    
    
}
