// Class package
package rental.system.controllers;

// Java imports
import java.net.URL;
import java.util.ResourceBundle;

// Exception handling imports
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import rental.system.models.House;

/*
    Class that will facilitate the display of statistics to a provider
*/
public class Stats implements Initializable {
    
    // Objects to be used
    @FXML private PieChart piechart;
    @FXML private AnchorPane stats;
    House house = new House();
    private final ObservableList <PieChart.Data> piechartdata = 
            FXCollections.observableArrayList();   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Get values from database and output
            
            ResultSet rs = house.occupiedHouses();
            
            while (rs.next()){
                
                String type = rs.getString("HouseType");
                int price = rs.getInt("HousePrice");
                
                piechartdata.add(new PieChart.Data(type, price));
               
                
            }
            
            piechart.setData(piechartdata);


        } catch (SQLException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
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
