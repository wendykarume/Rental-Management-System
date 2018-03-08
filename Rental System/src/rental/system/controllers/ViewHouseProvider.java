// Class package
package rental.system.controllers;

// Exception handling
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

// SQL imports
import java.sql.ResultSet;

// Java imports
import java.util.ResourceBundle;
import java.net.URL;

// JavaFX imports
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

// Project Imports
import rental.system.models.House;
import rental.system.models.HouseData;

/*
    Class that enables the provider to view houses present. Implements 
    Initializable class that enables it to override Initialize method that will
    set up values before display
*/

public class ViewHouseProvider implements Initializable{
    
    // FXML objects to be used
    @FXML private AnchorPane view_house_provider;
    @FXML private TableView<HouseData> house_view;
    @FXML private TableColumn<HouseData, Integer> house_id;
    @FXML private TableColumn<HouseData, String> house_type;
    @FXML private TableColumn<HouseData, String> house_location;
    @FXML private TableColumn<HouseData, Integer> house_price;
    @FXML private TableColumn<HouseData, String> house_status;
    @FXML private JFXComboBox housestatus;
    @FXML private Label select, choose;
    // Class objects to be used
    House house = new House();
    
    // Observable list to be used
    private final ObservableList<HouseData> housedata = 
            FXCollections.observableArrayList();

    // Overriden method that will load table data before display
    @Override
    public void initialize(URL location, ResourceBundle resources){
     
        try {
            // Setting the cell value corresponding to the data model defined at
            // HouseData class
            house_id.setCellValueFactory(
                    new PropertyValueFactory<>("houseid"));
            house_type.setCellValueFactory(
                    new PropertyValueFactory<>("housetype"));
            house_location.setCellValueFactory(
                    new PropertyValueFactory<>("houselocation"));
            house_price.setCellValueFactory(
                    new PropertyValueFactory<>("houseprice"));
            house_status.setCellValueFactory(
                    new PropertyValueFactory<>("housestatus"));
            
            // Setting the values obtained from the function getHouses() into 
            // the table
            house_view.setItems(getHouses());
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewHouseProvider.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }
    
    // Private method that returns an observable list with data obtained
    // corresponding with the data model defined at HouseData class
    private ObservableList<HouseData> getHouses() throws SQLException{
        
        // Getting the ResultSet from the database containing all the houses
        ResultSet rs = house.allHouses();
        
        // Making sure the ResultSet is not null or it would raise an 
        // SQLException
        if (rs != null){
            // Clearing observable list to store new values
            housedata.clear();
            
            // Looping through the ResultSet getting values by column name
            while (rs.next()){

                int id = rs.getInt("HouseID");
                String type = rs.getString("HouseType");
                String place = rs.getString("HouseLocation");
                int price = rs.getInt("HousePrice");
                String status = rs.getString("HouseStatus");
  
                // Adding the values obtained into the observable list
                housedata.add(new HouseData(id, type, place, price, status));

            }
            // Closing connection
            house.closeConnection();
            
            // Returning the list with values
            return housedata;
            
        }
        // Closing connection
        house.closeConnection();
        
        // Returning null as the ResultSet was empty
        return null;
    
    }
    
    // Private method that displays the addHouse window
    @FXML private void addHouse(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/addhouse.fxml"));
            view_house_provider.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(ViewHouseProvider.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Private method that will facilitate the update of houses by provider
    @FXML private void updateHouse(ActionEvent event) throws SQLException{
        // Clearing alert
        select.setText("");
        choose.setText("");
        
        if (housestatus.getSelectionModel().isEmpty() == true){
            // Alerting provider
            choose.setText("House status required");
            
        }else if(house_view.getSelectionModel().isSelected(house_view.getSelectionModel().getSelectedIndex()) == false){
            // Alerting the provider
            select.setText("Click house to select");
            
        }else{
            // Getting value of the status from the radio button
            String h_status = housestatus.getValue().toString();
            
            // Getting the value of selected items
            String h_type = house_view.getSelectionModel().getSelectedItem().getHousetype();
            String h_place = house_view.getSelectionModel().getSelectedItem().getHouselocation();
            int h_price = house_view.getSelectionModel().getSelectedItem().getHouseprice();

            // Updating on the database
            house.updateHouseStatus(h_status, h_type, h_place, h_price);

            // Closing connection
            house.closeConnection();
            
            // Clearing window if any errors were present
            select.setText("");
            choose.setText("");
            house_view.getSelectionModel().clearSelection();
            housestatus.getSelectionModel().clearSelection();
            // Clearing observable list to store new values
            housedata.clear();
            
            // Refreshing the table from values in the database
            try {
                // Setting the cell value corresponding to the data model defined at
                // HouseData class
                house_id.setCellValueFactory(
                        new PropertyValueFactory<>("houseid"));
                house_type.setCellValueFactory(
                        new PropertyValueFactory<>("housetype"));
                house_location.setCellValueFactory(
                        new PropertyValueFactory<>("houselocation"));
                house_price.setCellValueFactory(
                        new PropertyValueFactory<>("houseprice"));
                house_status.setCellValueFactory(
                        new PropertyValueFactory<>("housestatus"));

                // Setting the values obtained from the function getHouses() into 
                // the table    
                house_view.setItems(getHouses());

            } catch (SQLException ex) {
                Logger.getLogger(ViewHouseProvider.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            
        }  
    }
    
    // Private method that will facilitate the update of houses by provider
    @FXML private void deleteHouse(ActionEvent event) throws SQLException{
        // Clearing alert
        select.setText("");
        
        if (house_view.getSelectionModel().isSelected(house_view.getSelectionModel().getSelectedIndex()) == false){
            // Alerting the provider
            select.setText("Click house to select");
            
        }else{
            // Getting the value of selected items
            String h_type = house_view.getSelectionModel().getSelectedItem().getHousetype();
            String h_place = house_view.getSelectionModel().getSelectedItem().getHouselocation();
            int h_price = house_view.getSelectionModel().getSelectedItem().getHouseprice();
            String h_status = house_view.getSelectionModel().getSelectedItem().getHousestatus();
            
            // Deleting on the database
            house.deleteHouse(h_type, h_place, h_price, h_status);

            // Closing connection
            house.closeConnection();
            
            // Clearing window if any errors were present
            select.setText("");
            choose.setText("");
            house_view.getSelectionModel().clearSelection();
            
            // Clearing observable list to store new values
            housedata.clear();
            
            // Refreshing the table from values in the database
            try {
                // Setting the cell value corresponding to the data model defined at
                // HouseData class
                house_id.setCellValueFactory(
                        new PropertyValueFactory<>("houseid"));
                house_type.setCellValueFactory(
                        new PropertyValueFactory<>("housetype"));
                house_location.setCellValueFactory(
                        new PropertyValueFactory<>("houselocation"));
                house_price.setCellValueFactory(
                        new PropertyValueFactory<>("houseprice"));
                house_status.setCellValueFactory(
                        new PropertyValueFactory<>("housestatus"));

                // Setting the values obtained from the function getHouses() into 
                // the table    
                house_view.setItems(getHouses());

            } catch (SQLException ex) {
                Logger.getLogger(ViewHouseProvider.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            
        }  
    }
    
    // Private method for going back
    @FXML private void back(ActionEvent event){
        
        try{
            AnchorPane pane = FXMLLoader.load(getClass().
                        getResource("/rental/system/views/providerdash.fxml"));
            view_house_provider.getChildren().setAll(pane);
            
        }catch (IOException e){
            // Output exception
            Logger.getLogger(ViewHouseProvider.class.getName()).
                    log(Level.SEVERE, null, e);
            
        }
        
    }
    
    // Exit function
    @FXML private void exit(ActionEvent event){
        
        System.exit(0);
        
    }
    
}
