// Class package
package rental.system.controllers;

// Exception handling
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Java imports
import java.net.URL;
import java.util.ResourceBundle;

// SQL imports
import java.sql.ResultSet;

// JavaFX imports
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

// Class imports
import rental.system.models.House;
import rental.system.models.HouseData;

/*
    Class that displays the houses to the User. It implements Initializable 
    class that utilises overriden method Initialize in order to set values into
    the table before display
*/
public class ViewHouseUser implements Initializable{
    
    // FXML objects to be used
    @FXML private AnchorPane view_house_user;
    @FXML private TableView<HouseData> house_view;
    @FXML private TableColumn<HouseData, String> house_type;
    @FXML private TableColumn<HouseData, String> house_location;
    @FXML private TableColumn<HouseData, Integer> house_price;
    @FXML private TableColumn<HouseData, String> house_status;
    
    // Class objects to be used
    House house = new House();
    
    // Observable list to be used
    private ObservableList<HouseData> housedata = 
            FXCollections.observableArrayList();

    // Overriden method that starts up the table with values already set
    @Override
    public void initialize(URL location, ResourceBundle resources){
     
        try {
            // Adding the values into the cells of the table
            house_type.setCellValueFactory(
                    new PropertyValueFactory<>("housetype"));
            house_location.setCellValueFactory(
                    new PropertyValueFactory<>("houselocation"));
            house_price.setCellValueFactory(
                    new PropertyValueFactory<>("houseprice"));
            house_status.setCellValueFactory(
                    new PropertyValueFactory<>("housestatus"));

            // Sets the values into the table obtained from the getHouses()
            // method
            house_view.setItems(getHouses());
        
        } catch (SQLException ex) {
            Logger.getLogger(ViewHouseUser.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }
    
    // Private method that returns an observable list that is fed into the table
    private ObservableList<HouseData> getHouses() throws SQLException{
        
        // ResultSet with houses obtained from the database
        ResultSet rs = house.allHouses();
        
        // Making sure the ResultSet is not null that will throw an SQLException
        if (rs != null){
            // Lopping through the ResultSet getting values by column name
            while (rs.next()){

                String type = rs.getString("HouseType");
                String place = rs.getString("HouseLocation");
                int price = rs.getInt("HousePrice");
                String status = rs.getString("HouseStatus");

                // Adding the values obtained corresponding to the data model
                // defined at HouseData class
                housedata.add(new HouseData(type, place, price, status));

            }
            // Returning the observable list after looping is done
            return housedata;
        }
        // Returning null as the ResultSet was empty
        return null;
        
    }
    
    // Private method for going back
    @FXML private void back(ActionEvent event){
        
        try{
            // Running code to catch exception
            AnchorPane pane = FXMLLoader.load(getClass().
                    getResource("/rental/system/views/userdash.fxml"));
            view_house_user.getChildren().setAll(pane);
        }catch (IOException e) {
            // Output exception
            Logger.getLogger(ViewHouseUser.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
