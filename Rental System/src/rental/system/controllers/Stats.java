// Class package
package rental.system.controllers;

// Java imports
import java.net.URL;
import java.util.ResourceBundle;

// SQL imports
import java.sql.ResultSet;

// Exception handling imports
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// JavaFX imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;

// Class imports
import rental.system.models.House;

/*
    Class that will facilitate the display of statistics to a provider. Utilises
    Initializable class that will enable it to override initialize class that 
    ensures the pie chart starts up with values
*/
public class Stats implements Initializable {
    
    // FXML Objects to be used
    @FXML private PieChart piechart;
    @FXML private AnchorPane stats;
    
    // Class objects to be used
    House house = new House();
    
    // Observable list instance to be used
    private final ObservableList <PieChart.Data> piechartdata = 
            FXCollections.observableArrayList();   

    // Overriden method for initialising of values before display
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Get values from database in a ResultSet
            ResultSet rs = house.occupiedHouses();
            
            // Loop through the ResultSet, getting values by columns
            while (rs.next()){
                
                String type = rs.getString("HouseType");
                int price = rs.getInt("HousePrice");
                
                // Adding values obtained to the list
                piechartdata.add(new PieChart.Data(type, price));
                
            }
            // Closing the connection
            house.closeConnection();
            
            // Adding the data in the list into the pie chart
            piechart.setData(piechartdata);

        } catch (SQLException ex) {
            
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    }
    
    // Private method for going back
    @FXML private void back(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/providerdash.fxml"));
            stats.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(Stats.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
