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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

// Project Imports
import rental.system.models.House;
import rental.system.models.HouseData;

/*
    Class that enables the provider to view houses present
*/

public class ViewHouseProvider implements Initializable{
    
    // FXML objects to be used
    @FXML private AnchorPane view_house_provider;
    FXMLLoader loader = new FXMLLoader();
    @FXML private TableView<HouseData> house_view;
    @FXML private TableColumn<HouseData, Integer> house_id;
    @FXML private TableColumn<HouseData, String> house_type;
    @FXML private TableColumn<HouseData, String> house_location;
    @FXML private TableColumn<HouseData, Integer> house_price;
    @FXML private TableColumn<HouseData, String> house_status;
    
    // Class objects to be used
    House house = new House();

    @Override
    public void initialize(URL location, ResourceBundle resources){
     
        try {
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

            house_view.setItems(getHouses());
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewHouseProvider.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }
    
    private ObservableList<HouseData> getHouses() throws SQLException{
        
        ObservableList<HouseData> housedata = 
                FXCollections.observableArrayList();
        
        ResultSet rs = house.allHouses();
        
        if (rs != null){
            
            while (rs.next()){

                int id = rs.getInt("HouseID");
                String type = rs.getString("HouseType");
                String place = rs.getString("HouseLocation");
                int price = rs.getInt("HousePrice");
                String status = rs.getString("HouseStatus");

                housedata.add(new HouseData(id, type, place, price, status));

            }
            
            return housedata;
            
        }
        return null;
    
    }
    
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
